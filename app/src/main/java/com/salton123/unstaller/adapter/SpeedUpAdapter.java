package com.salton123.unstaller.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.salton123.log.XLog;
import com.salton123.unstaller.R;
import com.salton123.unstaller.entity.AppInfo;
import com.salton123.unstaller.util.Utils;

import java.io.File;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 9:23 PM
 * ModifyTime: 9:23 PM
 * Description:
 */
public class SpeedUpAdapter extends AdapterBase<PackageInfo> implements View.OnClickListener {

    private LayoutInflater inflater;
    private PackageManager mPackageManager;// 包管理器

    public SpeedUpAdapter(Context context) {
        super(context);
        this.inflater = LayoutInflater.from(context);
        this.mPackageManager = context.getPackageManager();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_app_item, null);
        }
        ImageView logo = ViewHolder.get(convertView, R.id.logo);
        TextView title = ViewHolder.get(convertView, R.id.title);
        TextView version = ViewHolder.get(convertView, R.id.version);
        TextView size = ViewHolder.get(convertView, R.id.size);
        CheckBox chekcBox = ViewHolder.get(convertView, R.id.chekcBox);
        PackageInfo appInfo = getItem(position);
        title.setText(((String) appInfo.applicationInfo.loadLabel(mPackageManager)).trim());
        version.setText(appInfo.versionName);
        String dir = appInfo.applicationInfo.publicSourceDir;
        long byteSize = new File(dir).length();
        size.setText(Utils.getSize(byteSize)+ "M  " +Utils.getTime(appInfo.lastUpdateTime));
        logo.setImageDrawable(appInfo.applicationInfo.loadIcon(mPackageManager));
        chekcBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

}
