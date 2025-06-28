package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzahd implements zzahv<zzbdv> {
    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzbdv zzbdvVar2 = zzbdvVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzd.e("No label given for CSI tick.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                zzd.e("No timestamp given for CSI tick.");
                return;
            }
            try {
                long b = zzp.j().b() + (Long.parseLong(str4) - zzp.j().a());
                if (TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                zzbdvVar2.l().a(str2, str3, b);
                return;
            } catch (NumberFormatException e) {
                zzd.d("Malformed timestamp for CSI tick.", e);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzd.e("No value given for CSI experiment.");
                return;
            }
            zzabs a = zzbdvVar2.l().a();
            if (a == null) {
                zzd.e("No ticker for WebView, dropping experiment ID.");
                return;
            } else {
                a.a("e", str5);
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzd.e("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                zzd.e("No name given for CSI extra.");
                return;
            }
            zzabs a2 = zzbdvVar2.l().a();
            if (a2 == null) {
                zzd.e("No ticker for WebView, dropping extra parameter.");
            } else {
                a2.a(str6, str7);
            }
        }
    }
}
