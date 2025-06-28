package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
final class aoj implements zzeap.a {
    private final /* synthetic */ zzdzz a;

    aoj(zzdzz zzdzzVar) {
        this.a = zzdzzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Class<?> d() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final <Q> zzdzz<Q> a(Class<Q> cls) throws GeneralSecurityException {
        if (this.a.b().equals(cls)) {
            return this.a;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final zzdzz<?> a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Class<?> b() {
        return this.a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzeap.a
    public final Set<Class<?>> c() {
        return Collections.singleton(this.a.b());
    }
}
