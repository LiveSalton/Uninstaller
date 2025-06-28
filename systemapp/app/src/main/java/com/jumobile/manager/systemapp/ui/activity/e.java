package com.jumobile.manager.systemapp.ui.activity;

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
import com.jumobile.manager.systemapp.d.g;
import com.jumobile.manager.systemapp.util.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Context a;
    private com.jumobile.manager.systemapp.util.b b;
    private ArrayList<g> c = null;
    private Drawable d = null;

    /* compiled from: source */
    static class a {
        g a;
        TextView b;
        TextView c;
        ImageView d;
        TextView e;
        TextView f;
        CheckBox g;
        TextView h;
        TextView i;
        TextView j;

        a() {
        }
    }

    public e(Context context) {
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
            view = LayoutInflater.from(this.a).inflate(R.layout.list_item_user_app, (ViewGroup) null);
            aVar = new a();
            aVar.d = (ImageView) view.findViewById(R.id.app_icon);
            aVar.b = (TextView) view.findViewById(R.id.app_name);
            aVar.c = (TextView) view.findViewById(R.id.install_state);
            aVar.f = (TextView) view.findViewById(R.id.app_version);
            aVar.e = (TextView) view.findViewById(R.id.app_size);
            aVar.g = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
            aVar.h = (TextView) view.findViewById(R.id.app_time);
            aVar.i = (TextView) view.findViewById(R.id.app_package);
            aVar.j = (TextView) view.findViewById(R.id.app_path);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        g gVar = this.c.get(i);
        aVar.a = gVar;
        aVar.b.setText(gVar.f.trim());
        this.d = this.b.b(gVar);
        if (this.d != null) {
            aVar.d.setImageDrawable(this.d);
        } else {
            aVar.d.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_default));
        }
        if (gVar.g == null) {
            aVar.f.setText(R.string.user_app_version_default);
        } else {
            aVar.f.setText(f.d(this.a, gVar.g));
        }
        aVar.e.setText(f.a(gVar.h));
        aVar.g.setChecked(gVar.i);
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.a, "user_app_extra_info", 0);
        if ((a2 & 2) != 0) {
            aVar.h.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(gVar.c)));
            aVar.h.setVisibility(0);
        } else {
            aVar.h.setVisibility(8);
        }
        if ((a2 & 4) != 0) {
            aVar.i.setText(gVar.b.packageName);
            aVar.i.setVisibility(0);
        } else {
            aVar.i.setVisibility(8);
        }
        if ((a2 & 8) != 0) {
            aVar.j.setText(gVar.b.sourceDir);
            aVar.j.setVisibility(0);
        } else {
            aVar.j.setVisibility(8);
        }
        if (gVar.d) {
            aVar.c.setVisibility(0);
            aVar.c.setText(R.string.user_app_state_backuped);
        } else {
            aVar.c.setVisibility(8);
        }
        return view;
    }

    public void a(ArrayList<g> arrayList) {
        this.c = arrayList;
        Iterator<g> it = this.c.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.b.packageName.equals(this.a.getPackageName())) {
                this.c.remove(next);
                return;
            }
        }
    }

    public g a() {
        if (this.c == null) {
            return null;
        }
        Iterator<g> it = this.c.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.i) {
                return next;
            }
        }
        return null;
    }

    public void a(boolean z) {
        if (this.c == null) {
            return;
        }
        Iterator<g> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().i = z;
        }
    }

    public g a(int i) {
        if (this.c != null && i < this.c.size()) {
            return this.c.get(i);
        }
        return null;
    }

    public ArrayList<g> b() {
        ArrayList<g> arrayList = new ArrayList<>();
        if (this.c != null) {
            Iterator<g> it = this.c.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.i) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public int c() {
        int i = 0;
        if (this.c != null) {
            Iterator<g> it = this.c.iterator();
            while (it.hasNext()) {
                if (it.next().i) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean d() {
        if (this.c == null) {
            return false;
        }
        Iterator<g> it = this.c.iterator();
        while (it.hasNext()) {
            if (!it.next().i) {
                return false;
            }
        }
        return true;
    }
}
