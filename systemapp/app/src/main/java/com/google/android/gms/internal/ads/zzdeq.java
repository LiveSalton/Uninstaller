package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdeq implements zzdfj<Bundle> {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final Long e;

    public zzdeq(String str, String str2, String str3, String str4, Long l) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = l;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdnx.a(bundle2, "gmp_app_id", this.a);
        zzdnx.a(bundle2, "fbs_aiid", this.b);
        zzdnx.a(bundle2, "fbs_aeid", this.c);
        zzdnx.a(bundle2, "apm_id_origin", this.d);
        Long l = this.e;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}
