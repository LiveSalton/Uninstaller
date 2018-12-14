package com.salton123.unstaller.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.salton123.unstaller.R;
import com.salton123.unstaller.entity.AppEntity;
import com.salton123.unstaller.util.Utils;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 9:23 PM
 * ModifyTime: 9:23 PM
 * Description:
 */
public class SpeedUpAdapter extends AdapterBase<AppEntity> implements View.OnClickListener {

    private LayoutInflater inflater;

    public SpeedUpAdapter(Context context) {
        super(context);
        this.inflater = LayoutInflater.from(context);
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
        tvVersion.setText(appEntity.appInfo.versionName);
        if (!TextUtils.isEmpty(appEntity.mAppName)) {
            tvTitle.setText(appEntity.mAppName);
        }
        if (!TextUtils.isEmpty(appEntity.mSize)) {
            tvSize.setText(appEntity.mSize + "M  " + Utils.getTime(appEntity.appInfo.lastUpdateTime));
        }
        if (appEntity.mIcon != null) {
            ivLogo.setImageDrawable(appEntity.mIcon);
        }
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
