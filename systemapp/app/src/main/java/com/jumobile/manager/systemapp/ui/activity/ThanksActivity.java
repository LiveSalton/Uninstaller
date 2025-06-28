package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;

/* compiled from: source */
/* loaded from: classes.dex */
public class ThanksActivity extends Activity {
    private static final String a = "ThanksActivity";
    private Context b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.b).a(a);
        setContentView(R.layout.activity_thanks);
        a();
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.ThanksActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThanksActivity.this.finish();
            ThanksActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    private void a() {
        ((ActionBar) findViewById(R.id.action_bar)).a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.ThanksActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThanksActivity.this.finish();
                ThanksActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });
        String a2 = com.jumobile.manager.systemapp.e.a.a(this.b, "thanks_translate_content");
        if (!TextUtils.isEmpty(a2)) {
            ((TextView) findViewById(R.id.thanks_translate_content)).setText(a2);
        }
        String a3 = com.jumobile.manager.systemapp.e.a.a(this.b, "thanks_donate_content");
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        ((TextView) findViewById(R.id.thanks_donate_content)).setText(a3);
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
        com.jumobile.manager.systemapp.util.e.a(this.b).b(a);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }
}
