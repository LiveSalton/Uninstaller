package com.jumobile.manager.systemapp.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class d extends Dialog implements DialogInterface.OnKeyListener {
    private static final String a = "d";
    private final Context b;
    private LinearLayout c;

    public d(Context context, int i) {
        super(context, R.style.BaseDialog);
        this.b = context;
        setContentView(R.layout.dialog_button_list);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setOnKeyListener(this);
        ((TextView) findViewById(R.id.title)).setText(i);
        this.c = (LinearLayout) findViewById(R.id.button_container);
    }

    public Button a(String str, View.OnClickListener onClickListener) {
        Button button = new Button(this.b, null, R.attr.recommendButtonItemStyle);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        button.setText(str);
        button.setOnClickListener(onClickListener);
        this.c.addView(button);
        return button;
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
