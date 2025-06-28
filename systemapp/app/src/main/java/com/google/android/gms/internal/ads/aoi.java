package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
final class aoi implements zzeap.a {
    private final /* synthetic */ zzeae a;

    aoi(zzeae zzeaeVar) {
        this.a = zzeaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Class<?> d() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final <Q> zzdzz<Q> a(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzeac(this.a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final zzdzz<?> a() {
        return new zzeac(this.a, this.a.e());
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Class<?> b() {
        return this.a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Set<Class<?>> c() {
        return this.a.d();
    }
}
