package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehi implements zzdzt {
    private final zzehr a;
    private final zzeak b;
    private final int c;

    public zzehi(zzehr zzehrVar, zzeak zzeakVar, int i) {
        this.a = zzehrVar;
        this.b = zzeakVar;
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdzt
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] a = this.a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzegr.a(a, this.b.a(zzegr.a(bArr2, a, Arrays.copyOf(ByteBuffer.allocate(8).putLong(8 * bArr2.length).array(), 8))));
    }
}
