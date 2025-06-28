package com.google.android.gms.ads.internal.util;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzts;
import java.io.InputStream;
import java.util.Map;

/* compiled from: source */
@TargetApi(21)
/* loaded from: classes.dex */
public class zzaa extends zzx {
    @Override // com.google.android.gms.ads.internal.util.zzu
    public final int a() {
        return R.style.Theme.Material.Dialog.Alert;
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final CookieManager a(Context context) {
        if (d()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.c("Failed to obtain CookieManager.", th);
            zzp.g().a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final zzbdu a(zzbdv zzbdvVar, zzts zztsVar, boolean z) {
        return new zzbfb(zzbdvVar, zztsVar, z);
    }

    @Override // com.google.android.gms.ads.internal.util.zzu
    public final WebResourceResponse a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
