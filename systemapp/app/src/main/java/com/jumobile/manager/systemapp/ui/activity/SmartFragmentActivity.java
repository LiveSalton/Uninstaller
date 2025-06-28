package com.jumobile.manager.systemapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.n;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class SmartFragmentActivity extends FragmentActivity {
    private static final String k = "SmartFragmentActivity";
    private Context l;
    private com.jumobile.manager.systemapp.ui.fragment.c m;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getApplicationContext();
        setContentView(R.layout.activity_smart_fragment);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        try {
            this.m = (com.jumobile.manager.systemapp.ui.fragment.c) Class.forName(intent.getStringExtra("extra_fragment_class_name")).newInstance();
            this.m.b(intent.getExtras());
            this.m.as();
        } catch (Exception unused) {
        }
        n a = m().a();
        a.a(R.id.fragment_container, this.m);
        a.b();
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
        super.onDestroy();
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
