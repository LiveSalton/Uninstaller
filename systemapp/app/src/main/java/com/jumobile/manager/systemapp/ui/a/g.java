package com.jumobile.manager.systemapp.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class g extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
    private static final String a = "g";
    private final Context b;
    private final String c;
    private final String d;
    private final String e;

    public g(Context context, String str, String str2, String str3) {
        super(context, R.style.BaseDialog);
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        setContentView(R.layout.dialog_search_select);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(this);
        a();
    }

    private void a() {
        findViewById(R.id.search_apk_name).setOnClickListener(this);
        findViewById(R.id.search_package_name).setOnClickListener(this);
        findViewById(R.id.search_app_name).setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id != R.id.search_package_name) {
            switch (id) {
                case R.id.search_apk_name /* 2131231030 */:
                    a(this.c);
                    dismiss();
                    break;
                case R.id.search_app_name /* 2131231031 */:
                    a(this.e);
                    dismiss();
                    break;
            }
            return;
        }
        a(this.d);
        dismiss();
    }

    private void a(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.WEB_SEARCH");
            intent.putExtra("query", str);
            this.b.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        dismiss();
        return true;
    }
}
