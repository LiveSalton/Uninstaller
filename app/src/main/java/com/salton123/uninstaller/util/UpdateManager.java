package com.salton123.uninstaller.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import com.salton123.log.XLog;
import com.salton123.uninstaller.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 更新管理工具类，用于检查应用更新
 */
public class UpdateManager {

    private static final String TAG = "UpdateManager";
    
    // 模拟的更新服务器URL
    private static final String UPDATE_URL = "https://example.com/api/update";
    
    /**
     * 检查应用更新
     * @param context 上下文
     * @param listener 更新检查结果监听器
     */
    public static void checkUpdate(final Context context, final UpdateCheckListener listener) {
        if (context == null || listener == null) return;
        
        // 获取当前应用版本
        String currentVersion = getCurrentVersion(context);
        if (currentVersion == null) {
            listener.onCheckFailed("Failed to get current version");
            return;
        }
        
        // 执行异步任务检查更新
        new AsyncTask<Void, Void, UpdateInfo>() {
            @Override
            protected void onPreExecute() {
                listener.onCheckStart();
            }
            
            @Override
            protected UpdateInfo doInBackground(Void... params) {
                // 这里实现实际的网络请求逻辑
                // 由于是演示，我们模拟一个更新响应
                return simulateUpdateCheck(currentVersion);
            }
            
            @Override
            protected void onPostExecute(UpdateInfo updateInfo) {
                if (updateInfo != null) {
                    if (updateInfo.hasUpdate) {
                        listener.onUpdateAvailable(updateInfo);
                    } else {
                        listener.onNoUpdateAvailable();
                    }
                } else {
                    listener.onCheckFailed("Failed to check update");
                }
            }
        }.execute();
    }
    
    /**
     * 模拟检查更新的逻辑
     * 在实际应用中，这应该是一个真正的网络请求
     */
    private static UpdateInfo simulateUpdateCheck(String currentVersion) {
        try {
            // 模拟网络延迟
            Thread.sleep(1500);
            
            // 解析当前版本号
            String[] currentParts = currentVersion.split("\\.");
            int currentMajor = Integer.parseInt(currentParts[0]);
            
            // 模拟一个更高的版本号
            String newVersion = (currentMajor + 1) + ".0.0";
            
            // 模拟更新信息
            UpdateInfo updateInfo = new UpdateInfo();
            updateInfo.newVersion = newVersion;
            updateInfo.hasUpdate = true;
            updateInfo.updateUrl = "https://play.google.com/store/apps/details?id=com.salton123.uninstaller";
            updateInfo.updateContent = "1. 新增多项功能\n2. 修复已知BUG\n3. 优化用户体验";
            
            return updateInfo;
        } catch (Exception e) {
            XLog.e(TAG, "Error simulating update check: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * 获取当前应用版本号
     */
    public static String getCurrentVersion(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            XLog.e(TAG, "Failed to get version info:"+e);
            return null;
        }
    }
    
    /**
     * 显示更新提示对话框
     */
    public static void showUpdateDialog(final Context context, final UpdateInfo updateInfo) {
        if (context == null || updateInfo == null) return;
        
        new AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.update_available))
            .setMessage(context.getString(R.string.update_content, 
                    updateInfo.newVersion, updateInfo.updateContent))
            .setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 打开更新链接
                    openUpdateUrl(context, updateInfo.updateUrl);
                }
            })
            .setNegativeButton(context.getString(R.string.cancel), null)
            .show();
    }
    
    /**
     * 打开更新链接
     */
    private static void openUpdateUrl(Context context, String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            XLog.e(TAG, "Failed to open update URL: " + url);
            Toast.makeText(context, "Failed to open update link", Toast.LENGTH_SHORT).show();
        }
    }
    
    /**
     * 更新信息类
     */
    public static class UpdateInfo {
        public String newVersion;    // 新版本号
        public boolean hasUpdate;    // 是否有更新
        public String updateUrl;     // 更新链接
        public String updateContent; // 更新内容
    }
    
    /**
     * 更新检查监听器接口
     */
    public interface UpdateCheckListener {
        void onCheckStart();
        void onUpdateAvailable(UpdateInfo updateInfo);
        void onNoUpdateAvailable();
        void onCheckFailed(String errorMsg);
    }
} 