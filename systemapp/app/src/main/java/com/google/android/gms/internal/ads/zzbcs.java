package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbcs extends zza {
    final zzbbe a;
    final zzbcx b;
    private final String c;
    private final String[] d;

    zzbcs(zzbbe zzbbeVar, zzbcx zzbcxVar, String str, String[] strArr) {
        this.a = zzbbeVar;
        this.b = zzbcxVar;
        this.c = str;
        this.d = strArr;
        zzp.y().a(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void a() {
        try {
            this.b.a(this.c, this.d);
        } finally {
            com.google.android.gms.ads.internal.util.zzm.a.post(new hs(this));
        }
    }
}
