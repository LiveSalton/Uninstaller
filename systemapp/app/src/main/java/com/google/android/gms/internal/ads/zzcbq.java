package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbq implements zzepf<zzqr> {
    private final zzeps<zzazh> a;
    private final zzeps<String> b;

    public zzcbq(zzeps<zzazh> zzepsVar, zzeps<String> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzazh b = this.a.b();
        String b2 = this.b.b();
        zzp.c();
        return (zzqr) zzepl.a(new zzqr(com.google.android.gms.ads.internal.util.zzm.a(), b, b2, new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
