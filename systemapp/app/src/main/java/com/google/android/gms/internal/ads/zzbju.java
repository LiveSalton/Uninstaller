package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbju implements zzbjn {
    private final Context a;

    public zzbju(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbjn
    public final void a(Map<String, String> map) {
        CookieManager a;
        String str = map.get("cookie");
        if (TextUtils.isEmpty(str) || (a = zzp.e().a(this.a)) == null) {
            return;
        }
        a.setCookie((String) zzwq.e().a(zzabf.am), str);
    }
}
