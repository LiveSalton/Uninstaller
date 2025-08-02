package com.salton123.uninstaller;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.salton123.log.XLog;
import com.salton123.uninstaller.util.BackupManager;
import com.salton123.uninstaller.util.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 备份管理Activity
 * 显示所有备份文件，支持点击安装
 */
public class BackupActivity extends Activity {

    private ListView backupListView;
    private BackupAdapter backupAdapter;
    private List<BackupManager.BackupInfo> backupList;
    private LinearLayout emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);
        
        // 设置标题
        setTitle(getString(R.string.backup_manage_title));

        initViews();
        loadBackupList();
    }

    private void initViews() {
        backupListView = findViewById(R.id.backup_list_view);
        emptyView = findViewById(R.id.empty_view);

        backupList = new ArrayList<>();
        backupAdapter = new BackupAdapter();
        backupListView.setAdapter(backupAdapter);

        // 点击查看APK详情
        backupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BackupManager.BackupInfo backupInfo = backupList.get(position);
                ApkInfoActivity.start(BackupActivity.this, backupInfo);
            }
        });
    }

    private void loadBackupList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final List<BackupManager.BackupInfo> newBackupList = BackupManager.getBackupList(BackupActivity.this);
                    
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            backupList.clear();
                            backupList.addAll(newBackupList);
                            backupAdapter.notifyDataSetChanged();
                            
                            updateEmptyView();
                            
                            XLog.i("BackupActivity", "Loaded " + backupList.size() + " backup files");
                        }
                    });
                } catch (Exception e) {
                    XLog.e("BackupActivity", "Failed to load backup list: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(BackupActivity.this, getString(R.string.backup_load_failed), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

    private void updateEmptyView() {
        if (backupList.isEmpty()) {
            backupListView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            backupListView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }

    private void installApp(BackupManager.BackupInfo backupInfo) {
        File apkFile = backupInfo.backupFile;
        if (!apkFile.exists()) {
            Toast.makeText(this, getString(R.string.apk_file_not_found), Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri apkUri = Utils.getUriForFile(this, apkFile);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        
        try {
            startActivity(intent);
        } catch (Exception e) {
            XLog.e("BackupActivity", "Install failed: " + e.getMessage());
            Toast.makeText(this, getString(R.string.backup_restore_failed, e.getMessage()), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 备份列表适配器
     */
    private class BackupAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return backupList.size();
        }

        @Override
        public BackupManager.BackupInfo getItem(int position) {
            return backupList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            
            if (convertView == null) {
                convertView = LayoutInflater.from(BackupActivity.this)
                    .inflate(R.layout.item_backup_app, parent, false);
                holder = new ViewHolder();
                holder.appIcon = convertView.findViewById(R.id.app_icon);
                holder.appNameText = convertView.findViewById(R.id.app_name);
                holder.appSizeText = convertView.findViewById(R.id.app_size);
                holder.versionText = convertView.findViewById(R.id.version);
                holder.packageNameText = convertView.findViewById(R.id.app_package_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            BackupManager.BackupInfo backupInfo = getItem(position);
            
            // 应用名称
            if (backupInfo.appName != null && !backupInfo.appName.isEmpty()) {
                holder.appNameText.setText(backupInfo.appName);
            } else if (backupInfo.packageName != null) {
                holder.appNameText.setText(backupInfo.packageName);
            } else {
                holder.appNameText.setText(getString(R.string.app_name));
            }
            
            // 包名
            if (backupInfo.packageName != null) {
                holder.packageNameText.setText(backupInfo.packageName);
            }
            
            // 版本
            if (backupInfo.versionName != null) {
                holder.versionText.setText(backupInfo.versionName);
            } else {
                holder.versionText.setText(getString(R.string.backup_version_unknown));
            }
            
            // 文件大小
            holder.appSizeText.setText(Utils.getSize2(backupInfo.fileSize));
            
            // 尝试加载应用图标
            try {
                PackageManager pm = getPackageManager();
                PackageInfo packageInfo = pm.getPackageArchiveInfo(backupInfo.backupFile.getAbsolutePath(), 
                    PackageManager.GET_ACTIVITIES);
                if (packageInfo != null) {
                    holder.appIcon.setImageDrawable(packageInfo.applicationInfo.loadIcon(pm));
                }
            } catch (Exception e) {
                // 不设置默认图标，保持空状态
            }

            return convertView;
        }

        private class ViewHolder {
            ImageView appIcon;
            TextView appNameText;
            TextView appSizeText;
            TextView versionText;
            TextView packageNameText;
        }
    }
    
    public static void start(Activity activity) {
        activity.startActivity(new android.content.Intent(activity, BackupActivity.class));
    }
}