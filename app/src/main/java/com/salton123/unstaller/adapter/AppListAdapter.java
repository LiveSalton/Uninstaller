package com.salton123.unstaller.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.salton123.log.XLog;
import com.salton123.unstaller.R;
import com.salton123.unstaller.entity.AppInfo;
import com.salton123.unstaller.util.Utils;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 9:23 PM
 * ModifyTime: 9:23 PM
 * Description:
 */
public class AppListAdapter extends AdapterBase<AppInfo> implements View.OnClickListener {

    private LayoutInflater inflater;
    private PackageManager mPackageManager;// 包管理器

    public AppListAdapter(Context context) {
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
        XLog.i(this,"[getView]");
        AppInfo map = getItem(position);
        final String pkgName = map.mPackageName;
        // 拿到图标 OOM=out of Memory
        // if (map.mIcon == null) {// 优化
        //     map.mIcon = map.mApplicationInfo.loadIcon(mPackageManager);//57
        // }
        // logo.setImageDrawable(map.mIcon);
        //对下面的应用名进行高亮处理
        // title.setText((String) map.mAppName);

        String w = map.mAppName;// 原始应用名
        String key = Utils.KEY;
        int start = w.toLowerCase().indexOf(key.toLowerCase());//高亮文字的起始位置
        if (start > -1) {// 有
            int end = start + key.length();//高亮文字的终止位置
            // 字符串样式对象
            SpannableStringBuilder style
                    = new SpannableStringBuilder(map.mAppName);
            style.setSpan(// 设定样式
                    new ForegroundColorSpan(Color.BLUE),// 前景样式
                    start,// 起始坐标
                    end,// 终止坐标
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE// 旗标
            );
            title.setText(style);// 将样式设置给TextView
        } else {
            title.setText(w);// 将原来的文字赋值
        }
        version.setText(map.mVersionName + "(" + map.mVersionCode + ")");
        size.setText(map.mSize + "M  " + Utils.getTime(map.mLastUpdateTime));
        chekcBox.setChecked(map.isChecked);
        // 点击"卸载"按钮的点击事件
        return convertView;
    }


    @Override
    public void onClick(View v) {

    }

}
