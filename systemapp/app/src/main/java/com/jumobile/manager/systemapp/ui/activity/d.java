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
import com.jumobile.manager.systemapp.util.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private Context a;
    private com.jumobile.manager.systemapp.util.b b;
    private ArrayList<com.jumobile.manager.systemapp.d.e> c = null;
    private Drawable d = null;

    /* compiled from: source */
    class a {
        com.jumobile.manager.systemapp.d.e a;
        TextView b;
        ImageView c;
        TextView d;
        CheckBox e;

        a() {
        }
    }

    public d(Context context) {
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
            view = LayoutInflater.from(this.a).inflate(R.layout.list_item_recycle_bin, (ViewGroup) null);
            aVar = new a();
            aVar.c = (ImageView) view.findViewById(R.id.app_icon);
            aVar.b = (TextView) view.findViewById(R.id.app_name);
            aVar.d = (TextView) view.findViewById(R.id.app_size);
            aVar.e = (CheckBox) view.findViewById(R.id.checkbox_app_selected);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.jumobile.manager.systemapp.d.e eVar = this.c.get(i);
        aVar.a = eVar;
        aVar.b.setText(eVar.f.trim());
        this.d = this.b.b(eVar);
        if (this.d != null) {
            aVar.c.setImageDrawable(this.d);
        } else {
            aVar.c.setImageDrawable(this.a.getResources().getDrawable(R.drawable.icon_default));
        }
        aVar.d.setText(f.a(eVar.h));
        aVar.e.setChecked(eVar.i);
        return view;
    }

    public void a(ArrayList<com.jumobile.manager.systemapp.d.e> arrayList) {
        this.c = arrayList;
    }

    public com.jumobile.manager.systemapp.d.e a(int i) {
        return this.c.get(i);
    }

    public void a(boolean z) {
        Iterator<com.jumobile.manager.systemapp.d.e> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().i = z;
        }
    }

    public boolean a() {
        if (this.c == null || this.c.size() == 0) {
            return false;
        }
        Iterator<com.jumobile.manager.systemapp.d.e> it = this.c.iterator();
        while (it.hasNext()) {
            if (!it.next().i) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<com.jumobile.manager.systemapp.d.e> b() {
        ArrayList<com.jumobile.manager.systemapp.d.e> arrayList = new ArrayList<>();
        Iterator<com.jumobile.manager.systemapp.d.e> it = this.c.iterator();
        while (it.hasNext()) {
            com.jumobile.manager.systemapp.d.e next = it.next();
            if (next.i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int c() {
        int i = 0;
        if (this.c != null) {
            Iterator<com.jumobile.manager.systemapp.d.e> it = this.c.iterator();
            while (it.hasNext()) {
                if (it.next().i) {
                    i++;
                }
            }
        }
        return i;
    }
}
