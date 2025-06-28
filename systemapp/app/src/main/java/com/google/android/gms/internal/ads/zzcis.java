package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcis {
    private final Map<String, Map<String, JSONObject>> a = new ConcurrentHashMap();
    private final Executor b;
    private boolean c;
    private JSONObject d;

    public zzcis(Executor executor) {
        this.b = executor;
    }

    public final void a() {
        zzp.g().h().a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.tw
            private final zzcis a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
        this.b.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ty
            private final zzcis a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    @CheckForNull
    public final JSONObject a(String str, String str2) {
        if (!((Boolean) zzwq.e().a(zzabf.bN)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.c) {
            d();
        }
        Map<String, JSONObject> map = this.a.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String a = zzciv.a(this.d, str, str2);
        if (a == null) {
            return null;
        }
        return map.get(a);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void d() {
        Map<String, JSONObject> map;
        this.c = true;
        zzayh h = zzp.g().h().h();
        if (h == null) {
            return;
        }
        JSONObject f = h.f();
        if (f == null) {
            return;
        }
        this.d = f.optJSONObject("ad_unit_patterns");
        JSONArray optJSONArray = f.optJSONArray("ad_unit_id_settings");
        if (optJSONArray == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("ad_unit_id");
                String optString2 = optJSONObject.optString("format");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                if (optString != null && optJSONObject2 != null && optString2 != null) {
                    if (this.a.containsKey(optString2)) {
                        map = this.a.get(optString2);
                    } else {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        this.a.put(optString2, concurrentHashMap);
                        map = concurrentHashMap;
                    }
                    map.put(optString, optJSONObject2);
                }
            }
        }
    }

    final /* synthetic */ void c() {
        this.b.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.tx
            private final zzcis a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        });
    }
}
