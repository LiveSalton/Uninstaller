package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdnh {
    public final List<zzdmu> a;
    public final zzdmz b;
    public final List<zzdng> c;

    public static zzdnh a(Reader reader) throws zzdmy {
        try {
            try {
                return new zzdnh(new JsonReader(reader));
            } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
                throw new zzdmy("unable to parse ServerResponse", e);
            }
        } finally {
            IOUtils.a(reader);
        }
    }

    private zzdnh(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzdmu> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzdmz zzdmzVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzdmu(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzdmzVar = new zzdmz(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    Map<String, String> map = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            map = com.google.android.gms.ads.internal.util.zzbk.b(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzdng(str, map));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.c = arrayList;
        this.a = emptyList;
        this.b = zzdmzVar == null ? new zzdmz(new JsonReader(new StringReader("{}"))) : zzdmzVar;
    }
}
