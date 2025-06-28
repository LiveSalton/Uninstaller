package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzegw extends asa {
    public zzegw(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.asa
    final ary a(byte[] bArr, int i) throws InvalidKeyException {
        return new arz(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.asa, com.google.android.gms.internal.ads.zzdzt
    public final /* bridge */ /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.a(bArr, bArr2);
    }
}
