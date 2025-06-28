package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmz {
    public final List<String> a;
    public final String b;
    public final int c;
    public final String d;
    public final int e;
    public final long f;
    public final boolean g;
    public final zzdmw h;

    zzdmz(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> emptyList = Collections.emptyList();
        String str = "";
        String str2 = "";
        jsonReader.beginObject();
        int i = 0;
        boolean z = false;
        zzdmw zzdmwVar = null;
        long j = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = com.google.android.gms.ads.internal.util.zzbk.a(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                if (((Boolean) zzwq.e().a(zzabf.ex)).booleanValue() && "public_error".equals(nextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzdmwVar = new zzdmw(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        this.a = emptyList;
        this.c = i;
        this.b = str;
        this.d = str2;
        this.e = i2;
        this.f = j;
        this.h = zzdmwVar;
        this.g = z;
    }
}
