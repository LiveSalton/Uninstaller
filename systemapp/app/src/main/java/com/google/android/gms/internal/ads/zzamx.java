package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzamx<I, O> implements zzdyb<I, O> {
    private final zzamf<O> a;
    private final zzame<I> b;
    private final String c;
    private final zzdyz<zzalz> d;

    zzamx(zzdyz<zzalz> zzdyzVar, String str, zzame<I> zzameVar, zzamf<O> zzamfVar) {
        this.d = zzdyzVar;
        this.c = str;
        this.b = zzameVar;
        this.a = zzamfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final zzdyz<O> a(I i) throws Exception {
        return zzdyr.a(this.d, new zzdyb(this, i) { // from class: com.google.android.gms.internal.ads.cv
            private final zzamx a;
            private final Object b;

            {
                this.a = this;
                this.b = i;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, (zzalz) obj);
            }
        }, zzazj.f);
    }

    final /* synthetic */ zzdyz a(Object obj, zzalz zzalzVar) throws Exception {
        zzazq zzazqVar = new zzazq();
        zzp.c();
        String a = com.google.android.gms.ads.internal.util.zzm.a();
        zzahc.p.a(a, new cw(this, zzazqVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", a);
        jSONObject.put("args", this.b.a(obj));
        zzalzVar.a(this.c, jSONObject);
        return zzazqVar;
    }
}
