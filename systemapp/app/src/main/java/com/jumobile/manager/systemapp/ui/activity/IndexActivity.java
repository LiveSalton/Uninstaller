package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.jumobile.manager.systemapp.AppOpenManager;
import com.jumobile.manager.systemapp.InitApp;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.util.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class IndexActivity extends Activity implements AppOpenManager.a {
    private static final String a = "IndexActivity";
    private Context b;
    private Handler c = new Handler();
    private Runnable d = new Runnable(this) { // from class: com.jumobile.manager.systemapp.ui.activity.b
        private final IndexActivity a;

        {
            this.a = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g();
        }
    };
    private Runnable e = new Runnable(this) { // from class: com.jumobile.manager.systemapp.ui.activity.c
        private final IndexActivity a;

        {
            this.a = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f();
        }
    };

    @Override // com.jumobile.manager.systemapp.AppOpenManager.a
    public void e() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        InitApp.a().a(this);
        if (!com.jumobile.manager.systemapp.f.a.a(getApplicationContext(), "papers_agreed", false)) {
            setContentView(R.layout.activity_privacy_policy);
            ((TextView) findViewById(R.id.hint)).setText(this.b.getString(R.string.b7w, this.b.getString(R.string.b7y), this.b.getString(R.string.b80)));
            TextView textView = (TextView) findViewById(R.id.privacy_policy_text);
            textView.getPaint().setFlags(8);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.IndexActivity.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(IndexActivity.this.b, (Class<?>) WebPageActivity.class);
                    intent.putExtra("extra_url", "http://www.multiabc.com/wp-content/uploads/privacy_policy_system_app_remover.html");
                    IndexActivity.this.startActivity(intent);
                }
            });
            TextView textView2 = (TextView) findViewById(R.id.terms_service_text);
            textView2.getPaint().setFlags(8);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.IndexActivity.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(IndexActivity.this.b, (Class<?>) WebPageActivity.class);
                    intent.putExtra("extra_url", "http://www.multiabc.com/wp-content/uploads/terms_service_system_app_remover.html");
                    IndexActivity.this.startActivity(intent);
                }
            });
            findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.IndexActivity.3
                AnonymousClass3() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!((CheckBox) IndexActivity.this.findViewById(R.id.privacy_policy_checkbox)).isChecked() || !((CheckBox) IndexActivity.this.findViewById(R.id.terms_service_checkbox)).isChecked()) {
                        f.a(IndexActivity.this.b, R.string.b7x);
                        return;
                    }
                    com.jumobile.manager.systemapp.f.a.b(IndexActivity.this.getApplicationContext(), "papers_agreed", true);
                    IndexActivity.this.setContentView(R.layout.admob_splash);
                    IndexActivity.this.c.postDelayed(IndexActivity.this.e, 200L);
                }
            });
            return;
        }
        if (com.jumobile.manager.systemapp.f.a.a(this.b, "ads_enabled", true)) {
            setContentView(R.layout.admob_splash);
            f();
        } else {
            setContentView(R.layout.admob_splash);
            this.c.postDelayed(this.d, 200L);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.IndexActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(IndexActivity.this.b, (Class<?>) WebPageActivity.class);
            intent.putExtra("extra_url", "http://www.multiabc.com/wp-content/uploads/privacy_policy_system_app_remover.html");
            IndexActivity.this.startActivity(intent);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.IndexActivity$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(IndexActivity.this.b, (Class<?>) WebPageActivity.class);
            intent.putExtra("extra_url", "http://www.multiabc.com/wp-content/uploads/terms_service_system_app_remover.html");
            IndexActivity.this.startActivity(intent);
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.IndexActivity$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!((CheckBox) IndexActivity.this.findViewById(R.id.privacy_policy_checkbox)).isChecked() || !((CheckBox) IndexActivity.this.findViewById(R.id.terms_service_checkbox)).isChecked()) {
                f.a(IndexActivity.this.b, R.string.b7x);
                return;
            }
            com.jumobile.manager.systemapp.f.a.b(IndexActivity.this.getApplicationContext(), "papers_agreed", true);
            IndexActivity.this.setContentView(R.layout.admob_splash);
            IndexActivity.this.c.postDelayed(IndexActivity.this.e, 200L);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        InitApp.a().a((AppOpenManager.a) null);
        super.onDestroy();
    }

    /* renamed from: h */
    public void f() {
        AppOpenManager a2 = InitApp.a();
        if (a2.b()) {
            a2.c();
        } else {
            a2.a();
            this.c.postDelayed(this.d, 5000L);
        }
    }

    /* renamed from: i */
    public void g() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // com.jumobile.manager.systemapp.AppOpenManager.a
    public void a() {
        if (com.jumobile.manager.systemapp.f.a.a(getApplicationContext(), "papers_agreed", false)) {
            this.c.removeCallbacks(this.d);
            InitApp.a().c();
        }
    }

    @Override // com.jumobile.manager.systemapp.AppOpenManager.a
    public void b() {
        if (com.jumobile.manager.systemapp.f.a.a(getApplicationContext(), "papers_agreed", false)) {
            this.c.removeCallbacks(this.d);
            this.c.post(this.d);
        }
    }

    @Override // com.jumobile.manager.systemapp.AppOpenManager.a
    public void c() {
        g();
    }

    @Override // com.jumobile.manager.systemapp.AppOpenManager.a
    public void d() {
        g();
    }
}
