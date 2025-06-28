package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
final class apn implements zzeaa {
    private final zzeam<zzeaa> a;

    public apn(zzeam<zzeaa> zzeamVar) {
        this.a = zzeamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaa
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzegr.a(this.a.a().d(), this.a.a().a().a(bArr, bArr2));
    }
}
