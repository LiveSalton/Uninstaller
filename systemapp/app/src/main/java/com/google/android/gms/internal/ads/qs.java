package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class qs implements zzahv<Object> {
    private WeakReference<zzcbb> a;

    /* JADX INFO: Access modifiers changed from: private */
    qs(zzcbb zzcbbVar) {
        this.a = new WeakReference<>(zzcbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        zzcbb zzcbbVar = this.a.get();
        if (zzcbbVar == null) {
            return;
        }
        zzcbbVar.h.e();
    }

    /* synthetic */ qs(zzcbb zzcbbVar, qq qqVar) {
        this(zzcbbVar);
    }
}
