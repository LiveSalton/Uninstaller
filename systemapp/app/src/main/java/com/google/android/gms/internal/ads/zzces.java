package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzces {
    private final Context a;
    private final zzcej b;
    private final zzef c;
    private final zzazh d;
    private final com.google.android.gms.ads.internal.zzb e;
    private final zzts f;
    private final Executor g;
    private final zzadz h;
    private final zzcff i;
    private final ScheduledExecutorService j;

    public zzces(Context context, zzcej zzcejVar, zzef zzefVar, zzazh zzazhVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, Executor executor, zzdnn zzdnnVar, zzcff zzcffVar, ScheduledExecutorService scheduledExecutorService) {
        this.a = context;
        this.b = zzcejVar;
        this.c = zzefVar;
        this.d = zzazhVar;
        this.e = zzbVar;
        this.f = zztsVar;
        this.g = executor;
        this.h = zzdnnVar.i;
        this.i = zzcffVar;
        this.j = scheduledExecutorService;
    }

    public static List<zzzk> a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzdwm.g();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzdwm.g();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzzk d = d(optJSONArray.optJSONObject(i));
            if (d != null) {
                arrayList.add(d);
            }
        }
        return zzdwm.a((Collection) arrayList);
    }

    public static zzzk b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return d(optJSONObject);
    }

    private static zzzk d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzk(optString, optString2);
    }

    public final zzdyz<zzadv> a(JSONObject jSONObject, String str) {
        return a(jSONObject.optJSONObject(str), this.h.b);
    }

    public final zzdyz<List<zzadv>> b(JSONObject jSONObject, String str) {
        return a(jSONObject.optJSONArray(str), this.h.b, this.h.d);
    }

    private final zzdyz<List<zzadv>> a(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdyr.a(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(a(jSONArray.optJSONObject(i), z));
        }
        return zzdyr.a(zzdyr.a((Iterable) arrayList), rw.a, this.g);
    }

    private final zzdyz<zzadv> a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdyr.a((Object) null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzdyr.a((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzdyr.a(new zzadv(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return a(jSONObject.optBoolean("require"), (zzdyz<Object>) zzdyr.a(this.b.a(optString, optDouble, optBoolean), new zzdvm(optString, optDouble, optInt, optInt2) { // from class: com.google.android.gms.internal.ads.ry
            private final String a;
            private final double b;
            private final int c;
            private final int d;

            {
                this.a = optString;
                this.b = optDouble;
                this.c = optInt;
                this.d = optInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                String str = this.a;
                return new zzadv(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.b, this.c, this.d);
            }
        }, this.g), (Object) null);
    }

    public final zzdyz<zzadq> c(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdyr.a((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return a(optJSONObject.optBoolean("require"), (zzdyz<Object>) zzdyr.a(a(optJSONArray, false, true), new zzdvm(this, optJSONObject) { // from class: com.google.android.gms.internal.ads.rx
            private final zzces a;
            private final JSONObject b;

            {
                this.a = this;
                this.b = optJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return this.a.a(this.b, (List) obj);
            }
        }, this.g), (Object) null);
    }

    private static Integer d(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzdyz<zzbdv> c(JSONObject jSONObject) {
        JSONObject a = com.google.android.gms.ads.internal.util.zzbk.a(jSONObject, "html_containers", "instream");
        if (a == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdyr.a((Object) null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzd.e("Required field 'vast_xml' is missing");
                return zzdyr.a((Object) null);
            }
            return a((zzdyz<Object>) zzdyr.a(this.i.a(optJSONObject), ((Integer) zzwq.e().a(zzabf.bC)).intValue(), TimeUnit.SECONDS, this.j), (Object) null);
        }
        zzdyz<zzbdv> a2 = this.i.a(a.optString("base_url"), a.optString("html"));
        return zzdyr.a(a2, new zzdyb(a2) { // from class: com.google.android.gms.internal.ads.rz
            private final zzdyz a;

            {
                this.a = a2;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                zzdyz zzdyzVar = this.a;
                zzbdv zzbdvVar = (zzbdv) obj;
                if (zzbdvVar == null || zzbdvVar.d() == null) {
                    throw new zzcuq(zzdok.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
                }
                return zzdyzVar;
            }
        }, zzazj.f);
    }

    private static <T> zzdyz<T> a(zzdyz<T> zzdyzVar, T t) {
        return zzdyr.a(zzdyzVar, Exception.class, new zzdyb(null) { // from class: com.google.android.gms.internal.ads.sc
            private final Object a = null;

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj2) {
                Object obj3 = this.a;
                zzd.a("Error during loading assets.", (Exception) obj2);
                return zzdyr.a(obj3);
            }
        }, zzazj.f);
    }

    private static <T> zzdyz<T> a(boolean z, zzdyz<T> zzdyzVar, T t) {
        if (z) {
            return zzdyr.a(zzdyzVar, new zzdyb(zzdyzVar) { // from class: com.google.android.gms.internal.ads.sb
                private final zzdyz a;

                {
                    this.a = zzdyzVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdyz a(Object obj) {
                    return obj != null ? this.a : zzdyr.a((Throwable) new zzcuq(zzdok.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
                }
            }, zzazj.f);
        }
        return a(zzdyzVar, (Object) null);
    }

    final /* synthetic */ zzdyz a(String str, Object obj) throws Exception {
        zzp.d();
        zzbdv a = zzbed.a(this.a, zzbfn.a(), "native-omid", false, false, this.c, null, this.d, null, null, this.e, this.f, null, false, null, null);
        zzazr a2 = zzazr.a(a);
        a.z().a(new zzbfj(a2) { // from class: com.google.android.gms.internal.ads.sd
            private final zzazr a;

            {
                this.a = a2;
            }

            @Override // com.google.android.gms.internal.ads.zzbfj
            public final void a(boolean z) {
                this.a.a();
            }
        });
        a.loadData(str, "text/html", "UTF-8");
        return a2;
    }

    final /* synthetic */ zzadq a(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer d = d(jSONObject, "bg_color");
        Integer d2 = d(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzadq(optString, list, d, d2, optInt > 0 ? Integer.valueOf(optInt) : null, jSONObject.optInt("presentation_ms", 4000) + optInt2, this.h.e, optBoolean);
    }
}
