package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzayu;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class u extends zza {
    private Context a;

    u(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void a() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.a);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzd.c("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzayu.a(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzd.e(sb.toString());
    }
}
