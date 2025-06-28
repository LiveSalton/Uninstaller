package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
final class aol implements zzeap.a {
    private final /* synthetic */ zzeaq a;
    private final /* synthetic */ zzeae b;

    aol(zzeaq zzeaqVar, zzeae zzeaeVar) {
        this.a = zzeaqVar;
        this.b = zzeaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final <Q> zzdzz<Q> a(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzean(this.a, this.b, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final zzdzz<?> a() {
        return new zzean(this.a, this.b, this.a.e());
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Class<?> b() {
        return this.a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Set<Class<?>> c() {
        return this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Class<?> d() {
        return this.b.getClass();
    }
}
