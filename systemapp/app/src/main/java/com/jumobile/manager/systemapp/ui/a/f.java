package com.jumobile.manager.systemapp.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends c implements DialogInterface.OnKeyListener, View.OnClickListener {
    private static final String j = "com.jumobile.manager.systemapp.ui.a.f";
    public TextView i;
    private a k;
    private TextView l;
    private ProgressBar m;
    private TextView n;

    /* compiled from: source */
    public interface a {
        boolean a();
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    public void a(String str) {
        this.l.setText(str);
    }

    public f(Context context) {
        super(context);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        View a2 = a(R.layout.dialog_progress_bar);
        this.l = (TextView) a2.findViewById(R.id.message);
        this.m = (ProgressBar) a2.findViewById(R.id.progressbar);
        this.n = (TextView) a2.findViewById(R.id.progressbar_progress_percent);
        this.i = (TextView) a2.findViewById(R.id.progressbar_progress_size);
        setOnKeyListener(this);
        this.g.setVisibility(8);
        this.h.setText(R.string.common_cancel);
        this.h.setBackgroundResource(R.drawable.selector_btn_recommend);
        this.h.setOnClickListener(this);
    }

    public void a(int i, int i2) {
        int i3 = i2 > 0 ? (i * 100) / i2 : 100;
        this.m.setProgress(i3);
        this.n.setText(String.valueOf(i3) + "%");
        this.i.setText(String.valueOf(i) + "/" + String.valueOf(i2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() == R.id.btn_right) {
            a();
        }
    }

    private void a() {
        if (this.k != null) {
            this.k.a();
        }
        this.l.setText(R.string.dialog_progress_bar_canceling);
        this.f.setVisibility(8);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        a();
        return true;
    }
}
