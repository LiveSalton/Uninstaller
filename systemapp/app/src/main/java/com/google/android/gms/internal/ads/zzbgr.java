package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbgr implements zzepf<WeakReference<Context>> {
    private final zzbgl a;

    public zzbgr(zzbgl zzbglVar) {
        this.a = zzbglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (WeakReference) zzepl.a(this.a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
