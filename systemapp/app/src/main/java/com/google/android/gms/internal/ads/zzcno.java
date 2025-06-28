package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcno {
    private final Context a;
    private final zzazh b;
    private final zzdnn c;
    private final Executor d;

    public zzcno(Context context, zzazh zzazhVar, zzdnn zzdnnVar, Executor executor) {
        this.a = context;
        this.b = zzazhVar;
        this.c = zzdnnVar;
        this.d = executor;
    }

    public final zzdyz<zzdnj> a() {
        zzamd a = zzp.p().b(this.a, this.b).a("google.afma.response.normalize", zzamg.a, zzamg.a);
        return zzdyr.a(zzdyr.a(zzdyr.a(zzdyr.a(""), new zzdyb(this, this.c.d.s) { // from class: com.google.android.gms.internal.ads.vt
            private final zzcno a;
            private final zzvc b;

            {
                this.a = this;
                this.b = zzvcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                zzvc zzvcVar2 = this.b;
                String str = zzvcVar2.a;
                String str2 = zzvcVar2.b;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("headers", new JSONObject());
                jSONObject3.put("body", str);
                jSONObject2.put("base_url", "");
                jSONObject2.put("signals", new JSONObject(str2));
                jSONObject.put("request", jSONObject2);
                jSONObject.put("response", jSONObject3);
                jSONObject.put("flags", new JSONObject());
                return zzdyr.a(jSONObject);
            }
        }, this.d), new zzdyb(a) { // from class: com.google.android.gms.internal.ads.vv
            private final zzamd a;

            {
                this.a = a;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.b((JSONObject) obj);
            }
        }, this.d), new zzdyb(this) { // from class: com.google.android.gms.internal.ads.vu
            private final zzcno a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a((JSONObject) obj);
            }
        }, this.d);
    }

    final /* synthetic */ zzdyz a(JSONObject jSONObject) throws Exception {
        return zzdyr.a(new zzdnj(new zzdne(this.c), zzdnh.a(new StringReader(jSONObject.toString()))));
    }
}
