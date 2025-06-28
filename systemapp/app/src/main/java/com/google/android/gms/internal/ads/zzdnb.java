package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.android.gms.ads.internal.util.zzbl;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdnb implements zzbl {
    public final String a;
    public final String b;
    public final JSONObject c;
    private final JSONObject d;

    zzdnb(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        this.d = com.google.android.gms.ads.internal.util.zzbk.c(jsonReader);
        this.a = this.d.optString("ad_html", null);
        this.b = this.d.optString("ad_base_url", null);
        this.c = this.d.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.ads.internal.util.zzbl
    public final void a(JsonWriter jsonWriter) throws IOException {
        com.google.android.gms.ads.internal.util.zzbk.a(jsonWriter, this.d);
    }
}
