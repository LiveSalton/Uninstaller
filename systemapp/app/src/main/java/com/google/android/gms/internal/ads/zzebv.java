package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzebv implements zzdzt {
    private static final byte[] a = new byte[0];
    private final zzefn b;
    private final zzdzt c;

    public zzebv(zzefn zzefnVar, zzdzt zzdztVar) {
        this.b = zzefnVar;
        this.c = zzdztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzt
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] l = zzeap.b(this.b).l();
        byte[] a2 = this.c.a(l, a);
        byte[] a3 = ((zzdzt) zzeap.a(this.b.a(), l, zzdzt.class)).a(bArr, bArr2);
        return ByteBuffer.allocate(4 + a2.length + a3.length).putInt(a2.length).put(a2).put(a3).array();
    }
}
