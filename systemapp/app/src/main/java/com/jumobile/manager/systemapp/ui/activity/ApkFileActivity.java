package com.jumobile.manager.systemapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.n;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class ApkFileActivity extends FragmentActivity {
    private static final String k = "ApkFileActivity";
    private Context l;
    private com.jumobile.manager.systemapp.ui.fragment.b m;
    private com.jumobile.manager.systemapp.inappbilling.a n = new com.jumobile.manager.systemapp.inappbilling.a();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getApplicationContext();
        com.jumobile.manager.systemapp.util.e.a(this.l).a(k);
        setContentView(R.layout.activity_user_app);
        this.m = new com.jumobile.manager.systemapp.ui.fragment.b();
        this.m.as();
        n a = m().a();
        a.a(R.id.fragment_container, this.m);
        a.b();
        this.n.a(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.n.a();
        super.onDestroy();
        com.jumobile.manager.systemapp.util.e.a(this.l).b(k);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z;
        try {
            z = this.m.av();
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return;
        }
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 6) {
            this.n.a(i, i2, intent);
        }
        try {
            this.m.a(i, i2, intent);
        } catch (Exception unused) {
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.a.InterfaceC0017a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            this.m.a(i, strArr, iArr);
        } catch (Exception unused) {
        }
    }
}
