package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaig implements zzahv<Object> {
    private final zzaij a;

    public static void a(zzbdv zzbdvVar, zzaij zzaijVar) {
        zzbdvVar.a("/reward", new zzaig(zzaijVar));
    }

    private zzaig(zzaij zzaijVar) {
        this.a = zzaijVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzava zzavaVar = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzavaVar = new zzava(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzd.d("Unable to parse reward amount.", e);
            }
            this.a.a(zzavaVar);
            return;
        }
        if ("video_start".equals(str)) {
            this.a.a();
        } else if ("video_complete".equals(str)) {
            this.a.b();
        }
    }
}
