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
import android.widget.ImageView;
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
import com.salton123.uninstaller.util.ThemeHelper;

import java.io.File;
import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import android.text.Editable;
import android.text.TextWatcher;
import android.os.Environment;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.io.Serializable;

import android.widget.ProgressBar;

public class MainActivity extends AbsImmersionAtivity {

    private static final int REQUEST_PERMISSIONS = 1001;
    // UI控件
    private Button btnDelete, btnBackup;
    private ImageButton btnSettings;
    private EditText etSearch;
    private CheckBox checkboxSelectAll;
    private LinearLayout llSearch;
    private TextView titleText;
    private ImageView ivAppLogo;
    private TextView summaryTotalText;
    private ImageButton btn_filter;
    private ListView appListView;
    private PopupWindow currentPopupWindow;
    // 数据
    private SpeedUpAdapter mAdapter;
    private List<AppEntity> allEntity = new ArrayList<>();
    private SettingsManager settingsManager;
    private int asc = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 应用主题设置
        ThemeHelper.initTheme(this);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleText = findViewById(R.id.title_text);
        ivAppLogo = findViewById(R.id.iv_app_logo);
        summaryTotalText = findViewById(R.id.summary_total);
        btn_filter = findViewById(R.id.btn_filter);
        etSearch = findViewById(R.id.etSearch);
        llSearch = findViewById(R.id.llSearch);
        appListView = findViewById(R.id.appListView);
        btnDelete = findViewById(R.id.btn_left);
        btnBackup = findViewById(R.id.btn_right);
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
        ArrayList<String> permissionsList = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android 6.0及以上需要动态申请存储权限
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }

            // 如果是Android 10以下，还需要写入权限
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    permissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
            }

            // Android 11及以上针对多媒体文件的权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // 对于备份APK可能会使用到READ_MEDIA相关权限
                if (checkSelfPermission(Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                    permissionsList.add(Manifest.permission.READ_MEDIA_IMAGES);
                }
            }

            if (!permissionsList.isEmpty()) {
                requestPermissions(permissionsList.toArray(new String[0]), REQUEST_PERMISSIONS);
                return false;
            }
        }

        // 权限已授予或Android 5.1及以下版本
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
        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSettingsDialog();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsActivity.start(MainActivity.this);
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

        // 搜索框监听
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().trim();
                Utils.KEY = query;
                updateSort(Utils.getSearchResult(allEntity, query));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // 添加焦点监听
        etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                etSearch.setCursorVisible(hasFocus);
            }
        });
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(this);
        if (settingsManager != null) {
            mAdapter.setDisplayOptions(
                    settingsManager.isShowTime(),
                    settingsManager.isShowPackage()
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
            String status = entity.isChecked ? getString(R.string.main_selected) : getString(R.string.main_unselected);
            XLog.i("MainActivity", status + getString(R.string.main_select) + ": " + entity.mAppName);
            Toast.makeText(this, status + ": " + entity.mAppName, Toast.LENGTH_SHORT).show();
            updateButtonStates();
        }
    }

    private void updateButtonStates() {
        if (mAdapter == null) return;
        int selectedCount = getSelectedApps().size();
        int totalCount = mAdapter.getCount();
        if (titleText != null) {
            titleText.setText(getString(R.string.main_title));
        }
        updateSummaryInfo(totalCount, selectedCount);
        if (btnDelete != null) {
            btnDelete.setEnabled(selectedCount > 0);
            btnDelete.setText(getString(R.string.main_uninstall));
        }
        if (btnBackup != null) {
            btnBackup.setEnabled(selectedCount > 0);
            btnBackup.setText(getString(R.string.main_backup));
        }
        if (summaryTotalText != null) {
            summaryTotalText.setText(getString(R.string.main_total_and_selected_count, totalCount,selectedCount));
        }
    }

    private void updateSummaryInfo(int totalCount, int selectedCount) {
        XLog.i("MainActivity", "updateSummaryInfo - 总数: " + totalCount + ", 已选择: " + selectedCount);
        if (summaryTotalText != null) {
            summaryTotalText.setText(getString(R.string.main_total_and_selected_count, totalCount,selectedCount));
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
        CheckBox cbShowPackage = popupView.findViewById(R.id.cb_show_package);
        CheckBox cbShowSearch = popupView.findViewById(R.id.cb_show_search);
        RadioGroup rgSortOptions = popupView.findViewById(R.id.rg_sort_options);
        Button btnShareAppDetails = popupView.findViewById(R.id.btn_share_app_details);
        cbShowTime.setChecked(settingsManager.isShowTime());
        cbShowPackage.setChecked(settingsManager.isShowPackage());
        cbShowSearch.setChecked(settingsManager.isShowSearch());
        SettingsManager.SortType currentSort = settingsManager.getSortType();
        switch (currentSort) {
            case NAME_ASC:
                rgSortOptions.check(R.id.rb_sort_name_asc);
                break;
            case NAME_DESC:
                rgSortOptions.check(R.id.rb_sort_name_desc);
                break;
            case SIZE_ASC:
                rgSortOptions.check(R.id.rb_sort_size_asc);
                break;
            case SIZE_DESC:
                rgSortOptions.check(R.id.rb_sort_size_desc);
                break;
            case TIME_ASC:
                rgSortOptions.check(R.id.rb_sort_time_asc);
                break;
            case TIME_DESC:
                rgSortOptions.check(R.id.rb_sort_time_desc);
                break;
        }
        cbShowTime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowTime(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show time: " + isChecked);
        });
        cbShowPackage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowPackage(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show package: " + isChecked);
        });
        cbShowSearch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowSearch(isChecked);
            applySettings();
            XLog.i("MainActivity", "Show search: " + isChecked);
        });
        rgSortOptions.setOnCheckedChangeListener((group, checkedId) -> {
            SettingsManager.SortType newSortType = SettingsManager.SortType.NAME_ASC;
            if (checkedId == R.id.rb_sort_name_asc) {
                newSortType = SettingsManager.SortType.NAME_ASC;
            } else if (checkedId == R.id.rb_sort_name_desc) {
                newSortType = SettingsManager.SortType.NAME_DESC;
            } else if (checkedId == R.id.rb_sort_size_asc) {
                newSortType = SettingsManager.SortType.SIZE_ASC;
            } else if (checkedId == R.id.rb_sort_size_desc) {
                newSortType = SettingsManager.SortType.SIZE_DESC;
            } else if (checkedId == R.id.rb_sort_time_asc) {
                newSortType = SettingsManager.SortType.TIME_ASC;
            } else if (checkedId == R.id.rb_sort_time_desc) {
                newSortType = SettingsManager.SortType.TIME_DESC;
            }
            settingsManager.setSortType(newSortType);
            applySettings();
            XLog.i("MainActivity", "Sort type changed: " + newSortType.name());
        });
        btnShareAppDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<AppEntity> selectedApps = getSelectedApps();
                if (selectedApps.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.select_apps_first), Toast.LENGTH_SHORT).show();
                    return;
                }
                
                // 如果选择了多个应用，只分享第一个
                if (selectedApps.size() > 1) {
                    Toast.makeText(MainActivity.this, getString(R.string.share_single_app_only), Toast.LENGTH_SHORT).show();
                }
                
                AppEntity appToShare = selectedApps.get(0);
                shareAppDetails(appToShare);
                
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
                ", Package: " + settingsManager.isShowPackage() +
                ", Search: " + settingsManager.isShowSearch());
        int visibility = settingsManager.isShowSearch() ? View.VISIBLE : View.GONE;
        llSearch.setVisibility(visibility);

        // 应用排序设置
        if (mAdapter != null && !allEntity.isEmpty()) {
            updateSort(allEntity);
        }

        // 应用显示设置
        if (mAdapter != null) {
            mAdapter.setDisplayOptions(
                    settingsManager.isShowTime(),
                    settingsManager.isShowPackage()
            );
            mAdapter.notifyDataSetChanged();
            XLog.i("MainActivity", "Adapter display options updated");
        }
    }

    private void updateSort(List<AppEntity> entities) {
        // 根据设置的排序类型进行排序
        SettingsManager.SortType sortType = settingsManager.getSortType();
        switch (sortType) {
            case SIZE_ASC:
                // 按大小升序
                Collections.sort(entities, new Comparator<AppEntity>() {
                    @Override
                    public int compare(AppEntity lhs, AppEntity rhs) {
                        return (int) (lhs.getSize() - rhs.getSize());
                    }
                });
                break;
            case SIZE_DESC:
                // 按大小降序
                Collections.sort(entities, new Comparator<AppEntity>() {
                    @Override
                    public int compare(AppEntity lhs, AppEntity rhs) {
                        return (int) (rhs.getSize() - lhs.getSize());
                    }
                });
                break;
            case TIME_ASC:
                // 按时间升序
                Collections.sort(entities, new Comparator<AppEntity>() {
                    @Override
                    public int compare(AppEntity lhs, AppEntity rhs) {
                        return Long.compare(lhs.getInstallTime(), rhs.getInstallTime());
                    }
                });
                break;
            case TIME_DESC:
                // 按时间降序
                Collections.sort(entities, new Comparator<AppEntity>() {
                    @Override
                    public int compare(AppEntity lhs, AppEntity rhs) {
                        return Long.compare(rhs.getInstallTime(), lhs.getInstallTime());
                    }
                });
                break;
            case NAME_DESC:
                // 按名称降序
                Collections.sort(entities, new Comparator<AppEntity>() {
                    @Override
                    public int compare(AppEntity lhs, AppEntity rhs) {
                        Collator c = Collator.getInstance(Locale.CHINA);
                        return c.compare(rhs.mAppName, lhs.mAppName);
                    }
                });
                break;
            case NAME_ASC:
            default:
                // 按名称升序（默认）
                Collections.sort(entities, new Comparator<AppEntity>() {
                    @Override
                    public int compare(AppEntity lhs, AppEntity rhs) {
                        Collator c = Collator.getInstance(Locale.CHINA);
                        return c.compare(lhs.mAppName, rhs.mAppName);
                    }
                });
                break;
        }

        if (mAdapter == null) {
            mAdapter = new SpeedUpAdapter(MainActivity.this);
        } else {
            mAdapter.getList().clear();
            mAdapter.getList().addAll(entities);
        }
        // 设置显示选项
        mAdapter.setDisplayOptions(
                settingsManager.isShowTime(),
                settingsManager.isShowPackage()
        );
        // 设置选择状态变化监听器
        mAdapter.setOnSelectionChangeListener(new SpeedUpAdapter.OnSelectionChangeListener() {
            @Override
            public void onSelectionChanged() {
                updateButtonStates();
            }
        });
        appListView.setAdapter(mAdapter);
        updateButtonStates();
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
            Toast.makeText(this, getString(R.string.backup_no_apps_selected), Toast.LENGTH_SHORT).show();
            return;
        }

        // 显示备份进度弹窗
        showBackupProgressDialog(selectedApps);
    }

    // 备份进度弹窗
    private AlertDialog backupProgressDialog;
    private ProgressBar progressBar;
    private TextView progressText;
    private TextView appNameText;
    private TextView appPackageText;
    private TextView backupStatusText;
    private Button btnCancel;
    private boolean isBackupComplete = false;

    private void showBackupProgressDialog(final List<AppEntity> appsToBackup) {
        // 创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_backup_progress, null);
        builder.setView(dialogView);
        builder.setCancelable(false);

        // 初始化视图
        progressBar = dialogView.findViewById(R.id.progress_bar);
        progressText = dialogView.findViewById(R.id.progress_text);
        appNameText = dialogView.findViewById(R.id.app_name_text);
        appPackageText = dialogView.findViewById(R.id.app_package_text);
        backupStatusText = dialogView.findViewById(R.id.backup_status_text);
        btnCancel = dialogView.findViewById(R.id.btn_cancel);

        // 设置进度条初始状态
        progressBar.setMax(appsToBackup.size());
        progressBar.setProgress(0);

        // 创建并显示对话框
        backupProgressDialog = builder.create();
        backupProgressDialog.show();

        // 设置取消按钮
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBackupComplete) {
                    backupProgressDialog.dismiss();
                } else {
                    showCancelBackupDialog();
                }
            }
        });

        // 开始备份操作
        isBackupComplete = false;
        BackupManager.toBackup(appsToBackup, this, new BackupManager.IBackupProgress() {
            @Override
            public void onBackupPrepare(int totalApps) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressText.setText(getString(R.string.backup_progress_preparing));
                        backupStatusText.setText(getString(R.string.backup_progress_status, 0, totalApps));
                    }
                });
            }

            @Override
            public void onBackupStart(AppEntity app, int current, int total) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        appNameText.setText(app.mAppName);
                        appPackageText.setText(app.packageName);
                    }
                });
            }

            @Override
            public void onProgress(int current, int total, boolean isSuccess, String appName, String packageName) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(current);
                        String status = isSuccess ? getString(R.string.success) : getString(R.string.failed);
                        progressText.setText(getString(R.string.backup_progress, current, total, appName + " " + status));
                        backupStatusText.setText(getString(R.string.backup_progress_status, current, total));
                    }
                });
            }

            @Override
            public void onBackupComplete(boolean success, String message, int successCount, int failedCount) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        isBackupComplete = true;
                        progressBar.setProgress(progressBar.getMax());

                        String statusText = successCount > 0 ?
                                getString(R.string.backup_completed) :
                                getString(R.string.backup_failed);

                        if (failedCount > 0) {
                            statusText += " (" + getString(R.string.backup_failed_apps, failedCount) + ")";
                        }

                        backupStatusText.setText(statusText);
                        btnCancel.setText(getString(R.string.complete));

                        // 重置选择状态
                        onCheckAll(false);

                        // 显示备份完成提示
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                        // 如果有成功备份的应用，更新对话框内容提供查看选项
                        if (success && successCount > 0) {
                            btnCancel.setText(getString(R.string.ok));

                            // 添加"查看备份"按钮
                            if (backupProgressDialog != null && backupProgressDialog.isShowing()) {
                                backupProgressDialog.setButton(
                                        DialogInterface.BUTTON_NEUTRAL,
                                        getString(R.string.backup_view_all),
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                openBackupManager();
                                            }
                                        }
                                );
                            }

                            // 显示备份路径信息
                            String backupPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() +
                                    File.separator + "UninstallerBackup";
                            progressText.setText(getString(R.string.backup_storage_location, backupPath));
                        }
                    }
                });
            }
        });
    }

    private void showCancelBackupDialog() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.backup_cancel_confirm_title))
                .setMessage(getString(R.string.backup_cancel_confirm_message))
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cancelBackup();
                    }
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .show();
    }

    private void cancelBackup() {
        // 取消备份任务
        BackupManager.cancelBackup();

        Toast.makeText(this, getString(R.string.backup_canceled), Toast.LENGTH_SHORT).show();

        if (backupProgressDialog != null && backupProgressDialog.isShowing()) {
            backupProgressDialog.dismiss();
        }
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

    /**
     * 分享应用详情
     */
    private void shareAppDetails(AppEntity app) {
        if (app == null || app.appInfo == null) {
            return;
        }
        
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.sharing_app, app.mAppName)).append("\n\n");
            sb.append("应用名称：").append(app.mAppName).append("\n");
            sb.append("包名：").append(app.appInfo.packageName).append("\n");
            sb.append("版本：").append(app.appInfo.versionName).append("\n");
            sb.append("安装时间：").append(Utils.getTime(app.appInfo.firstInstallTime)).append("\n");
            sb.append("大小：").append(app.getSizeString()).append("\n");
            sb.append("路径：").append(app.appInfo.applicationInfo.sourceDir);
            
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, app.mAppName);
            shareIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
            
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_app_details)));
            XLog.i("MainActivity", "已分享应用详情: " + app.mAppName);
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.share_failed), Toast.LENGTH_SHORT).show();
            XLog.e("MainActivity", "分享应用详情失败: " + e.getMessage());
        }
    }
}