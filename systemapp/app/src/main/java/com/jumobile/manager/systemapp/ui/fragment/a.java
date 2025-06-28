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
public class a extends BaseAdapter {
    private Context a;
    private com.jumobile.manager.systemapp.util.b b;
    private ArrayList<com.jumobile.manager.systemapp.d.a> c = null;
    private Drawable d = null;

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.fragment.a$a */
    static class C0095a {
        com.jumobile.manager.systemapp.d.a a;
        TextView b;
        ImageView c;
        TextView d;
        TextView e;
        CheckBox f;
        TextView g;
        TextView h;
        TextView i;
        TextView j;

        C0095a() {
        }
    }

    public a(Context context) {
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
        return i < this.c.size() ? this.c.get(i).k : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0095a c0095a;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.list_item_apk_file, (ViewGroup) null);
            c0095a = new C0095a();
            c0095a.c = (ImageView) view.findViewById(R.id.app_icon);
            c0095a.b = (TextView) view.findViewById(R.id.app_name);
            c0095a.e = (TextView) view.findViewById(R.id.app_version);
            c0095a.d = (TextView) view.findViewById(R.id.app_size);
            c0095a.f = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
            c0095a.g = (TextView) view.findViewById(R.id.install_state);
            c0095a.h = (TextView) view.findViewById(R.id.app_time);
            c0095a.i = (TextView) view.findViewById(R.id.app_package);
            c0095a.j = (TextView) view.findViewById(R.id.app_path);
            view.setTag(c0095a);
        } else {
            c0095a = (C0095a) view.getTag();
        }
        com.jumobile.manager.systemapp.d.a aVar = this.c.get(i);
        c0095a.a = aVar;
        c0095a.b.setText(aVar.f.trim());
        this.d = this.b.b(aVar);
        if (this.d != null) {
            c0095a.c.setImageDrawable(this.d);
        } else {
            c0095a.c.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_default));
        }
        c0095a.e.setText(com.jumobile.manager.systemapp.util.f.d(this.a, aVar.g));
        c0095a.d.setText(com.jumobile.manager.systemapp.util.f.a(aVar.h));
        c0095a.f.setChecked(aVar.i);
        if (aVar.b == 3) {
            c0095a.g.setVisibility(0);
            c0095a.g.setText(R.string.apk_file_intall_state_new_version);
        } else if (aVar.b == 1) {
            c0095a.g.setVisibility(0);
            c0095a.g.setText(R.string.apk_file_intall_state_old_version);
        } else if (aVar.b == 2) {
            c0095a.g.setVisibility(0);
            c0095a.g.setText(R.string.apk_file_intall_state_installed);
        } else {
            c0095a.g.setVisibility(8);
        }
        int a = com.jumobile.manager.systemapp.f.a.a(this.a, "apk_file_extra_info", 0);
        if ((a & 2) != 0) {
            c0095a.h.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(aVar.d)));
            c0095a.h.setVisibility(0);
        } else {
            c0095a.h.setVisibility(8);
        }
        if ((a & 4) != 0) {
            c0095a.i.setText(aVar.e);
            c0095a.i.setVisibility(0);
        } else {
            c0095a.i.setVisibility(8);
        }
        if ((a & 8) != 0) {
            c0095a.j.setText(aVar.a);
            c0095a.j.setVisibility(0);
        } else {
            c0095a.j.setVisibility(8);
        }
        return view;
    }

    public void a(ArrayList<com.jumobile.manager.systemapp.d.a> arrayList) {
        this.c = arrayList;
    }

    public ArrayList<com.jumobile.manager.systemapp.d.a> a() {
        if (this.c == null) {
            return null;
        }
        ArrayList<com.jumobile.manager.systemapp.d.a> arrayList = new ArrayList<>();
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.a next = it.next();
            if (next.i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int b() {
        int i = 0;
        if (this.c != null) {
            Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
            while (it.hasNext()) {
                if (it.next().i) {
                    i++;
                }
            }
        }
        return i;
    }

    public com.jumobile.manager.systemapp.d.a c() {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.a next = it.next();
            if (next.i) {
                return next;
            }
        }
        return null;
    }

    public com.jumobile.manager.systemapp.d.a a(int i) {
        if (this.c != null && i < this.c.size()) {
            return this.c.get(i);
        }
        return null;
    }

    public void a(boolean z) {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().i = z;
        }
    }

    public boolean d() {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        while (it.hasNext()) {
            if (!it.next().i) {
                return false;
            }
        }
        return true;
    }

    public boolean b(int i) {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.a next = it.next();
            if (next.b == i && !next.i) {
                return false;
            }
        }
        return true;
    }

    public void a(int i, boolean z) {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.a next = it.next();
            if (i == next.b) {
                next.i = z;
            }
        }
    }

    public void c(int i) {
        a(i, !b(i));
    }

    public int d(int i) {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (i == it.next().b) {
                i2++;
            }
        }
        return i2;
    }

    public int e(int i) {
        Iterator<com.jumobile.manager.systemapp.d.a> it = this.c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.a next = it.next();
            if (i == next.b && next.i) {
                i2++;
            }
        }
        return i2;
    }
}
