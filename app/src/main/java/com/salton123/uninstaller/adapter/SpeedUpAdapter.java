package com.salton123.uninstaller.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.salton123.uninstaller.R;
import com.salton123.uninstaller.entity.AppEntity;
import com.salton123.uninstaller.util.Utils;
import com.salton123.uninstaller.util.DateUtils;
import com.salton123.log.XLog;

import java.io.File;
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
    private boolean showFilename = false;
    private boolean showPath = false;
    
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
        final ImageView ivLogo = ViewHolder.get(convertView, R.id.logo);
        TextView tvTitle = ViewHolder.get(convertView, R.id.title);
        TextView tvVersion = ViewHolder.get(convertView, R.id.version);
        final TextView tvSize = ViewHolder.get(convertView, R.id.size);
        CheckBox cbSelect = ViewHolder.get(convertView, R.id.chekcBox);
        final AppEntity appEntity = getItem(position);
        
        // 加载应用信息（只在第一次加载时设置）
        if (appEntity.mIcon == null) {
            Drawable drawable = appEntity.appInfo.applicationInfo.loadIcon(packageManager);
            appEntity.mIcon = drawable;
        }
        if (TextUtils.isEmpty(appEntity.mAppName)) {
            appEntity.mAppName = ((String) appEntity.appInfo.applicationInfo.loadLabel(packageManager)).trim();
        }
        
        // 动态构建显示文本（不存储到appEntity中）
        String displayText = buildDisplayText(appEntity);
        
        // 设置UI
        tvVersion.setText(appEntity.mVersionName);
        if (!TextUtils.isEmpty(appEntity.mAppName)) {
            tvTitle.setText(appEntity.mAppName);
        }
        if (!TextUtils.isEmpty(displayText)) {
            tvSize.setText(displayText);
        }
        if (appEntity.mIcon != null) {
            ivLogo.setImageDrawable(appEntity.mIcon);
        }
        
        // 首先设置复选框状态，避免触发监听器
        cbSelect.setOnCheckedChangeListener(null);
        cbSelect.setChecked(appEntity.isChecked);
        
        // 然后设置监听器
        cbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                appEntity.isChecked = isChecked;
                // 通知选择状态变化
                if (selectionChangeListener != null) {
                    selectionChangeListener.onSelectionChanged();
                }
                XLog.i("SpeedUpAdapter", "应用选择状态变化: " + appEntity.mAppName + " -> " + isChecked);
            }
        });
        
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }
    
    /**
     * 设置显示选项
     */
    public void setDisplayOptions(boolean showTime, boolean showFilename, boolean showPath) {
        XLog.i("SpeedUpAdapter", "Setting display options - Time: " + showTime + 
            ", Filename: " + showFilename + ", Path: " + showPath);
        this.showTime = showTime;
        this.showFilename = showFilename;
        this.showPath = showPath;
    }
    
    /**
     * 设置选择状态变化监听器
     */
    public void setOnSelectionChangeListener(OnSelectionChangeListener listener) {
        this.selectionChangeListener = listener;
    }
    
    /**
     * 构建显示文本
     */
    private String buildDisplayText(AppEntity appEntity) {
        StringBuilder builder = new StringBuilder();
        
        // 基础大小信息
        String sizeStr = appEntity.getSizeString();
        builder.append(sizeStr);
        
        // 添加时间信息 - 使用DateUtils格式化
        if (showTime) {
            long installTime = appEntity.getInstallTime();
            String timeStr = DateUtils.timeFormatNearby(new Date(installTime));
            builder.append("  ");
            builder.append(getContext().getString(R.string.time_prefix));
            builder.append(timeStr);
        }
        
        // 添加包名信息
        if (showFilename && appEntity.appInfo != null) {
            String packageName = appEntity.appInfo.packageName;
            if (packageName != null) {
                builder.append("  ");
                builder.append(getContext().getString(R.string.filename_prefix));
                builder.append(packageName);
            }
        }
        
        // 添加路径信息
        if (showPath && appEntity.appInfo != null && appEntity.appInfo.applicationInfo != null) {
            String path = appEntity.appInfo.applicationInfo.sourceDir;
            builder.append("\n");
            builder.append(getContext().getString(R.string.path_prefix));
            builder.append(path);
        }
        
        return builder.toString();
    }

}
