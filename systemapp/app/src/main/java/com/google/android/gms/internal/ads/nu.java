package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
final class nu implements Runnable {
    private final WeakReference<zzbua> a;

    /* JADX INFO: Access modifiers changed from: private */
    nu(zzbua zzbuaVar) {
        this.a = new WeakReference<>(zzbuaVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbua zzbuaVar = this.a.get();
        if (zzbuaVar != null) {
            zzbuaVar.d();
        }
    }

    /* synthetic */ nu(zzbua zzbuaVar, ns nsVar) {
        this(zzbuaVar);
    }
}
