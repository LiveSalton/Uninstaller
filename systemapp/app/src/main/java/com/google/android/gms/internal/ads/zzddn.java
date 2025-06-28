package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddn implements zzdfi<zzddk> {
    private final zzdzc a;
    private final zzdnn b;
    private final PackageInfo c;
    private final zzf d;

    public zzddn(zzdzc zzdzcVar, zzdnn zzdnnVar, PackageInfo packageInfo, zzf zzfVar) {
        this.a = zzdzcVar;
        this.b = zzdnnVar;
        this.c = packageInfo;
        this.d = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzddk> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.adn
            private final zzddn a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ void a(ArrayList arrayList, Bundle bundle) {
        String str;
        String str2;
        JSONArray optJSONArray;
        String str3;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.b.h);
        if (((Boolean) zzwq.e().a(zzabf.bE)).booleanValue() && this.b.i.a > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            switch (this.b.i.h) {
                case 1:
                    str3 = "any";
                    break;
                case 2:
                    str3 = "landscape";
                    break;
                case 3:
                    str3 = "portrait";
                    break;
                case 4:
                    str3 = "square";
                    break;
                default:
                    str3 = "unknown";
                    break;
            }
            if (!"unknown".equals(str3)) {
                bundle.putString("native_media_orientation", str3);
            }
        }
        switch (this.b.i.c) {
            case 0:
                str = "any";
                break;
            case 1:
                str = "portrait";
                break;
            case 2:
                str = "landscape";
                break;
            default:
                str = "unknown";
                break;
        }
        if (!"unknown".equals(str)) {
            bundle.putString("native_image_orientation", str);
        }
        bundle.putBoolean("native_multiple_images", this.b.i.d);
        bundle.putBoolean("use_custom_mute", this.b.i.g);
        PackageInfo packageInfo = this.c;
        int i = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i > this.d.g()) {
            this.d.m();
            this.d.a(i);
        }
        JSONObject l = this.d.l();
        String jSONArray = (l == null || (optJSONArray = l.optJSONArray(this.b.f)) == null) ? null : optJSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray)) {
            bundle.putString("native_advanced_settings", jSONArray);
        }
        if (this.b.k > 1) {
            bundle.putInt("max_num_ads", this.b.k);
        }
        zzajl zzajlVar = this.b.c;
        if (zzajlVar != null) {
            if (TextUtils.isEmpty(zzajlVar.c)) {
                if (zzajlVar.a < 2) {
                    switch (zzajlVar.b) {
                        case 1:
                            str2 = "l";
                            break;
                        case 2:
                            str2 = "p";
                            break;
                        default:
                            int i2 = zzajlVar.b;
                            StringBuilder sb = new StringBuilder(52);
                            sb.append("Instream ad video aspect ratio ");
                            sb.append(i2);
                            sb.append(" is wrong.");
                            zzaza.c(sb.toString());
                            str2 = "l";
                            break;
                    }
                } else {
                    switch (zzajlVar.d) {
                        case 2:
                            str2 = "l";
                            break;
                        case 3:
                            str2 = "p";
                            break;
                        default:
                            str2 = "l";
                            break;
                    }
                }
                bundle.putString("ia_var", str2);
            } else {
                bundle.putString("ad_tag", zzajlVar.c);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.b.a() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
    }

    final /* synthetic */ zzddk b() throws Exception {
        ArrayList<String> arrayList = this.b.g;
        if (arrayList == null) {
            return adp.a;
        }
        if (arrayList.isEmpty()) {
            return ado.a;
        }
        return new zzddk(this, arrayList) { // from class: com.google.android.gms.internal.ads.adq
            private final zzddn a;
            private final ArrayList b;

            {
                this.a = this;
                this.b = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Bundle bundle) {
                this.a.a(this.b, bundle);
            }
        };
    }
}
