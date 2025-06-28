package com.jumobile.manager.systemapp;

import androidx.lifecycle.d;
import androidx.lifecycle.f;
import androidx.lifecycle.j;
import androidx.lifecycle.n;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppOpenManager_LifecycleAdapter implements d {
    final AppOpenManager a;

    AppOpenManager_LifecycleAdapter(AppOpenManager appOpenManager) {
        this.a = appOpenManager;
    }

    @Override // androidx.lifecycle.d
    public void a(j jVar, f.a aVar, boolean z, n nVar) {
        boolean z2 = nVar != null;
        if (!z && aVar == f.a.ON_START) {
            if (!z2 || nVar.a("onStart", 1)) {
                this.a.onStart();
            }
        }
    }
}
