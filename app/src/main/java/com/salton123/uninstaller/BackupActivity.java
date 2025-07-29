package com.salton123.uninstaller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.salton123.log.XLog;
import com.salton123.uninstaller.util.BackupManager;
import com.salton123.uninstaller.util.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 备份管理Activity
 * 显示所有备份文件，支持恢复和删除操作
 */
public class BackupActivity extends Activity {

    private ListView backupListView;
    private BackupAdapter backupAdapter;
    private List<BackupManager.BackupInfo> backupList;
    private LinearLayout emptyView;
    private Button btnRefresh;
    private Button btnClearAll;

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
        btnRefresh = findViewById(R.id.btn_refresh);
        btnClearAll = findViewById(R.id.btn_clear_all);

        backupList = new ArrayList<>();
        backupAdapter = new BackupAdapter();
        backupListView.setAdapter(backupAdapter);

        // 点击恢复应用
        backupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BackupManager.BackupInfo backupInfo = backupList.get(position);
                showRestoreDialog(backupInfo);
            }
        });

        // 长按删除备份
        backupListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                BackupManager.BackupInfo backupInfo = backupList.get(position);
                showDeleteDialog(backupInfo);
                return true;
            }
        });

        // 刷新按钮
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBackupList();
            }
        });

        // 清空所有备份按钮
        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showClearAllDialog();
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
                            updateButtons();
                            
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

    private void updateButtons() {
        btnClearAll.setEnabled(!backupList.isEmpty());
    }

    private void showRestoreDialog(final BackupManager.BackupInfo backupInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.backup_restore_title));
        builder.setMessage(getString(R.string.backup_restore_confirm, backupInfo.appName != null ? backupInfo.appName : backupInfo.packageName));
        builder.setPositiveButton(getString(R.string.backup_restore_title), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                restoreApp(backupInfo);
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), null);
        builder.show();
    }

    private void showDeleteDialog(final BackupManager.BackupInfo backupInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.backup_delete_title));
        builder.setMessage(getString(R.string.backup_delete_confirm, backupInfo.backupFileName));
        builder.setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteBackup(backupInfo);
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), null);
        builder.show();
    }

    private void showClearAllDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.backup_clear_all_title));
        builder.setMessage(getString(R.string.backup_clear_all_confirm));
        builder.setPositiveButton(getString(R.string.backup_clear_all), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearAllBackups();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), null);
        builder.show();
    }

    private void restoreApp(BackupManager.BackupInfo backupInfo) {
        try {
            BackupManager.restoreApp(this, backupInfo);
            Toast.makeText(this, getString(R.string.backup_restore_start), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            XLog.e("BackupActivity", "Restore failed: " + e.getMessage());
            Toast.makeText(this, getString(R.string.backup_restore_failed, e.getMessage()), Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteBackup(final BackupManager.BackupInfo backupInfo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean success = BackupManager.deleteBackup(backupInfo);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (success) {
                            backupList.remove(backupInfo);
                            backupAdapter.notifyDataSetChanged();
                            updateEmptyView();
                            updateButtons();
                            Toast.makeText(BackupActivity.this, getString(R.string.backup_delete_success), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(BackupActivity.this, getString(R.string.backup_delete_failed), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }

    private void clearAllBackups() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int deletedCount = 0;
                List<BackupManager.BackupInfo> toDelete = new ArrayList<>(backupList);
                
                for (BackupManager.BackupInfo backupInfo : toDelete) {
                    if (BackupManager.deleteBackup(backupInfo)) {
                        deletedCount++;
                    }
                }
                
                final int finalDeletedCount = deletedCount;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadBackupList(); // 重新加载列表
                        Toast.makeText(BackupActivity.this, 
                            getString(R.string.deleted_backup_files, finalDeletedCount), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
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
                    .inflate(R.layout.adapter_backup_item, parent, false);
                holder = new ViewHolder();
                holder.appNameText = convertView.findViewById(R.id.app_name);
                holder.packageNameText = convertView.findViewById(R.id.package_name);
                holder.versionText = convertView.findViewById(R.id.version);
                holder.backupTimeText = convertView.findViewById(R.id.backup_time);
                holder.fileSizeText = convertView.findViewById(R.id.file_size);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            BackupManager.BackupInfo backupInfo = getItem(position);
            
            // 应用名称
            if (backupInfo.appName != null && !backupInfo.appName.isEmpty()) {
                holder.appNameText.setText(backupInfo.appName);
            } else {
                holder.appNameText.setText(backupInfo.packageName);
            }
            
            // 包名
            holder.packageNameText.setText(backupInfo.packageName);
            
            // 版本
            if (backupInfo.versionName != null) {
                holder.versionText.setText(getString(R.string.backup_version, backupInfo.versionName));
            } else {
                holder.versionText.setText(getString(R.string.backup_version_unknown));
            }
            
            // 备份时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            holder.backupTimeText.setText(getString(R.string.backup_time_label) + sdf.format(backupInfo.backupTime));
            
            // 文件大小
            holder.fileSizeText.setText(getString(R.string.backup_file_size, Utils.getSize2(backupInfo.fileSize)));

            return convertView;
        }

        private class ViewHolder {
            TextView appNameText;
            TextView packageNameText;
            TextView versionText;
            TextView backupTimeText;
            TextView fileSizeText;
        }
    }
} 