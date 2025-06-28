package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzahw implements zzahv<zzbdv> {
    private static final Map<String, Integer> d = CollectionUtils.a(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zza a;
    private final zzaqk b;
    private final zzaqx c;

    public zzahw(zza zzaVar, zzaqk zzaqkVar, zzaqx zzaqxVar) {
        this.a = zzaVar;
        this.b = zzaqkVar;
        this.c = zzaqxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzbdv zzbdvVar2 = zzbdvVar;
        int intValue = d.get((String) map.get("a")).intValue();
        if (intValue != 5 && intValue != 7 && this.a != null && !this.a.b()) {
            this.a.a(null);
        }
        if (intValue == 1) {
            this.b.a((Map<String, String>) map);
            return;
        }
        switch (intValue) {
            case 3:
                new zzaqp(zzbdvVar2, map).a();
                break;
            case 4:
                new zzaqj(zzbdvVar2, map).a();
                break;
            case 5:
                new zzaqm(zzbdvVar2, map).a();
                break;
            case 6:
                this.b.a(true);
                break;
            case 7:
                this.c.b();
                break;
            default:
                zzd.d("Unknown MRAID command called.");
                break;
        }
    }
}
