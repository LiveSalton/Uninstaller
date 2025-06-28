package com.jumobile.manager.systemapp.ui.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private InterfaceC0094a a;
    private Context b;
    private ArrayList<com.jumobile.manager.systemapp.d.d> c = null;

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.a$a */
    public interface InterfaceC0094a {
        void a(int i);
    }

    public void a(InterfaceC0094a interfaceC0094a) {
        this.a = interfaceC0094a;
    }

    /* compiled from: source */
    class b {
        com.jumobile.manager.systemapp.d.d a;
        TextView b;
        TextView c;

        b() {
        }
    }

    public a(Context context) {
        this.b = context;
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
        return this.c.get(i).a;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.list_item_directory_chooser, (ViewGroup) null);
            bVar = new b();
            bVar.b = (TextView) view.findViewById(R.id.folder_name);
            bVar.c = (TextView) view.findViewById(R.id.btn_select);
            bVar.c.setOnClickListener(this);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.jumobile.manager.systemapp.d.d dVar = this.c.get(i);
        bVar.a = dVar;
        bVar.b.setText(dVar.b);
        bVar.c.setTag(Integer.valueOf(i));
        return view;
    }

    public void a(ArrayList<com.jumobile.manager.systemapp.d.d> arrayList) {
        this.c = arrayList;
    }

    public com.jumobile.manager.systemapp.d.d a(int i) {
        return this.c.get(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || view.getTag() == null) {
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.a != null) {
            this.a.a(intValue);
        }
    }
}
