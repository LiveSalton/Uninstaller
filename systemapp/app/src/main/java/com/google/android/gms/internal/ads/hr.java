package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class hr extends zzbm {
    static final hr a = new hr();

    hr() {
    }

    @Override // com.google.android.gms.internal.ads.zzbm
    public final zzbp a(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzbr() : "mvhd".equals(str) ? new zzbu() : new zzbt(str);
    }
}
