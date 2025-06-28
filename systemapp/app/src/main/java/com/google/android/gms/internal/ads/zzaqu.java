package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzaqu {
    private final zzbdv a;
    private final String b;

    public zzaqu(zzbdv zzbdvVar) {
        this(zzbdvVar, "");
    }

    public zzaqu(zzbdv zzbdvVar, String str) {
        this.a = zzbdvVar;
        this.b = str;
    }

    public final void a(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.b);
            if (this.a != null) {
                this.a.b("onError", put);
            }
        } catch (JSONException e) {
            zzd.c("Error occurred while dispatching error event.", e);
        }
    }

    public final void b(String str) {
        try {
            this.a.b("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzd.c("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        try {
            this.a.b("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzd.c("Error occurred while dispatching size change.", e);
        }
    }

    public final void b(int i, int i2, int i3, int i4) {
        try {
            this.a.b("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzd.c("Error occurred while dispatching default position.", e);
        }
    }

    public final void c(String str) {
        try {
            this.a.b("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzd.c("Error occurred while dispatching state change.", e);
        }
    }

    public final void a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.a.b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzd.c("Error occurred while obtaining screen information.", e);
        }
    }
}
