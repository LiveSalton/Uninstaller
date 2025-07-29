package com.salton123.uninstaller.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.FileProvider;

import com.salton123.uninstaller.R;
import com.salton123.uninstaller.entity.AppEntity;
import com.salton123.uninstaller.util.Utils;
import com.salton123.uninstaller.util.DateUtils;
import com.salton123.log.XLog;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 9:23 PM
 * ModifyTime: 9:23 PM
 * Description:
 */
public class SpeedUpAdapter extends AdapterBase<AppEntity> implements View.OnClickListener {

    private LayoutInflater inflater;
    private PackageManager packageManager;
    
    // 显示选项
    private boolean showTime = false;
    private boolean showPackage = false;
    
    // 选择状态变化回调接口
    public interface OnSelectionChangeListener {
        void onSelectionChanged();
    }
    
    private OnSelectionChangeListener selectionChangeListener;
    public SpeedUpAdapter(Context context) {
        super(context);
        this.inflater = LayoutInflater.from(context);
        packageManager = context.getPackageManager();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_app_item, null);
        }
        final ImageView ivLogo = ViewHolder.get(convertView, R.id.app_icon);
        TextView tvTitle = ViewHolder.get(convertView, R.id.app_name);
        TextView tvVersion = ViewHolder.get(convertView, R.id.version);
        final TextView tvSize = ViewHolder.get(convertView, R.id.app_size);
        CheckBox cbSelect = ViewHolder.get(convertView, R.id.checkbox_select);
        
        // 获取新增控件引用
        TextView tvInstallTime = ViewHolder.get(convertView, R.id.installTime);
        TextView tvPackageName = ViewHolder.get(convertView, R.id.app_package_name);
        View installTimeDivider = ViewHolder.get(convertView, R.id.installTimeDivider);
        
        final AppEntity appEntity = getItem(position);
        
        // 加载应用信息（只在第一次加载时设置）
        if (appEntity.mIcon == null) {
            Drawable drawable = appEntity.appInfo.applicationInfo.loadIcon(packageManager);
            appEntity.mIcon = drawable;
        }
        if (TextUtils.isEmpty(appEntity.mAppName)) {
            appEntity.mAppName = ((String) appEntity.appInfo.applicationInfo.loadLabel(packageManager)).trim();
        }
        
        // 基本信息设置
        tvVersion.setText(appEntity.mVersionName);
        if (!TextUtils.isEmpty(appEntity.mAppName)) {
            tvTitle.setText(appEntity.mAppName);
        }
        tvSize.setText(appEntity.getSizeString());
        if (appEntity.mIcon != null) {
            ivLogo.setImageDrawable(appEntity.mIcon);
        }
        
        // 根据设置显示或隐藏安装时间
        if (showTime) {
            tvInstallTime.setVisibility(View.VISIBLE);
            installTimeDivider.setVisibility(View.VISIBLE);
            long installTime = appEntity.getInstallTime();
            String timeStr = DateUtils.timeFormatNearby(new Date(installTime));
            tvInstallTime.setText(timeStr);
        } else {
            tvInstallTime.setVisibility(View.GONE);
            installTimeDivider.setVisibility(View.GONE);
        }
        
        // 根据设置显示或隐藏应用包名
        if (showPackage) {
            tvPackageName.setVisibility(View.VISIBLE);
            String packageName = appEntity.appInfo.packageName;
            tvPackageName.setText(packageName);
        } else {
            tvPackageName.setVisibility(View.GONE);
        }
        
        // 首先设置复选框状态，避免触发监听器
        cbSelect.setOnCheckedChangeListener(null);
        cbSelect.setChecked(appEntity.isChecked);
        
        // 清除所有可能的点击监听器，避免重复注册
        convertView.setOnClickListener(null);
        convertView.setOnLongClickListener(null);
        cbSelect.setOnClickListener(null);
        
        // 使整个布局可点击，点击时切换选中状态
        // 使用资源ID作为tag key
        convertView.setTag(R.id.list_item_position, position);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag(R.id.list_item_position);
                AppEntity entity = getItem(pos);
                entity.isChecked = !entity.isChecked;
                notifyDataSetChanged();
                
                // 通知选择状态变化
                if (selectionChangeListener != null) {
                    selectionChangeListener.onSelectionChanged();
                }
                
                XLog.i("SpeedUpAdapter", "列表项点击切换选择状态: " + entity.mAppName + " -> " + entity.isChecked);
            }
        });
        
        // 添加长按监听器用于分享应用
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                shareAppApk(appEntity);
                return true; // 表示事件已处理
            }
        });
        
        // 取消CheckBox的点击事件，使用整行点击
        cbSelect.setClickable(false);
        
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }
    
    /**
     * 设置显示选项
     */
    public void setDisplayOptions(boolean showTime, boolean showPackage) {
        XLog.i("SpeedUpAdapter", "Setting display options - Time: " + showTime + 
            ", Package: " + showPackage);
        this.showTime = showTime;
        this.showPackage = showPackage;
    }
    
    /**
     * 设置选择状态变化监听器
     */
    public void setOnSelectionChangeListener(OnSelectionChangeListener listener) {
        this.selectionChangeListener = listener;
    }
    
    /**
     * 分享应用APK文件
     */
    private void shareAppApk(AppEntity appEntity) {
        try {
            File apkFile = new File(appEntity.appInfo.applicationInfo.sourceDir);
            if (!apkFile.exists()) {
                // 文件不存在，显示错误提示
                XLog.e("SpeedUpAdapter", "APK文件不存在: " + appEntity.appInfo.applicationInfo.sourceDir);
                return;
            }
            
            Uri apkUri;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                // Android 7.0及以上使用FileProvider
                apkUri = FileProvider.getUriForFile(
                    getContext(), 
                    getContext().getPackageName() + ".fileprovider", 
                    apkFile
                );
            } else {
                // Android 7.0以下直接使用文件路径
                apkUri = Uri.fromFile(apkFile);
            }
            
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/vnd.android.package-archive");
            shareIntent.putExtra(Intent.EXTRA_STREAM, apkUri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            
            // 启动分享选择器
            getContext().startActivity(Intent.createChooser(
                shareIntent, 
                getContext().getString(R.string.share_app_apk)
            ));
            
            XLog.i("SpeedUpAdapter", "分享APK: " + appEntity.mAppName);
        } catch (Exception e) {
            XLog.e("SpeedUpAdapter", "分享APK失败: " + e.getMessage());
    }
    }
}
