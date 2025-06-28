package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwz {
    private final Map<String, zzcxg> a = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzcxg>>> b = new ConcurrentHashMap();
    private final Executor c;
    private JSONObject d;

    public zzcwz(Executor executor) {
        this.c = executor;
    }

    public final void a() {
        zzp.g().h().a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.aao
            private final zzcwz a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
        this.c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.aan
            private final zzcwz a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    public final Map<String, List<Bundle>> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map<String, List<zzcxg>> map = this.b.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzcxg> list = map.get(str2);
        if (list == null) {
            list = map.get(zzciv.a(this.d, str2, str));
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (zzcxg zzcxgVar : list) {
            String str3 = zzcxgVar.a;
            if (!hashMap.containsKey(str3)) {
                hashMap.put(str3, new ArrayList());
            }
            ((List) hashMap.get(str3)).add(zzcxgVar.b);
        }
        return hashMap;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str) || this.a.containsKey(str)) {
            return;
        }
        this.a.put(str, new zzcxg(str, "", new Bundle()));
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void d() {
        JSONArray optJSONArray;
        JSONObject f = zzp.g().h().h().f();
        if (f != null) {
            try {
                JSONArray optJSONArray2 = f.optJSONArray("ad_unit_id_settings");
                this.d = f.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            String optString3 = optJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        ArrayList arrayList4 = arrayList3;
                                        int size = arrayList4.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList4.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            a(str);
                                            if (this.a.get(str) != null) {
                                                arrayList2.add(new zzcxg(str, optString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map<String, List<zzcxg>> map = this.b.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap<>();
                            }
                            this.b.put(optString2, map);
                            List<zzcxg> list = map.get(optString);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e) {
                zzd.a("Malformed config loading JSON.", e);
            }
        }
    }

    final /* synthetic */ void c() {
        this.c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.aap
            private final zzcwz a;

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
