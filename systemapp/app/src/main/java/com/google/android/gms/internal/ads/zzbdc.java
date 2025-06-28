package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbdc implements zzahv<zzbbe> {
    private static Integer a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(39 + String.valueOf(str).length() + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzd.e(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbbe zzbbeVar, Map map) {
        zzbcx zzbcxVar;
        zzbbe zzbbeVar2 = zzbbeVar;
        if (zzd.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(15 + String.valueOf(valueOf).length());
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzd.b(sb.toString());
        }
        zzp.y();
        if (map.containsKey("abort")) {
            if (zzbcu.a(zzbbeVar2)) {
                return;
            }
            zzd.e("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer a = a((Map<String, String>) map, "periodicReportIntervalMs");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    String valueOf2 = String.valueOf(str2);
                    zzd.e(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbcu.b(zzbbeVar2) != null) {
                zzd.e("Precache task is already running.");
                return;
            }
            if (zzbbeVar2.h() == null) {
                zzd.e("Precache requires a dependency provider.");
                return;
            }
            zzbbf zzbbfVar = new zzbbf((String) map.get("flags"));
            Integer a2 = a((Map<String, String>) map, "player");
            if (a2 == null) {
                a2 = 0;
            }
            if (a != null) {
                zzbbeVar2.a(a.intValue());
            }
            zzbcxVar = zzbbeVar2.h().a.a(zzbbeVar2, a2.intValue(), null, zzbbfVar);
            new zzbcs(zzbbeVar2, zzbcxVar, str, strArr).b();
        } else {
            zzbcs b = zzbcu.b(zzbbeVar2);
            if (b != null) {
                zzbcxVar = b.b;
            } else {
                zzd.e("Precache must specify a source.");
                return;
            }
        }
        Integer a3 = a((Map<String, String>) map, "minBufferMs");
        if (a3 != null) {
            zzbcxVar.c(a3.intValue());
        }
        Integer a4 = a((Map<String, String>) map, "maxBufferMs");
        if (a4 != null) {
            zzbcxVar.a(a4.intValue());
        }
        Integer a5 = a((Map<String, String>) map, "bufferForPlaybackMs");
        if (a5 != null) {
            zzbcxVar.d(a5.intValue());
        }
        Integer a6 = a((Map<String, String>) map, "bufferForPlaybackAfterRebufferMs");
        if (a6 != null) {
            zzbcxVar.e(a6.intValue());
        }
    }
}
