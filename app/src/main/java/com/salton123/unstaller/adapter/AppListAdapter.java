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
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.salton123.unstaller.R;
import com.salton123.unstaller.entity.AppInfo;
import com.salton123.unstaller.util.Utils;

import java.util.List;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 9:23 PM
 * ModifyTime: 9:23 PM
 * Description:
 */
public class AppListAdapter extends BaseAdapter implements View.OnClickListener {

    private List<AppInfo> list;
    private LayoutInflater inflater;
    private PackageManager mPackageManager;// 包管理器

    public AppListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.mPackageManager = context.getPackageManager();
    }

    public void setList(List<AppInfo> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return (list == null) ? 0 : list.size();// 三元运算
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_app_item, null);
            holder = new ViewHolder();
            holder.logo = convertView.findViewById(R.id.logo);
            holder.title = convertView.findViewById(R.id.title);
            holder.version = convertView.findViewById(R.id.version);
            holder.size = convertView.findViewById(R.id.size);
            holder.chekcBox = convertView.findViewById(R.id.chekcBox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AppInfo map = list.get(position);
        final String pkgName = map.packageName;
        // 拿到图标 OOM=out of Memory
        if (map.icon == null) {// 优化
            map.icon = map.applicationInfo.loadIcon(mPackageManager);//57
        }
        holder.logo.setImageDrawable(map.icon);
        //对下面的应用名进行高亮处理
        // holder.title.setText((String) map.appName);

        String w = map.appName;// 原始应用名
        String key = Utils.KEY;
        int start = w.toLowerCase().indexOf(key.toLowerCase());//高亮文字的起始位置
        if (start > -1) {// 有
            int end = start + key.length();//高亮文字的终止位置
            // 字符串样式对象
            SpannableStringBuilder style
                    = new SpannableStringBuilder(map.appName);
            style.setSpan(// 设定样式
                    new ForegroundColorSpan(Color.BLUE),// 前景样式
                    start,// 起始坐标
                    end,// 终止坐标
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE// 旗标
            );
            holder.title.setText(style);// 将样式设置给TextView
        } else {
            holder.title.setText(w);// 将原来的文字赋值
        }
        holder.version.setText(map.versionName + "(" + map.versionCode + ")");
        holder.size.setText(map.size + "M  " + Utils.getTime(map.lastUpdateTime));
        holder.chekcBox.setChecked(map.isChecked);
        // 点击"卸载"按钮的点击事件
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder {
        ImageView logo;
        TextView title;
        TextView version;
        TextView size;
        CheckBox chekcBox;
    }
}
