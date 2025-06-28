package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzs extends zze {
    public zzs(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zze, com.google.android.gms.internal.ads.zzarj
    public final void a(Bundle bundle) {
        zzd.a("AdOverlayParcel is null or does not contain valid overlay type.");
        this.d = zzl.OTHER;
        this.a.finish();
    }
}
