package com.jumobile.manager.systemapp.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class c extends Dialog {
    private static final String i = "c";
    public final Context a;
    public View b;
    public ImageView c;
    public TextView d;
    public LinearLayout e;
    public LinearLayout f;
    public Button g;
    public Button h;

    public c(Context context) {
        super(context, R.style.BaseDialog);
        this.a = context;
        setContentView(R.layout.dialog_base);
        this.b = findViewById(R.id.title);
        this.c = (ImageView) findViewById(R.id.title_icon);
        this.d = (TextView) findViewById(R.id.title_text);
        this.e = (LinearLayout) findViewById(R.id.content);
        this.f = (LinearLayout) findViewById(R.id.btn_container);
        this.g = (Button) findViewById(R.id.btn_left);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.a.c.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.h = (Button) findViewById(R.id.btn_right);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.a.c.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.a.c$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.a.c$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        this.d.setText(i2);
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

    public View a(int i2) {
        View inflate = getLayoutInflater().inflate(i2, (ViewGroup) null);
        this.e.addView(inflate);
        return inflate;
    }
}
