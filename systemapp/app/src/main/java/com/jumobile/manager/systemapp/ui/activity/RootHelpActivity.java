package com.jumobile.manager.systemapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class RootHelpActivity extends Activity implements View.OnClickListener {
    private static final String a = "RootHelpActivity";
    private Context b;
    private com.jumobile.manager.systemapp.a.b c = com.jumobile.manager.systemapp.a.b.j();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.b).a(a);
        setContentView(R.layout.activity_root_help);
        a();
        this.c.m(this);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.activity.RootHelpActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RootHelpActivity.this.finish();
            RootHelpActivity.this.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            r4 = this;
            r0 = 2131230775(0x7f080037, float:1.8077612E38)
            android.view.View r0 = r4.findViewById(r0)
            com.jumobile.manager.systemapp.ui.widget.ActionBar r0 = (com.jumobile.manager.systemapp.ui.widget.ActionBar) r0
            android.widget.ImageButton r0 = r0.a
            com.jumobile.manager.systemapp.ui.activity.RootHelpActivity$1 r1 = new com.jumobile.manager.systemapp.ui.activity.RootHelpActivity$1
            r1.<init>()
            r0.setOnClickListener(r1)
            r0 = 2131230852(0x7f080084, float:1.8077768E38)
            android.view.View r0 = r4.findViewById(r0)
            r0.setOnClickListener(r4)
            r0 = 0
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch: java.lang.Exception -> L62
            java.lang.String r1 = r1.getLanguage()     // Catch: java.lang.Exception -> L62
            java.util.Locale r2 = java.util.Locale.TAIWAN     // Catch: java.lang.Exception -> L62
            java.lang.String r2 = r2.getLanguage()     // Catch: java.lang.Exception -> L62
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Exception -> L62
            if (r2 != 0) goto L50
            java.util.Locale r2 = java.util.Locale.CHINESE     // Catch: java.lang.Exception -> L62
            java.lang.String r2 = r2.getLanguage()     // Catch: java.lang.Exception -> L62
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L3f
            goto L50
        L3f:
            android.content.Context r1 = r4.b     // Catch: java.lang.Exception -> L62
            java.lang.String r2 = "about_root_content_en"
            java.lang.String r1 = com.jumobile.manager.systemapp.e.a.a(r1, r2)     // Catch: java.lang.Exception -> L62
            android.content.Context r2 = r4.b     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = "how_to_root_content_en"
            java.lang.String r2 = com.jumobile.manager.systemapp.e.a.a(r2, r3)     // Catch: java.lang.Exception -> L63
            goto L60
        L50:
            android.content.Context r1 = r4.b     // Catch: java.lang.Exception -> L62
            java.lang.String r2 = "about_root_content_zh"
            java.lang.String r1 = com.jumobile.manager.systemapp.e.a.a(r1, r2)     // Catch: java.lang.Exception -> L62
            android.content.Context r2 = r4.b     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = "how_to_root_content_zh"
            java.lang.String r2 = com.jumobile.manager.systemapp.e.a.a(r2, r3)     // Catch: java.lang.Exception -> L63
        L60:
            r0 = r2
            goto L63
        L62:
            r1 = r0
        L63:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L75
            r2 = 2131230741(0x7f080015, float:1.8077543E38)
            android.view.View r2 = r4.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setText(r1)
        L75:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L87
            r1 = 2131230930(0x7f0800d2, float:1.8077927E38)
            android.view.View r1 = r4.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setText(r0)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.ui.activity.RootHelpActivity.a():void");
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
        if (view != null && view.getId() == R.id.btn_serach_my_device) {
            a(Build.MODEL + " root");
        }
    }

    private void a(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.WEB_SEARCH");
            intent.putExtra("query", str);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
