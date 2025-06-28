package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzahc {
    public static final zzahv<zzbdv> a = ac.a;
    public static final zzahv<zzbdv> b = ab.a;
    public static final zzahv<zzbdv> c = ae.a;
    public static final zzahv<zzbdv> d = ad.a;
    public static final zzahv<zzbdv> e = new ai();
    public static final zzahv<zzbdv> f = new ak();
    public static final zzahv<zzbdv> g = ag.a;
    public static final zzahv<Object> h = new aj();
    public static final zzahv<zzbdv> i = new am();
    public static final zzahv<zzbdv> j = af.a;
    public static final zzahv<zzbdv> k = new al();
    public static final zzahv<zzbdv> l = new ao();
    public static final zzahv<zzbbe> m = new zzbcq();
    public static final zzahv<zzbbe> n = new zzbct();
    public static final zzahv<zzbdv> o = new zzahd();
    public static final zzaif p = new zzaif();
    public static final zzahv<zzbdv> q = new an();
    public static final zzahv<zzbdv> r = new aq();
    public static final zzahv<zzbdv> s = new ap();
    public static final zzahv<zzbdv> t = new ah();

    public static <T extends zzbex & zzbff & zzbfh> String a(T t2, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzef C = t2.C();
            if (C != null && C.a(parse)) {
                parse = C.a(parse, t2.getContext(), t2.getView(), t2.g());
            }
        } catch (zzei unused) {
            String valueOf = String.valueOf(str);
            zzd.e(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        return zzaxm.a(parse, t2.getContext());
    }

    static final /* synthetic */ void a(zzbff zzbffVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzef C = zzbffVar.C();
            if (C != null) {
                C.a().a(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzd.e("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void a(zzbex zzbexVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzd.e("URL missing from httpTrack GMSG.");
        } else {
            new com.google.android.gms.ads.internal.util.zzbp(zzbexVar.getContext(), ((zzbfe) zzbexVar).m().a, str).b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final /* synthetic */ void a(zzbdk zzbdkVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzd.e("URL missing from click GMSG.");
        } else {
            new com.google.android.gms.ads.internal.util.zzbp(((zzbex) zzbdkVar).getContext(), ((zzbfe) zzbdkVar).m().a, a(zzbdkVar, str)).b();
        }
    }

    static final /* synthetic */ void b(zzbex zzbexVar, Map map) {
        PackageManager packageManager = zzbexVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e2) {
                                String valueOf = String.valueOf(optString7);
                                zzd.c(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e3) {
                            zzd.c("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzd.c("Error parsing the intent data.", e4);
                    }
                }
                ((zzakb) zzbexVar).b("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzakb) zzbexVar).b("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzakb) zzbexVar).b("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void c(zzbex zzbexVar, Map map) {
        if (!((Boolean) zzwq.e().a(zzabf.eu)).booleanValue()) {
            zzd.e("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzd.e("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, Boolean.valueOf(zzbexVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null));
        ((zzakb) zzbexVar).a("openableApp", hashMap);
    }

    static final /* synthetic */ void d(zzbex zzbexVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzd.e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbexVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzakb) zzbexVar).a("openableURLs", hashMap);
    }
}
