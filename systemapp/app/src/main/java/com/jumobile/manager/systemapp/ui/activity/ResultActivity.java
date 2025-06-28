package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.a.b;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;

/* compiled from: source */
/* loaded from: classes.dex */
public class ResultActivity extends Activity implements View.OnClickListener {
    private static final String a = "ResultActivity";
    private Context b;
    private com.jumobile.manager.systemapp.a.b c = com.jumobile.manager.systemapp.a.b.j();
    private FrameLayout d;
    private String e;
    private String f;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.b).a(a);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.e = intent.getStringExtra("extra_title");
        this.f = intent.getStringExtra("extra_message");
        a();
        this.c.a(8);
        this.c.a(new b.a() { // from class: com.jumobile.manager.systemapp.ui.activity.ResultActivity.1
            AnonymousClass1() {
            }

            @Override // com.jumobile.manager.systemapp.a.b.a
            public void a() {
                View a2 = ResultActivity.this.c.a(0, false);
                if (a2 != null) {
                    ResultActivity.this.d.removeAllViews();
                    ResultActivity.this.d.addView(a2);
                }
            }
        });
        this.c.m(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.ResultActivity$1 */
    class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.jumobile.manager.systemapp.a.b.a
        public void a() {
            View a2 = ResultActivity.this.c.a(0, false);
            if (a2 != null) {
                ResultActivity.this.d.removeAllViews();
                ResultActivity.this.d.addView(a2);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.ResultActivity$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ResultActivity.this.finish();
            ResultActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    private void a() {
        ActionBar actionBar = (ActionBar) findViewById(R.id.action_bar);
        actionBar.a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.ResultActivity.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ResultActivity.this.finish();
                ResultActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });
        if (!TextUtils.isEmpty(this.e)) {
            actionBar.b.setText(this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            ((TextView) findViewById(R.id.message)).setText(this.f);
        }
        this.d = (FrameLayout) findViewById(R.id.ad_native);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.c.k();
        com.jumobile.manager.systemapp.util.e.a(this.b).b(a);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        view.getId();
    }
}
