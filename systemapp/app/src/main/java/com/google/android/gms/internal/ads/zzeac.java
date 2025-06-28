package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeac<PrimitiveT, KeyProtoT extends zzels> implements zzdzz<PrimitiveT> {
    private final zzeae<KeyProtoT> a;
    private final Class<PrimitiveT> b;

    public zzeac(zzeae<KeyProtoT> zzeaeVar, Class<PrimitiveT> cls) {
        if (!zzeaeVar.d().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzeaeVar.toString(), cls.getName()));
        }
        this.a = zzeaeVar;
        this.b = cls;
    }

    @Override // com.google.android.gms.internal.ads.zzdzz
    public final PrimitiveT a(zzeiu zzeiuVar) throws GeneralSecurityException {
        try {
            return b((zzeac<PrimitiveT, KeyProtoT>) this.a.a(zzeiuVar));
        } catch (zzeks e) {
            String valueOf = String.valueOf(this.a.a().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdzz
    public final PrimitiveT a(zzels zzelsVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.a.a().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (!this.a.a().isInstance(zzelsVar)) {
            throw new GeneralSecurityException(concat);
        }
        return (PrimitiveT) b((zzeac<PrimitiveT, KeyProtoT>) zzelsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdzz
    public final zzels b(zzeiu zzeiuVar) throws GeneralSecurityException {
        try {
            return c().a(zzeiuVar);
        } catch (zzeks e) {
            String valueOf = String.valueOf(this.a.f().a().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzz
    public final String a() {
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzdzz
    public final zzefh c(zzeiu zzeiuVar) throws GeneralSecurityException {
        try {
            return (zzefh) ((zzekh) zzefh.d().a(this.a.b()).a(c().a(zzeiuVar).k()).a(this.a.c()).g());
        } catch (zzeks e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzz
    public final Class<PrimitiveT> b() {
        return this.b;
    }

    private final PrimitiveT b(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.b)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.a.a((zzeae<KeyProtoT>) keyprotot);
        return (PrimitiveT) this.a.a(keyprotot, this.b);
    }

    private final aoh<?, KeyProtoT> c() {
        return new aoh<>(this.a.f());
    }
}
