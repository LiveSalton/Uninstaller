package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class iw implements zzahv<zzbdv> {
    private final /* synthetic */ iu a;

    iw(iu iuVar) {
        this.a = iuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        int i;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.a) {
                    i = this.a.J;
                    if (i != parseInt) {
                        this.a.J = parseInt;
                        this.a.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzd.d("Exception occurred while getting webview content height", e);
            }
        }
    }
}
