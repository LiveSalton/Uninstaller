package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzbc;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbd extends com.google.android.gms.internal.ads.zzaa<com.google.android.gms.internal.ads.zzy> {
    private final zzazq<com.google.android.gms.internal.ads.zzy> a;
    private final Map<String, String> b;
    private final zzayu c;

    public zzbd(String str, zzazq<com.google.android.gms.internal.ads.zzy> zzazqVar) {
        this(str, null, zzazqVar);
    }

    private zzbd(String str, Map<String, String> map, zzazq<com.google.android.gms.internal.ads.zzy> zzazqVar) {
        super(0, str, new o(zzazqVar));
        this.b = null;
        this.a = zzazqVar;
        this.c = new zzayu();
        this.c.a(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    protected final zzaj<com.google.android.gms.internal.ads.zzy> a(com.google.android.gms.internal.ads.zzy zzyVar) {
        return zzaj.a(zzyVar, zzbc.a(zzyVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    protected final /* synthetic */ void a(com.google.android.gms.internal.ads.zzy zzyVar) {
        com.google.android.gms.internal.ads.zzy zzyVar2 = zzyVar;
        this.c.a(zzyVar2.c, zzyVar2.a);
        zzayu zzayuVar = this.c;
        byte[] bArr = zzyVar2.b;
        if (zzayu.c() && bArr != null) {
            zzayuVar.a(bArr);
        }
        this.a.b(zzyVar2);
    }
}
