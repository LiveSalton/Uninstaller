package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.widget.ActionBar;

/* compiled from: source */
/* loaded from: classes.dex */
public class FeedBackActivity extends Activity implements View.OnClickListener {
    private static final String a = "FeedBackActivity";
    private Context b;
    private Handler c;
    private EditText d;
    private EditText e;
    private Button f;
    private Button g;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.b).a(a);
        this.c = new Handler();
        setContentView(R.layout.activity_feedback);
        ((ActionBar) findViewById(R.id.action_bar)).a.setOnClickListener(new View.OnClickListener() { // from class: com.jumobile.manager.systemapp.ui.activity.FeedBackActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedBackActivity.this.finish();
                FeedBackActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
            }
        });
        this.d = (EditText) findViewById(R.id.description);
        this.e = (EditText) findViewById(R.id.contact);
        this.f = (Button) findViewById(R.id.btn_left);
        this.g = (Button) findViewById(R.id.btn_right);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.FeedBackActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedBackActivity.this.finish();
            FeedBackActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.jumobile.manager.systemapp.util.e.a(this.b).b(a);
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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_left) {
            this.d.setText("");
            this.e.setText("");
        } else {
            if (id != R.id.btn_right) {
                return;
            }
            if (this.d.getText().toString().replace(" ", "").length() == 0) {
                a(R.string.feedback_toast_please_input);
                return;
            }
            try {
                this.e.getText().toString();
            } catch (Exception unused) {
            }
            a(R.string.feedback_toast_send_complete);
            finish();
        }
    }

    private void a(int i) {
        Toast.makeText(this.b, i, 0).show();
    }
}
