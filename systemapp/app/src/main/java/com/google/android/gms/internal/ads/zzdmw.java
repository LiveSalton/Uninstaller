package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmw {
    private int a;
    private String b;

    public final String a() {
        return this.b;
    }

    zzdmw(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str = "";
        jsonReader.beginObject();
        int i = 3;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1724546052) {
                if (hashCode == 3059181 && nextName.equals("code")) {
                    c = 0;
                }
            } else if (nextName.equals("description")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    i = jsonReader.nextInt();
                    break;
                case 1:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        this.a = i;
        this.b = str;
    }
}
