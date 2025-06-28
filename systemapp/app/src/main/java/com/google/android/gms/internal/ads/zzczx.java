package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczx {
    public final String a;
    public String b;
    public Bundle c = new Bundle();

    public zzczx(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str = "";
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -995427962) {
                if (hashCode == -271442291 && nextName.equals("signal_dictionary")) {
                    c = 1;
                }
            } else if (nextName.equals("params")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    hashMap = com.google.android.gms.ads.internal.util.zzbk.b(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        this.a = str;
        jsonReader.endObject();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.c.putString(entry.getKey(), entry.getValue());
            }
        }
    }

    final zzczx a(Bundle bundle) {
        try {
            this.b = zzp.c().a(bundle).toString();
        } catch (JSONException unused) {
            this.b = "{}";
        }
        return this;
    }
}
