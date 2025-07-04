package com.salton123.uninstaller;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.salton123.log.XLog;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.salton123.uninstaller.adapter.SpeedUpAdapter;
import com.salton123.uninstaller.entity.AppEntity;

import com.salton123.uninstaller.util.Utils;
import com.salton123.uninstaller.util.BackupManager;
import com.salton123.uninstaller.util.SettingsManager;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsImmersionAtivity implements SearchView.OnQueryTextListener {

    private static final int REQUEST_PERMISSIONS = 1001;
    // UI控件
    private Button btnDelete, btnBackup, btnBackupManager;
    private ImageButton btnSettings;
    private EditText etSearch;
    private CheckBox checkboxSelectAll;
    private LinearLayout rootView;
    private TextView titleText;
    private TextView summaryTotalText;
    private TextView summarySelectedText;
    private ListView appListView;
    private PopupWindow currentPopupWindow;
    // 数据
    private SpeedUpAdapter mAdapter;
    private List<AppEntity> allEntity = new ArrayList<>();
    private SettingsManager settingsManager;
    private int asc = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        XLog.i(this, "MainActivity onCreate");
        
        // 初始化控件
        rootView = findViewById(R.id.rootView);
        titleText = findViewById(R.id.title_text);
        summaryTotalText = findViewById(R.id.summary_total);
        summarySelectedText = findViewById(R.id.summary_selected);
        etSearch = findViewById(R.id.etSearch);
        appListView = findViewById(R.id.appListView);
        btnDelete = findViewById(R.id.btn_left);
        btnBackup = findViewById(R.id.btn_right);
        btnBackupManager = findViewById(R.id.btn_backup_manager);
        btnSettings = findViewById(R.id.btn_settings);
        checkboxSelectAll = findViewById(R.id.checkbox_select_all);
        // 初始化设置管理器
        settingsManager = new SettingsManager(this);
        // 权限检查
        if (checkAndRequestPermissions()) {
            initUIAndData();
        }
    }

    private boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

            boolean allGranted = true;
            for (String permission : permissions) {
                if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }

            if (!allGranted) {
                requestPermissions(permissions, REQUEST_PERMISSIONS);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }
            
            if (allGranted) {
                initUIAndData();
            } else {
                XLog.e(this, "权限被拒绝");
            }
        }
    }

    private void initUIAndData() {
        // 事件绑定
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAction(ActionCode.CODE_DELETE);
            }
        });
        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAction(ActionCode.CODE_BACKUP);
            }
        });
        btnBackupManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackupManager();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingsDialog();
            }
        });
        checkboxSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheckAll(isChecked);
            }
        });
        applySettings();
        loadData();
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(this);
        if (settingsManager != null) {
            mAdapter.setDisplayOptions(
                    settingsManager.isShowTime(),
                    settingsManager.isShowFilename(),
                    settingsManager.isShowPath()
            );
            XLog.i("MainActivity", "Set initial display options on adapter");
        }
        appListView.setAdapter(mAdapter);
        mAdapter.setOnSelectionChangeListener(new SpeedUpAdapter.OnSelectionChangeListener() {
            @Override
            public void onSelectionChanged() {
                updateButtonStates();
            }
        });
        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppEntity entity = mAdapter.getItem(position);
                toggleAppSelection(entity);
                mAdapter.notifyDataSetChanged();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                allEntity.clear();
                allEntity.addAll(PreloadCore.INSTANCE.preloadAppList());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateSort(allEntity);
                        updateButtonStates();
                        XLog.i("MainActivity", "Loaded " + allEntity.size() + " apps");
                    }
                });
            }
        }).start();
    }

    private void toggleAppSelection(AppEntity entity) {
        if (entity != null) {
            entity.isChecked = !entity.isChecked;
            String status = entity.isChecked ? "选中" : "取消选中";
            XLog.i("MainActivity", status + "应用: " + entity.mAppName);
            Toast.makeText(this, status + ": " + entity.mAppName, Toast.LENGTH_SHORT).show();
            updateButtonStates();
        }
    }

    private void updateButtonStates() {
        if (mAdapter == null) return;
        int selectedCount = getSelectedApps().size();
        int totalCount = mAdapter.getCount();
        if (titleText != null) {
            titleText.setText("应用管理");
        }
        updateSummaryInfo(totalCount, selectedCount);
        if (btnDelete != null) {
            if (selectedCount > 0) {
                btnDelete.setText("删除(" + selectedCount + ")");
                btnDelete.setEnabled(true);
            } else {
                btnDelete.setText("删除");
                btnDelete.setEnabled(false);
            }
        }
        if (btnBackup != null) {
            if (selectedCount > 0) {
                btnBackup.setText("备份(" + selectedCount + ")");
                btnBackup.setEnabled(true);
            } else {
                btnBackup.setText("备份");
                btnBackup.setEnabled(false);
            }
        }
    }

    private void updateSummaryInfo(int totalCount, int selectedCount) {
        XLog.i("MainActivity", "updateSummaryInfo - 总数: " + totalCount + ", 已选择: " + selectedCount);
        if (summaryTotalText != null) {
            summaryTotalText.setText("总数: " + totalCount + "个");
        }
        if (summarySelectedText != null) {
            if (selectedCount > 0) {
                summarySelectedText.setText("已选择: " + selectedCount + "个");
                summarySelectedText.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                summarySelectedText.setText("已选择: 0个");
                summarySelectedText.setTextColor(getResources().getColor(R.color.text_secondary));
            }
        }
        if (checkboxSelectAll != null) {
            checkboxSelectAll.setOnCheckedChangeListener(null);
            if (totalCount > 0 && selectedCount == totalCount) {
                checkboxSelectAll.setChecked(true);
            } else {
                checkboxSelectAll.setChecked(false);
            }
            checkboxSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    onCheckAll(isChecked);
                }
            });
        }
        XLog.i("MainActivity", "统计信息更新完成");
    }

    private List<AppEntity> getSelectedApps() {
        List<AppEntity> selectedApps = new ArrayList<>();
        if (mAdapter != null) {
            for (AppEntity app : mAdapter.getList()) {
                if (app.isChecked) {
                    selectedApps.add(app);
                    XLog.d("MainActivity", "选中的应用: " + app.mAppName);
                }
            }
        }
        XLog.i("MainActivity", "总共选中 " + selectedApps.size() + " 个应用");
        return selectedApps;
    }

    private void onCheckAll(boolean checked) {
        if (mAdapter != null) {
            for (AppEntity app : mAdapter.getList()) {
                app.isChecked = checked;
            }
            mAdapter.notifyDataSetChanged();
            updateButtonStates();
            String message = checked ? getString(R.string.select_all_apps, mAdapter.getCount()) : getString(R.string.unselect_all_apps);
            XLog.i("MainActivity", message);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    private void openBackupManager() {
        Intent intent = new Intent(this, BackupActivity.class);
        startActivity(intent);
    }

    private void showSettingsDialog() {
        if (this == null) return;
        if (currentPopupWindow != null && currentPopupWindow.isShowing()) {
            currentPopupWindow.dismiss();
            currentPopupWindow = null;
            XLog.i("MainActivity", "Dismissed existing popup window");
            return;
        }
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_settings, null);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int popupWidth = screenWidth * 2 / 5;
        currentPopupWindow = new PopupWindow(popupView, popupWidth, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        currentPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.dialog_holo_light_frame));
        currentPopupWindow.setOutsideTouchable(true);
        currentPopupWindow.setFocusable(true);
        currentPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                currentPopupWindow = null;
                XLog.i("MainActivity", "PopupWindow dismissed and reference cleared");
            }
        });
        CheckBox cbShowTime = popupView.findViewById(R.id.cb_show_time);
        CheckBox cbShowFilename = popupView.findViewById(R.id.cb_show_filename);
        CheckBox cbShowPath = popupView.findViewById(R.id.cb_show_path);
        CheckBox cbShowSearch = popupView.findViewById(R.id.cb_show_search);
        RadioGroup rgSortOptions = popupView.findViewById(R.id.rg_sort_options);
        Button btnShareAppDetails = popupView.findViewById(R.id.btn_share_app_details);
        cbShowTime.setChecked(settingsManager.isShowTime());
        cbShowFilename.setChecked(settingsManager.isShowFilename());
        cbShowPath.setChecked(settingsManager.isShowPath());
        cbShowSearch.setChecked(settingsManager.isShowSearch());
        SettingsManager.SortType currentSort = settingsManager.getSortType();
        switch (currentSort) {
            case NAME:
                rgSortOptions.check(R.id.rb_sort_name);
                break;
            case SIZE:
                rgSortOptions.check(R.id.rb_sort_size);
                break;
            case TIME:
                rgSortOptions.check(R.id.rb_sort_time);
                break;
            case PATH:
                rgSortOptions.check(R.id.rb_sort_path);
                break;
        }
        cbShowTime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowTime(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show time: " + isChecked);
        });
        cbShowFilename.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowFilename(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show filename: " + isChecked);
        });
        cbShowPath.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowPath(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show path: " + isChecked);
        });
        cbShowSearch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowSearch(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show search: " + isChecked);
        });
        rgSortOptions.setOnCheckedChangeListener((group, checkedId) -> {
            SettingsManager.SortType newSortType = SettingsManager.SortType.NAME;
            if (checkedId == R.id.rb_sort_name) {
                newSortType = SettingsManager.SortType.NAME;
            } else if (checkedId == R.id.rb_sort_size) {
                newSortType = SettingsManager.SortType.SIZE;
            } else if (checkedId == R.id.rb_sort_time) {
                newSortType = SettingsManager.SortType.TIME;
            } else if (checkedId == R.id.rb_sort_path) {
                newSortType = SettingsManager.SortType.PATH;
            }
            settingsManager.setSortType(newSortType);
            applySettings();
            XLog.i("MainActivity", "Sort type changed: " + newSortType.name());
        });
        btnShareAppDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareSelectedAppApk();
                if (currentPopupWindow != null) {
                    currentPopupWindow.dismiss();
                }
            }
        });
        int[] location = new int[2];
        btnSettings.getLocationOnScreen(location);
        int xOffset = btnSettings.getWidth() - popupWidth;
        int yOffset = 0;
        currentPopupWindow.showAsDropDown(btnSettings, xOffset, yOffset);
        XLog.i("MainActivity", "PopupWindow shown at position: " + xOffset + ", " + yOffset);
    }

    private void applySettings() {
        if (settingsManager == null) return;
        XLog.i("MainActivity", "Applying settings - Time: " + settingsManager.isShowTime() +
                ", Filename: " + settingsManager.isShowFilename() + ", Path: " + settingsManager.isShowPath() +
                ", Search: " + settingsManager.isShowSearch());
        int visibility = settingsManager.isShowSearch() ? View.VISIBLE : View.GONE;
        etSearch.setVisibility(visibility);
        if (mAdapter != null) {
            mAdapter.setDisplayOptions(
                    settingsManager.isShowTime(),
                    settingsManager.isShowFilename(),
                    settingsManager.isShowPath()
            );
            mAdapter.notifyDataSetChanged();
            XLog.i("MainActivity", "Adapter display options updated");
        }
    }

    private void updateSort(List<AppEntity> entities) {
        mAdapter.addAll(entities);
        mAdapter.notifyDataSetChanged();
        updateButtonStates();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Utils.KEY = query.trim();
        updateSort(Utils.getSearchResult(mAdapter.getList(), query));
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Utils.KEY = newText.trim();
        updateSort(Utils.getSearchResult(allEntity, newText.trim()));
        return true;
    }

    private void onAction(Integer actionCode) {
        switch (actionCode) {
            case ActionCode.CODE_DELETE:
                deleteSelectedApps();
                break;
            case ActionCode.CODE_BACKUP:
                startBackupTask();
                break;
        }
    }

    private void deleteSelectedApps() {
        List<AppEntity> selectedApps = getSelectedApps();
        if (selectedApps.isEmpty()) {
            Toast.makeText(this, getString(R.string.select_apps_first), Toast.LENGTH_SHORT).show();
            return;
        }
        for (AppEntity app : selectedApps) {
            Utils.uninstallApk(this, app.appInfo.packageName, 0);
        }
        onCheckAll(false);
    }

    private void startBackupTask() {
        List<AppEntity> selectedApps = getSelectedApps();
        if (selectedApps.isEmpty()) {
            Toast.makeText(this, getString(R.string.select_apps_first), Toast.LENGTH_SHORT).show();
            return;
        }
        BackupManager.toBackup(selectedApps, new BackupManager.IBackupProgress() {
            @Override
            public void onProgress(int current, int total, boolean isSuccess, String appName) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String status = isSuccess ? "成功" : "失败";
                        XLog.i("MainActivity", "备份进度: " + current + "/" + total + " - " + appName + " " + status);
                    }
                });
            }

            @Override
            public void onBackupComplete(boolean success, String message) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        XLog.i("MainActivity", "备份完成: " + message);
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                        onCheckAll(false);
                    }
                });
            }
        });
    }

    private void shareSelectedAppApk() {
        List<AppEntity> selectedApps = getSelectedApps();
        if (selectedApps.isEmpty()) {
            Toast.makeText(this, getString(R.string.select_apps_first), Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayList<Uri> uris = new ArrayList<>();
        for (AppEntity app : selectedApps) {
            File apkFile = new File(app.appInfo.applicationInfo.sourceDir);
            Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", apkFile);
            uris.add(uri);
        }
        Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.setType("application/vnd.android.package-archive");
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            startActivity(Intent.createChooser(shareIntent, "分享应用APK"));
            XLog.i("MainActivity", "Shared APKs for " + selectedApps.size() + " apps");
        } catch (Exception e) {
            XLog.e("MainActivity", "Error sharing APKs: " + e.getMessage());
            Toast.makeText(this, getString(R.string.share_failed), Toast.LENGTH_SHORT).show();
        }
    }
}