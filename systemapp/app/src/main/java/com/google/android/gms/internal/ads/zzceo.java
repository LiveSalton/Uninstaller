package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzceo {
    private final zzdzc a;
    private final zzces b;
    private final zzcfc c;

    public zzceo(zzdzc zzdzcVar, zzces zzcesVar, zzcfc zzcfcVar) {
        this.a = zzdzcVar;
        this.b = zzcesVar;
        this.c = zzcfcVar;
    }

    public final zzdyz<zzcce> a(zzdnj zzdnjVar, zzdmu zzdmuVar, JSONObject jSONObject) {
        zzdyz a;
        zzdyz submit = this.a.submit(new Callable(this, zzdnjVar, zzdmuVar, jSONObject) { // from class: com.google.android.gms.internal.ads.ru
            private final zzceo a;
            private final zzdnj b;
            private final zzdmu c;
            private final JSONObject d;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
                this.d = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdnj zzdnjVar2 = this.b;
                zzdmu zzdmuVar2 = this.c;
                JSONObject jSONObject2 = this.d;
                zzcce zzcceVar = new zzcce();
                zzcceVar.a(jSONObject2.optInt("template_id", -1));
                zzcceVar.a(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
                zzcceVar.b(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
                zzdnn zzdnnVar = zzdnjVar2.a.a;
                if (!zzdnnVar.g.contains(Integer.toString(zzcceVar.a()))) {
                    zzdok zzdokVar = zzdok.INTERNAL_ERROR;
                    int a2 = zzcceVar.a();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Invalid template ID: ");
                    sb.append(a2);
                    throw new zzcuq(zzdokVar, sb.toString());
                }
                if (zzcceVar.a() == 3) {
                    if (zzcceVar.u() == null) {
                        throw new zzcuq(zzdok.INTERNAL_ERROR, "No custom template id for custom template ad response.");
                    }
                    if (!zzdnnVar.h.contains(zzcceVar.u())) {
                        throw new zzcuq(zzdok.INTERNAL_ERROR, "Unexpected custom template id in the response.");
                    }
                }
                zzcceVar.a(jSONObject2.optDouble("rating", -1.0d));
                String optString = jSONObject2.optString("headline", null);
                if (zzdmuVar2.H) {
                    zzp.c();
                    String c = com.google.android.gms.ads.internal.util.zzm.c();
                    StringBuilder sb2 = new StringBuilder(3 + String.valueOf(c).length() + String.valueOf(optString).length());
                    sb2.append(c);
                    sb2.append(" : ");
                    sb2.append(optString);
                    optString = sb2.toString();
                }
                zzcceVar.a("headline", optString);
                zzcceVar.a("body", jSONObject2.optString("body", null));
                zzcceVar.a("call_to_action", jSONObject2.optString("call_to_action", null));
                zzcceVar.a("store", jSONObject2.optString("store", null));
                zzcceVar.a("price", jSONObject2.optString("price", null));
                zzcceVar.a("advertiser", jSONObject2.optString("advertiser", null));
                return zzcceVar;
            }
        });
        zzdyz<List<zzadv>> b = this.b.b(jSONObject, "images");
        zzdyz<zzadv> a2 = this.b.a(jSONObject, "secondary_image");
        zzdyz<zzadv> a3 = this.b.a(jSONObject, "app_icon");
        zzdyz<zzadq> c = this.b.c(jSONObject, "attribution");
        zzdyz<zzbdv> c2 = this.b.c(jSONObject);
        zzces zzcesVar = this.b;
        if (!jSONObject.optBoolean("enable_omid")) {
            a = zzdyr.a((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                a = zzdyr.a((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    a = zzdyr.a((Object) null);
                } else {
                    a = zzdyr.a(zzdyr.a((Object) null), new zzdyb(zzcesVar, optString) { // from class: com.google.android.gms.internal.ads.sa
                        private final zzces a;
                        private final String b;

                        {
                            this.a = zzcesVar;
                            this.b = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdyb
                        public final zzdyz a(Object obj) {
                            return this.a.a(this.b, obj);
                        }
                    }, zzazj.e);
                }
            }
        }
        zzdyz zzdyzVar = a;
        zzdyz<List<zzcfd>> a4 = this.c.a(jSONObject, "custom_assets");
        return zzdyr.a(submit, b, a2, a3, c, c2, zzdyzVar, a4).a(new Callable(this, submit, b, a3, a2, c, jSONObject, c2, zzdyzVar, a4) { // from class: com.google.android.gms.internal.ads.rv
            private final zzceo a;
            private final zzdyz b;
            private final zzdyz c;
            private final zzdyz d;
            private final zzdyz e;
            private final zzdyz f;
            private final JSONObject g;
            private final zzdyz h;
            private final zzdyz i;
            private final zzdyz j;

            {
                this.a = this;
                this.b = submit;
                this.c = b;
                this.d = a3;
                this.e = a2;
                this.f = c;
                this.g = jSONObject;
                this.h = c2;
                this.i = zzdyzVar;
                this.j = a4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdyz zzdyzVar2 = this.b;
                zzdyz zzdyzVar3 = this.c;
                zzdyz zzdyzVar4 = this.d;
                zzdyz zzdyzVar5 = this.e;
                zzdyz zzdyzVar6 = this.f;
                JSONObject jSONObject2 = this.g;
                zzdyz zzdyzVar7 = this.h;
                zzdyz zzdyzVar8 = this.i;
                zzdyz zzdyzVar9 = this.j;
                zzcce zzcceVar = (zzcce) zzdyzVar2.get();
                zzcceVar.a((List<zzadv>) zzdyzVar3.get());
                zzcceVar.a((zzaej) zzdyzVar4.get());
                zzcceVar.b((zzaej) zzdyzVar5.get());
                zzcceVar.a((zzaeb) zzdyzVar6.get());
                zzcceVar.b(zzces.a(jSONObject2));
                zzcceVar.a(zzces.b(jSONObject2));
                zzbdv zzbdvVar = (zzbdv) zzdyzVar7.get();
                if (zzbdvVar != null) {
                    zzcceVar.a(zzbdvVar);
                    zzcceVar.a(zzbdvVar.getView());
                    zzcceVar.a(zzbdvVar.d());
                }
                zzbdv zzbdvVar2 = (zzbdv) zzdyzVar8.get();
                if (zzbdvVar2 != null) {
                    zzcceVar.b(zzbdvVar2);
                }
                for (zzcfd zzcfdVar : (List) zzdyzVar9.get()) {
                    switch (zzcfdVar.a) {
                        case 1:
                            zzcceVar.a(zzcfdVar.b, zzcfdVar.c);
                            break;
                        case 2:
                            zzcceVar.a(zzcfdVar.b, zzcfdVar.d);
                            break;
                    }
                }
                return zzcceVar;
            }
        }, this.a);
    }
}
