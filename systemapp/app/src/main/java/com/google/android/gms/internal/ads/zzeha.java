package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeha implements zzeaa {
    private static final byte[] a = new byte[0];
    private final zzehc b;
    private final String c;
    private final byte[] d;
    private final zzehf e;
    private final zzegy f;

    public zzeha(ECPublicKey eCPublicKey, byte[] bArr, String str, zzehf zzehfVar, zzegy zzegyVar) throws GeneralSecurityException {
        zzehe.a(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.b = new zzehc(eCPublicKey);
        this.d = bArr;
        this.c = str;
        this.e = zzehfVar;
        this.f = zzegyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeaa
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzehb a2 = this.b.a(this.c, this.d, bArr2, this.f.a(), this.e);
        byte[] a3 = this.f.a(a2.b()).a(bArr, a);
        byte[] a4 = a2.a();
        return ByteBuffer.allocate(a4.length + a3.length).put(a4).put(a3).array();
    }
}
