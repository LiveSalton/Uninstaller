package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbko implements zzepf<zzqr> {
    private final zzeps<zzdmu> a;
    private final zzeps<zzazh> b;
    private final zzeps<JSONObject> c;
    private final zzeps<String> d;

    private zzbko(zzeps<zzdmu> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<JSONObject> zzepsVar3, zzeps<String> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzbko a(zzeps<zzdmu> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<JSONObject> zzepsVar3, zzeps<String> zzepsVar4) {
        return new zzbko(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        this.a.b();
        zzazh b = this.b.b();
        JSONObject b2 = this.c.b();
        String b3 = this.d.b();
        boolean equals = "native".equals(b3);
        zzp.c();
        return (zzqr) zzepl.a(new zzqr(com.google.android.gms.ads.internal.util.zzm.a(), b, b3, b2, false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
