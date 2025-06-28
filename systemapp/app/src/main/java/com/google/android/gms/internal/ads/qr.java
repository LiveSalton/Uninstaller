package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class qr implements zzahv<Object> {
    private WeakReference<zzcbb> a;

    /* JADX INFO: Access modifiers changed from: private */
    qr(zzcbb zzcbbVar) {
        this.a = new WeakReference<>(zzcbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        zzcbb zzcbbVar = this.a.get();
        if (zzcbbVar == null) {
            return;
        }
        zzcbbVar.g.a();
    }

    /* synthetic */ qr(zzcbb zzcbbVar, qq qqVar) {
        this(zzcbbVar);
    }
}
