package com.jumobile.manager.systemapp.ui.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.ClipboardManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: source */
/* loaded from: classes.dex */
public class i extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {
    private static final String a = "i";
    private final Context b;
    private final com.jumobile.manager.systemapp.d.g c;

    public i(Context context, com.jumobile.manager.systemapp.d.g gVar) {
        super(context, R.style.BaseDialog);
        this.b = context;
        this.c = gVar;
        setContentView(R.layout.dialog_app_info);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(this);
        a();
    }

    private void a() {
        ((ImageView) findViewById(R.id.app_icon)).setImageDrawable(this.c.b(this.b));
        ((TextView) findViewById(R.id.app_name)).setText(this.c.f);
        ((TextView) findViewById(R.id.install_time)).setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(this.c.c)));
        ((TextView) findViewById(R.id.app_size)).setText(com.jumobile.manager.systemapp.util.f.a(this.c.h));
        ((TextView) findViewById(R.id.app_package)).setText(this.c.b.packageName);
        ((TextView) findViewById(R.id.source_dir)).setText(this.c.b.sourceDir);
        findViewById(R.id.action_show_detail).setOnClickListener(this);
        findViewById(R.id.action_search_in_market).setOnClickListener(this);
        findViewById(R.id.action_search_in_website).setOnClickListener(this);
        if (this.b.getPackageManager().getLaunchIntentForPackage(this.c.b.packageName) != null) {
            findViewById(R.id.action_open).setOnClickListener(this);
        } else {
            findViewById(R.id.action_open).setVisibility(8);
        }
        findViewById(R.id.btn_copy_package).setOnClickListener(this);
        findViewById(R.id.btn_copy_source_dir).setOnClickListener(this);
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
        }
        int id = view.getId();
        switch (id) {
            case R.id.action_open /* 2131230795 */:
                com.jumobile.manager.systemapp.util.f.h(this.b, this.c.b.packageName);
                dismiss();
                break;
            case R.id.action_search_in_market /* 2131230796 */:
                com.jumobile.manager.systemapp.util.f.g(this.b, this.c.b.packageName);
                dismiss();
                break;
            case R.id.action_search_in_website /* 2131230797 */:
                g gVar = new g(this.b, new File(this.c.b.sourceDir).getName(), this.c.b.packageName, this.c.f);
                if (!((Activity) this.b).isFinishing()) {
                    gVar.show();
                }
                dismiss();
                break;
            case R.id.action_show_detail /* 2131230798 */:
                com.jumobile.manager.systemapp.util.f.i(this.b, this.c.b.packageName);
                dismiss();
                break;
            default:
                switch (id) {
                    case R.id.btn_copy_package /* 2131230845 */:
                        ((ClipboardManager) this.b.getSystemService("clipboard")).setText(this.c.b.packageName);
                        com.jumobile.manager.systemapp.util.f.a(this.b, R.string.common_copyed_to_clipboard);
                        break;
                    case R.id.btn_copy_source_dir /* 2131230846 */:
                        ((ClipboardManager) this.b.getSystemService("clipboard")).setText(this.c.b.sourceDir);
                        com.jumobile.manager.systemapp.util.f.a(this.b, R.string.common_copyed_to_clipboard);
                        break;
                }
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
