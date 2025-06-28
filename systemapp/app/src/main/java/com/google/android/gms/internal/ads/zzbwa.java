package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwa implements zzepf<zzbvy> {
    private final zzeps<Set<zzbxy<AppEventListener>>> a;

    private zzbwa(zzeps<Set<zzbxy<AppEventListener>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbwa a(zzeps<Set<zzbxy<AppEventListener>>> zzepsVar) {
        return new zzbwa(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbvy(this.a.b());
    }
}
