package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class qp implements zzahv<Object> {
    private WeakReference<zzcbb> a;

    /* JADX INFO: Access modifiers changed from: private */
    qp(zzcbb zzcbbVar) {
        this.a = new WeakReference<>(zzcbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        zzcbb zzcbbVar = this.a.get();
        if (zzcbbVar != null && "_ac".equals(map.get("eventName"))) {
            zzcbbVar.h.e();
        }
    }

    /* synthetic */ qp(zzcbb zzcbbVar, qq qqVar) {
        this(zzcbbVar);
    }
}
