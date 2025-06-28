package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbbf {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final int j;
    private final String k;

    public zzbbf(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.a = a(jSONObject, "aggressive_media_codec_release", zzabf.y);
        this.b = b(jSONObject, "byte_buffer_precache_limit", zzabf.g);
        this.c = b(jSONObject, "exo_cache_buffer_size", zzabf.n);
        this.d = b(jSONObject, "exo_connect_timeout_millis", zzabf.c);
        this.k = c(jSONObject, "exo_player_version", zzabf.b);
        this.e = b(jSONObject, "exo_read_timeout_millis", zzabf.d);
        this.f = b(jSONObject, "load_check_interval_bytes", zzabf.e);
        this.g = b(jSONObject, "player_precache_limit", zzabf.f);
        this.h = b(jSONObject, "socket_receive_buffer_size", zzabf.h);
        this.i = a(jSONObject, "use_cache_data_source", zzabf.bV);
        this.j = b(jSONObject, "min_retry_count", zzabf.j);
    }

    private static boolean a(JSONObject jSONObject, String str, zzaaq<Boolean> zzaaqVar) {
        return a(jSONObject, str, ((Boolean) zzwq.e().a(zzaaqVar)).booleanValue());
    }

    private static boolean a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int b(JSONObject jSONObject, String str, zzaaq<Integer> zzaaqVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzwq.e().a(zzaaqVar)).intValue();
    }

    private static String c(JSONObject jSONObject, String str, zzaaq<String> zzaaqVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzwq.e().a(zzaaqVar);
    }
}
