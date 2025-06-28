package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzamm<I, O> implements zzamd<I, O> {
    private final zzamf<O> a;
    private final zzame<I> b;
    private final zzalb c;
    private final String d;

    zzamm(zzalb zzalbVar, String str, zzame<I> zzameVar, zzamf<O> zzamfVar) {
        this.c = zzalbVar;
        this.d = str;
        this.b = zzameVar;
        this.a = zzamfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamd
    public final zzdyz<O> b(I i) {
        zzazq zzazqVar = new zzazq();
        zzalo b = this.c.b((zzef) null);
        b.a(new cp(this, b, i, zzazqVar), new co(this, zzazqVar, b));
        return zzazqVar;
    }

    public final void a(zzalo zzaloVar, zzalz zzalzVar, I i, zzazq<O> zzazqVar) {
        try {
            zzp.c();
            String a = com.google.android.gms.ads.internal.util.zzm.a();
            zzahc.p.a(a, new cq(this, zzaloVar, zzazqVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", a);
            jSONObject.put("args", this.b.a(i));
            zzalzVar.a(this.d, jSONObject);
        } catch (Exception e) {
            try {
                zzazqVar.a(e);
                zzd.c("Unable to invokeJavascript", e);
            } finally {
                zzaloVar.a();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final zzdyz<O> a(I i) throws Exception {
        return b(i);
    }
}
