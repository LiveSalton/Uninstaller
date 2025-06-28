package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehy implements zzeak {
    private final zzedb a;
    private final int b;

    public zzehy(zzedb zzedbVar, int i) throws GeneralSecurityException {
        this.a = zzedbVar;
        this.b = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzedbVar.a(new byte[0], i);
    }

    @Override // com.google.android.gms.internal.ads.zzeak
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        return this.a.a(bArr, this.b);
    }
}
