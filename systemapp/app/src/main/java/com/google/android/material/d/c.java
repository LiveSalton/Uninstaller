package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: source */
/* loaded from: classes.dex */
public final class c {
    private final View a;
    private boolean b = false;
    private int c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.a = (View) bVar;
    }

    public boolean a() {
        return this.b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            d();
        }
    }

    public void a(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    private void d() {
        ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).b(this.a);
        }
    }
}
