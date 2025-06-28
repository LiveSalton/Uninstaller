package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzdyz;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb {
    public static void a(Context context) {
        if (zzayu.a(context) && !zzayu.b()) {
            zzdyz<?> b = new u(context).b();
            zzd.d("Updating ad debug logging enablement.");
            zzazm.a(b, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
