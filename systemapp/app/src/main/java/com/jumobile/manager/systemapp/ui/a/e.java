package com.jumobile.manager.systemapp.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends c implements DialogInterface.OnKeyListener, View.OnClickListener {
    public CheckBox i;
    private TextView j;
    private TextView k;

    public e(Context context, CharSequence charSequence) {
        super(context);
        a();
        this.j.setText(charSequence);
    }

    public e(Context context, int i) {
        super(context);
        a();
        this.j.setText(i);
    }

    public e(Context context, CharSequence charSequence, int i) {
        super(context);
        a();
        this.j.setText(charSequence);
        this.k.setText(i);
        this.k.setVisibility(0);
    }

    private void a() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        View a = a(R.layout.dialog_confirm);
        this.j = (TextView) a.findViewById(R.id.message);
        this.k = (TextView) a.findViewById(R.id.hint);
        this.i = (CheckBox) a.findViewById(R.id.no_remind);
        setOnKeyListener(this);
        this.h.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() == R.id.btn_right) {
            dismiss();
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
