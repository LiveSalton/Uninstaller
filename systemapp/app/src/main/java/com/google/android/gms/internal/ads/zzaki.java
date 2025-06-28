package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final /* synthetic */ class zzaki {
    public static void a(zzakj zzakjVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzakjVar.a(str, jSONObject.toString());
    }

    public static void a(zzakj zzakjVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(3 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzakjVar.d(sb.toString());
    }

    public static void b(zzakj zzakjVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzd.b(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzakjVar.d(sb.toString());
    }

    public static void a(zzakj zzakjVar, String str, Map map) {
        try {
            zzakjVar.b(str, zzp.c().a((Map<String, ?>) map));
        } catch (JSONException unused) {
            zzd.e("Could not convert parameters to JSON.");
        }
    }
}
