package com.jumobile.manager.systemapp.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class LoadingAnimView extends LinearLayout {
    final a a;
    private Context b;
    private ImageView c;
    private TextView d;
    private TextView e;

    public LoadingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new a();
        this.b = context.getApplicationContext();
        setOrientation(1);
        setGravity(17);
        inflate(this.b, R.layout.view_loading_anim, this);
        a();
    }

    public void setLoadingText(int i) {
        this.d.setText(i);
    }

    private void a() {
        this.c = (ImageView) findViewById(R.id.loading_icon);
        this.d = (TextView) findViewById(R.id.loading_text);
        this.e = (TextView) findViewById(R.id.loading_symbol);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            ((AnimationDrawable) this.c.getDrawable()).start();
            this.a.sendMessage(this.a.obtainMessage(1, 0, 0));
        } else {
            ((AnimationDrawable) this.c.getDrawable()).stop();
            this.a.removeMessages(1);
        }
    }

    /* compiled from: source */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int i = message.arg1 % 3;
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(".");
            }
            LoadingAnimView.this.e.setText(sb);
            sendMessageDelayed(obtainMessage(1, message.arg1 + 1, 0), 300L);
        }
    }
}
