package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbcq implements zzahv<zzbbe> {
    private boolean a;

    private static int a(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzwq.a();
                return zzayr.a(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(34 + String.valueOf(str).length() + String.valueOf(str2).length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                zzd.e(sb.toString());
            }
        }
        return i;
    }

    private static Integer a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(41 + String.valueOf(str).length() + String.valueOf(str2).length());
            sb.append("Video gmsg invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzd.e(sb.toString());
            return null;
        }
    }

    private static void a(zzbar zzbarVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbarVar.b(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzd.e(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbarVar.c(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbarVar.d(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbarVar.e(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbarVar.f(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbbe zzbbeVar, Map map) {
        int i;
        zzbbe zzbbeVar2 = zzbbeVar;
        String str = (String) map.get("action");
        if (str == null) {
            zzd.e("Action missing from video GMSG.");
            return;
        }
        if (zzd.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(13 + String.valueOf(str).length() + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzd.b(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzd.e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbbeVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzd.e("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzd.e("No MIME types specified for decoder properties inspection.");
                zzbar.a(zzbbeVar2, "missingMimeTypes");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, zzca.a(str4.trim()));
            }
            zzbar.a(zzbbeVar2, hashMap);
            return;
        }
        zzbax c = zzbbeVar2.c();
        if (c == null) {
            zzd.e("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (equals || equals2) {
            Context context = zzbbeVar2.getContext();
            int a = a(context, map, "x", 0);
            int a2 = a(context, map, "y", 0);
            int a3 = a(context, map, "w", -1);
            int a4 = a(context, map, "h", -1);
            int min = Math.min(a3, zzbbeVar2.o() - a);
            int min2 = Math.min(a4, zzbbeVar2.n() - a2);
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused2) {
                i = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && c.a() == null) {
                c.a(a, a2, min, min2, i, parseBoolean, new zzbbf((String) map.get("flags")));
                zzbar a5 = c.a();
                if (a5 != null) {
                    a(a5, (Map<String, String>) map);
                    return;
                }
                return;
            }
            c.a(a, a2, min, min2);
            return;
        }
        zzbep d = zzbbeVar2.d();
        if (d != null) {
            if ("timeupdate".equals(str)) {
                String str5 = (String) map.get("currentTime");
                if (str5 == null) {
                    zzd.e("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    d.a(Float.parseFloat(str5));
                    return;
                } catch (NumberFormatException unused3) {
                    String valueOf = String.valueOf(str5);
                    zzd.e(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                    return;
                }
            }
            if ("skip".equals(str)) {
                d.l();
                return;
            }
        }
        zzbar a6 = c.a();
        if (a6 == null) {
            zzbar.a(zzbbeVar2);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzbbeVar2.getContext();
            int a7 = a(context2, map, "x", 0);
            int a8 = a(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, a7, a8, 0);
            a6.a(obtain);
            obtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str6 = (String) map.get("time");
            if (str6 == null) {
                zzd.e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                a6.a((int) (Float.parseFloat(str6) * 1000.0f));
                return;
            } catch (NumberFormatException unused4) {
                String valueOf2 = String.valueOf(str6);
                zzd.e(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                return;
            }
        }
        if ("hide".equals(str)) {
            a6.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            a6.h();
            return;
        }
        if ("loadControl".equals(str)) {
            a(a6, (Map<String, String>) map);
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                a6.k();
                return;
            } else {
                a6.l();
                return;
            }
        }
        if ("pause".equals(str)) {
            a6.i();
            return;
        }
        if ("play".equals(str)) {
            a6.j();
            return;
        }
        if ("show".equals(str)) {
            a6.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            String str7 = (String) map.get("src");
            Integer a9 = a((Map<String, String>) map, "periodicReportIntervalMs");
            String[] strArr = {str7};
            String str8 = (String) map.get("demuxed");
            if (str8 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str8);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = jSONArray.getString(i2);
                    }
                    strArr = strArr2;
                } catch (JSONException unused5) {
                    String valueOf3 = String.valueOf(str8);
                    zzd.e(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                    strArr = new String[]{str7};
                }
            }
            if (a9 != null) {
                zzbbeVar2.a(a9.intValue());
            }
            a6.a(str7, strArr);
            return;
        }
        if ("touchMove".equals(str)) {
            Context context3 = zzbbeVar2.getContext();
            a6.a(a(context3, map, "dx", 0), a(context3, map, "dy", 0));
            if (this.a) {
                return;
            }
            zzbbeVar2.i();
            this.a = true;
            return;
        }
        if ("volume".equals(str)) {
            String str9 = (String) map.get("volume");
            if (str9 == null) {
                zzd.e("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                a6.setVolume(Float.parseFloat(str9));
                return;
            } catch (NumberFormatException unused6) {
                String valueOf4 = String.valueOf(str9);
                zzd.e(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                return;
            }
        }
        if ("watermark".equals(str)) {
            a6.m();
        } else {
            String valueOf5 = String.valueOf(str);
            zzd.e(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
        }
    }
}
