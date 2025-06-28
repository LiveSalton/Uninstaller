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

import java.io.File;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 9:23 PM
 * ModifyTime: 9:23 PM
 * Description:
 */
public class SpeedUpAdapter extends AdapterBase<AppEntity> implements View.OnClickListener {

    private LayoutInflater inflater;
    private PackageManager packageManager;
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
        String dir = appEntity.appInfo.applicationInfo.publicSourceDir;
        long byteSize = new File(dir).length();

        String sizeStr = Utils.getSize(byteSize) + "M  " + Utils.getTime(appEntity.appInfo.lastUpdateTime);
        Drawable drawable = appEntity.appInfo.applicationInfo.loadIcon(packageManager);
        appEntity.mIcon = drawable;
        appEntity.mSize = sizeStr;
        appEntity.mAppName = ((String) appEntity.appInfo.applicationInfo.loadLabel(packageManager)).trim();
        tvVersion.setText(appEntity.appInfo.versionName);
        if (!TextUtils.isEmpty(appEntity.mAppName)) {
            tvTitle.setText(appEntity.mAppName);
        }
        if (!TextUtils.isEmpty(appEntity.mSize)) {
            tvSize.setText(appEntity.mSize);
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
            }
        });
        
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

}
