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
public class e extends BaseAdapter {
    private Context a;
    private com.jumobile.manager.systemapp.util.b b;
    private int e;
    private ArrayList<com.jumobile.manager.systemapp.d.g> c = null;
    private Drawable d = null;
    private boolean f = true;

    /* compiled from: source */
    static class a {
        TextView a;
        ImageView b;
        TextView c;
        TextView d;
        TextView e;
        CheckBox f;
        TextView g;
        TextView h;
        TextView i;

        a() {
        }
    }

    public e(Context context, int i) {
        this.b = null;
        this.a = context;
        this.b = new com.jumobile.manager.systemapp.util.b(this.a);
        this.e = i;
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
        if (this.c != null) {
            return this.c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.c != null ? this.c.get(i).k : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.list_item_move_app, (ViewGroup) null);
            aVar = new a();
            aVar.b = (ImageView) view.findViewById(R.id.app_icon);
            aVar.a = (TextView) view.findViewById(R.id.app_name);
            aVar.c = (TextView) view.findViewById(R.id.app_size);
            aVar.d = (TextView) view.findViewById(R.id.app_version);
            aVar.e = (TextView) view.findViewById(R.id.btn_move);
            aVar.f = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
            aVar.g = (TextView) view.findViewById(R.id.app_time);
            aVar.h = (TextView) view.findViewById(R.id.app_package);
            aVar.i = (TextView) view.findViewById(R.id.app_path);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.jumobile.manager.systemapp.d.g gVar = this.c.get(i);
        if (gVar.f != null) {
            aVar.a.setText(gVar.f.trim());
        }
        this.d = this.b.b(gVar);
        if (this.d != null) {
            aVar.b.setImageDrawable(this.d);
        } else {
            aVar.b.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_default));
        }
        aVar.c.setText(com.jumobile.manager.systemapp.util.f.a(gVar.h));
        aVar.d.setText(com.jumobile.manager.systemapp.util.f.d(this.a, gVar.g));
        if (this.f) {
            aVar.e.setVisibility(8);
            aVar.f.setVisibility(0);
            aVar.f.setChecked(gVar.i);
        } else {
            aVar.e.setVisibility(0);
            aVar.e.setEnabled(com.jumobile.manager.systemapp.d.g.l == gVar.a(this.a));
            aVar.f.setVisibility(8);
            switch (this.e) {
                case 1:
                    aVar.e.setText(R.string.move_app_btn_move_to_sdcard);
                    break;
                case 2:
                    aVar.e.setText(R.string.move_app_btn_move_to_phone);
                    break;
            }
        }
        int a2 = com.jumobile.manager.systemapp.f.a.a(this.a, "move_app_extra_info", 0);
        if ((a2 & 2) != 0) {
            aVar.g.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(gVar.c)));
            aVar.g.setVisibility(0);
        } else {
            aVar.g.setVisibility(8);
        }
        if ((a2 & 4) != 0) {
            aVar.h.setText(gVar.b.packageName);
            aVar.h.setVisibility(0);
        } else {
            aVar.h.setVisibility(8);
        }
        if ((a2 & 8) != 0) {
            aVar.i.setText(gVar.b.sourceDir);
            aVar.i.setVisibility(0);
        } else {
            aVar.i.setVisibility(8);
        }
        return view;
    }

    public void a(ArrayList<com.jumobile.manager.systemapp.d.g> arrayList) {
        this.c = arrayList;
        Iterator<com.jumobile.manager.systemapp.d.g> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.g next = it.next();
            if (next.b.packageName.equals(this.a.getPackageName())) {
                this.c.remove(next);
                return;
            }
        }
    }

    public com.jumobile.manager.systemapp.d.g a(int i) {
        if (this.c == null) {
            return null;
        }
        return this.c.get(i);
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b(boolean z) {
        if (this.c == null) {
            return;
        }
        Iterator<com.jumobile.manager.systemapp.d.g> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().i = z;
        }
    }

    public boolean a() {
        if (this.c == null || this.c.size() == 0) {
            return false;
        }
        Iterator<com.jumobile.manager.systemapp.d.g> it = this.c.iterator();
        while (it.hasNext()) {
            if (!it.next().i) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<com.jumobile.manager.systemapp.d.g> b() {
        ArrayList<com.jumobile.manager.systemapp.d.g> arrayList = new ArrayList<>();
        if (this.c != null) {
            Iterator<com.jumobile.manager.systemapp.d.g> it = this.c.iterator();
            while (it.hasNext()) {
                com.jumobile.manager.systemapp.d.g next = it.next();
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
            Iterator<com.jumobile.manager.systemapp.d.g> it = this.c.iterator();
            while (it.hasNext()) {
                if (it.next().i) {
                    i++;
                }
            }
        }
        return i;
    }

    public long d() {
        long j = 0;
        if (this.c != null) {
            Iterator<com.jumobile.manager.systemapp.d.g> it = this.c.iterator();
            while (it.hasNext()) {
                com.jumobile.manager.systemapp.d.g next = it.next();
                if (next.i) {
                    j += next.h;
                }
            }
        }
        return j;
    }
}
