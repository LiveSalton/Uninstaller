package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzctn implements zzcto<zzcbt> {
    private final zzcat a;
    private final zzdzc b;
    private final zzceo c;
    private final zzdod<zzcgh> d;

    public zzctn(zzcat zzcatVar, zzdzc zzdzcVar, zzceo zzceoVar, zzdod<zzcgh> zzdodVar) {
        this.a = zzcatVar;
        this.b = zzdzcVar;
        this.c = zzceoVar;
        this.d = zzdodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (zzdmuVar.r == null || zzdmuVar.r.c == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<List<zzdyz<zzcbt>>> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return zzdyr.a(zzdyr.a(this.d.a(), new zzdyb(this, zzdmuVar) { // from class: com.google.android.gms.internal.ads.ze
            private final zzctn a;
            private final zzdmu b;

            {
                this.a = this;
                this.b = zzdmuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, (zzcgh) obj);
            }
        }, this.b), new zzdyb(this, zzdnjVar, zzdmuVar) { // from class: com.google.android.gms.internal.ads.zd
            private final zzctn a;
            private final zzdnj b;
            private final zzdmu c;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, (JSONArray) obj);
            }
        }, this.b);
    }

    private final zzdyz<zzcbt> a(zzdnj zzdnjVar, zzdmu zzdmuVar, JSONObject jSONObject) {
        zzdyz<zzcgh> a = this.d.a();
        zzdyz<zzcce> a2 = this.c.a(zzdnjVar, zzdmuVar, jSONObject);
        return zzdyr.b(a, a2).a(new Callable(this, a2, a, zzdnjVar, zzdmuVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zh
            private final zzctn a;
            private final zzdyz b;
            private final zzdyz c;
            private final zzdnj d;
            private final zzdmu e;
            private final JSONObject f;

            {
                this.a = this;
                this.b = a2;
                this.c = a;
                this.d = zzdnjVar;
                this.e = zzdmuVar;
                this.f = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.a(this.b, this.c, this.d, this.e, this.f);
            }
        }, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzcbt a(zzdyz zzdyzVar, zzdyz zzdyzVar2, zzdnj zzdnjVar, zzdmu zzdmuVar, JSONObject jSONObject) throws Exception {
        zzcce zzcceVar = (zzcce) zzdyzVar.get();
        zzcgh zzcghVar = (zzcgh) zzdyzVar2.get();
        zzccg a = this.a.a(new zzbos(zzdnjVar, zzdmuVar, null), new zzccq(zzcceVar), new zzcbh(jSONObject, zzcghVar));
        a.i().a();
        a.j().a(zzcghVar);
        a.k().a(zzcceVar.v());
        return a.h();
    }

    final /* synthetic */ zzdyz a(zzcgh zzcghVar, JSONObject jSONObject) throws Exception {
        this.d.a(zzdyr.a(zzcghVar));
        if (!jSONObject.optBoolean("success")) {
            throw new zzama("process json failed");
        }
        return zzdyr.a(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    final /* synthetic */ zzdyz a(zzdnj zzdnjVar, zzdmu zzdmuVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdyr.a((Throwable) new zzcme(zzdok.NO_FILL));
        }
        if (zzdnjVar.a.a.k > 1) {
            int length = jSONArray.length();
            this.d.a(Math.min(length, zzdnjVar.a.a.k));
            ArrayList arrayList = new ArrayList(zzdnjVar.a.a.k);
            for (int i = 0; i < zzdnjVar.a.a.k; i++) {
                if (i < length) {
                    arrayList.add(a(zzdnjVar, zzdmuVar, jSONArray.getJSONObject(i)));
                } else {
                    arrayList.add(zzdyr.a((Throwable) new zzcme(zzdok.NO_FILL)));
                }
            }
            return zzdyr.a(arrayList);
        }
        return zzdyr.a(a(zzdnjVar, zzdmuVar, jSONArray.getJSONObject(0)), zf.a, this.b);
    }

    final /* synthetic */ zzdyz a(zzdmu zzdmuVar, zzcgh zzcghVar) throws Exception {
        JSONObject a = com.google.android.gms.ads.internal.util.zzbk.a("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzdmuVar.r.c);
        jSONObject.put("sdk_params", a);
        return zzdyr.a(zzcghVar.a("google.afma.nativeAds.preProcessJson", jSONObject), new zzdyb(this, zzcghVar) { // from class: com.google.android.gms.internal.ads.zg
            private final zzctn a;
            private final zzcgh b;

            {
                this.a = this;
                this.b = zzcghVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, (JSONObject) obj);
            }
        }, this.b);
    }
}
