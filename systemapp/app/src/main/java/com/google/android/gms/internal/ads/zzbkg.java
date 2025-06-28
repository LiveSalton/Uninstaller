package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkg implements zzame<zzbkk> {
    private final Context a;
    private final zzqr b;
    private final PowerManager c;

    public zzbkg(Context context, zzqr zzqrVar) {
        this.a = context;
        this.b = zzqrVar;
        this.c = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzame
    public final JSONObject a(zzbkk zzbkkVar) throws JSONException {
        boolean isScreenOn;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzbkkVar.e == null) {
            jSONObject = new JSONObject();
        } else {
            zzqv zzqvVar = zzbkkVar.e;
            if (this.b.c() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzqvVar.a;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.b.b()).put("activeViewJSON", this.b.c()).put("timestamp", zzbkkVar.c).put("adFormat", this.b.a()).put("hashCode", this.b.d()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbkkVar.b).put("isNative", this.b.e());
            if (Build.VERSION.SDK_INT >= 20) {
                isScreenOn = this.c.isInteractive();
            } else {
                isScreenOn = this.c.isScreenOn();
            }
            put.put("isScreenOn", isScreenOn).put("appMuted", zzp.h().b()).put("appVolume", zzp.h().a()).put("deviceVolume", zzad.a(this.a.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqvVar.b).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzqvVar.c.top).put("bottom", zzqvVar.c.bottom).put("left", zzqvVar.c.left).put("right", zzqvVar.c.right)).put("adBox", new JSONObject().put("top", zzqvVar.d.top).put("bottom", zzqvVar.d.bottom).put("left", zzqvVar.d.left).put("right", zzqvVar.d.right)).put("globalVisibleBox", new JSONObject().put("top", zzqvVar.e.top).put("bottom", zzqvVar.e.bottom).put("left", zzqvVar.e.left).put("right", zzqvVar.e.right)).put("globalVisibleBoxVisible", zzqvVar.f).put("localVisibleBox", new JSONObject().put("top", zzqvVar.g.top).put("bottom", zzqvVar.g.bottom).put("left", zzqvVar.g.left).put("right", zzqvVar.g.right)).put("localVisibleBoxVisible", zzqvVar.h).put("hitBox", new JSONObject().put("top", zzqvVar.i.top).put("bottom", zzqvVar.i.bottom).put("left", zzqvVar.i.left).put("right", zzqvVar.i.right)).put("screenDensity", this.a.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbkkVar.a);
            if (((Boolean) zzwq.e().a(zzabf.aH)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                if (zzqvVar.k != null) {
                    for (Rect rect2 : zzqvVar.k) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbkkVar.d)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
