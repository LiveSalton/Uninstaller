package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfc {
    private final Executor a;
    private final zzces b;

    public zzcfc(Executor executor, zzces zzcesVar) {
        this.a = executor;
        this.b = zzcesVar;
    }

    public final zzdyz<List<zzcfd>> a(JSONObject jSONObject, String str) {
        zzdyz a;
        String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdyr.a(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                String optString2 = optJSONObject.optString("type");
                if ("string".equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : (char) 0;
                }
                switch (c) {
                    case 1:
                        a = zzdyr.a(new zzcfd(optString, optJSONObject.optString("string_value")));
                        break;
                    case 2:
                        a = zzdyr.a(this.b.a(optJSONObject, "image_value"), new zzdvm(optString) { // from class: com.google.android.gms.internal.ads.sf
                            private final String a;

                            {
                                this.a = optString;
                            }

                            @Override // com.google.android.gms.internal.ads.zzdvm
                            public final Object a(Object obj) {
                                return new zzcfd(this.a, (zzadv) obj);
                            }
                        }, this.a);
                        break;
                }
                arrayList.add(a);
            }
            a = zzdyr.a((Object) null);
            arrayList.add(a);
        }
        return zzdyr.a(zzdyr.a((Iterable) arrayList), se.a, this.a);
    }
}
