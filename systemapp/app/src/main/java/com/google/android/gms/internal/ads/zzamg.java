package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzamg {
    private static final Charset c = Charset.forName("UTF-8");
    public static final zzamh<JSONObject> a = new ck();
    public static final zzamf<InputStream> b = cl.a;

    static final /* synthetic */ InputStream a(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(c));
    }
}
