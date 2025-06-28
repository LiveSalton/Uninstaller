package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepu extends androidx.browser.customtabs.d {
    private WeakReference<zzept> a;

    public zzepu(zzept zzeptVar) {
        this.a = new WeakReference<>(zzeptVar);
    }

    @Override // androidx.browser.customtabs.d
    public final void a(ComponentName componentName, androidx.browser.customtabs.b bVar) {
        zzept zzeptVar = this.a.get();
        if (zzeptVar != null) {
            zzeptVar.a(bVar);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzept zzeptVar = this.a.get();
        if (zzeptVar != null) {
            zzeptVar.b();
        }
    }
}
