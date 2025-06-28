package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzegx implements zzdzx {
    private static final byte[] a = new byte[0];
    private final ECPrivateKey b;
    private final zzegz c;
    private final String d;
    private final byte[] e;
    private final zzehf f;
    private final zzegy g;

    public zzegx(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzehf zzehfVar, zzegy zzegyVar) throws GeneralSecurityException {
        this.b = eCPrivateKey;
        this.c = new zzegz(eCPrivateKey);
        this.e = bArr;
        this.d = str;
        this.f = zzehfVar;
        this.g = zzegyVar;
    }
}
