package com.jumobile.manager.systemapp.ui.widget.slidingmenu.app;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;

/* compiled from: source */
/* loaded from: classes.dex */
public class SlidingFragmentActivity extends FragmentActivity {
    private a k;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = new a(this);
        this.k.a(bundle);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.k.b(bundle);
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        View findViewById = super.findViewById(i);
        return findViewById != null ? findViewById : this.k.a(i);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.k.c(bundle);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.k.a(view, layoutParams);
    }

    public void setBehindContentView(View view) {
        a(view, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.k.b(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean a = this.k.a(i, keyEvent);
        return a ? a : super.onKeyUp(i, keyEvent);
    }
}
