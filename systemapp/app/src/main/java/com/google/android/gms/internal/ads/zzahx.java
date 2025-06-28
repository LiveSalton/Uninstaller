package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzahx implements zzahv<Object> {
    private final Context a;

    public zzahx(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        if (zzp.A().a(this.a)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    zzp.A().d(this.a, str2);
                    break;
                case 1:
                    zzp.A().e(this.a, str2);
                    break;
                case 2:
                    zzp.A().g(this.a, str2);
                    break;
                default:
                    zzd.c("logScionEvent gmsg contained unsupported eventName");
                    break;
            }
        }
    }
}
