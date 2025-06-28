package com.jumobile.manager.systemapp.ui.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private Context a;
    private com.jumobile.manager.systemapp.util.b b;
    private ArrayList<com.jumobile.manager.systemapp.d.f> c = null;
    private Drawable d = null;

    /* compiled from: source */
    class a {
        com.jumobile.manager.systemapp.d.f a;
        TextView b;
        ImageView c;
        TextView d;
        TextView e;
        CheckBox f;
        TextView g;
        TextView h;
        TextView i;

        a() {
        }
    }

    public g(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.jumobile.manager.systemapp.util.b(this.a);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.c.get(i).k;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.list_item_system_app, (ViewGroup) null);
            aVar = new a();
            aVar.c = (ImageView) view.findViewById(R.id.app_icon);
            aVar.b = (TextView) view.findViewById(R.id.app_name);
            aVar.d = (TextView) view.findViewById(R.id.app_type);
            aVar.e = (TextView) view.findViewById(R.id.app_size);
            aVar.f = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
            aVar.g = (TextView) view.findViewById(R.id.app_time);
            aVar.h = (TextView) view.findViewById(R.id.app_package);
            aVar.i = (TextView) view.findViewById(R.id.app_path);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.jumobile.manager.systemapp.d.f fVar = this.c.get(i);
        aVar.a = fVar;
        aVar.b.setText(fVar.f.trim());
        this.d = this.b.b(fVar);
        if (this.d != null) {
            aVar.c.setImageDrawable(this.d);
        } else {
            aVar.c.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_default));
        }
        aVar.f.setTag(Integer.valueOf(i));
        aVar.f.setChecked(fVar.i);
        aVar.e.setText(com.jumobile.manager.systemapp.util.f.a(fVar.h));
        int i2 = fVar.a;
        if (i2 == 0) {
            aVar.d.setVisibility(0);
            aVar.d.setText(R.string.system_app_type_just_restored);
            aVar.d.setTextColor(this.a.getResources().getColor(R.color.blue));
        } else if (i2 == 10) {
            aVar.d.setVisibility(0);
            aVar.d.setText(R.string.system_app_type_could_delete);
            aVar.d.setTextColor(this.a.getResources().getColor(R.color.green));
        } else if (i2 == 20) {
            aVar.d.setVisibility(8);
        } else if (i2 == 30) {
            aVar.d.setVisibility(0);
            aVar.d.setText(R.string.system_app_type_should_keep);
            aVar.d.setTextColor(this.a.getResources().getColor(R.color.orange));
        } else if (i2 == 40) {
            aVar.d.setVisibility(0);
            aVar.d.setText(R.string.system_app_type_key_signature);
            aVar.d.setTextColor(this.a.getResources().getColor(R.color.red));
        } else if (i2 == 50) {
            aVar.d.setVisibility(0);
            aVar.d.setText(R.string.system_app_type_core_app);
            aVar.d.setTextColor(this.a.getResources().getColor(R.color.red));
        } else if (i2 == 60) {
            aVar.d.setVisibility(0);
            aVar.d.setText(R.string.system_app_type_never_delete);
            aVar.d.setTextColor(this.a.getResources().getColor(R.color.red));
        }
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.a, "system_app_extra_info", 0);
        if ((a2 & 2) != 0) {
            aVar.g.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(fVar.d)));
            aVar.g.setVisibility(0);
        } else {
            aVar.g.setVisibility(8);
        }
        if ((a2 & 4) != 0) {
            aVar.h.setText(fVar.b.packageName);
            aVar.h.setVisibility(0);
        } else {
            aVar.h.setVisibility(8);
        }
        if ((a2 & 8) != 0) {
            aVar.i.setText(fVar.b.sourceDir);
            aVar.i.setVisibility(0);
        } else {
            aVar.i.setVisibility(8);
        }
        return view;
    }

    public void a(ArrayList<com.jumobile.manager.systemapp.d.f> arrayList) {
        this.c = arrayList;
    }

    public com.jumobile.manager.systemapp.d.f a(int i) {
        if (this.c != null && i < this.c.size()) {
            return this.c.get(i);
        }
        return null;
    }

    public ArrayList<com.jumobile.manager.systemapp.d.f> a() {
        ArrayList<com.jumobile.manager.systemapp.d.f> arrayList = new ArrayList<>();
        Iterator<com.jumobile.manager.systemapp.d.f> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.f next = it.next();
            if (next.i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int b() {
        int i = 0;
        if (this.c != null) {
            Iterator<com.jumobile.manager.systemapp.d.f> it = this.c.iterator();
            while (it.hasNext()) {
                if (it.next().i) {
                    i++;
                }
            }
        }
        return i;
    }

    public long c() {
        long j = 0;
        if (this.c != null) {
            Iterator<com.jumobile.manager.systemapp.d.f> it = this.c.iterator();
            while (it.hasNext()) {
                com.jumobile.manager.systemapp.d.f next = it.next();
                if (next.i) {
                    j += next.h;
                }
            }
        }
        return j;
    }
}
