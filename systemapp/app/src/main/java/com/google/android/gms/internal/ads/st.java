package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class st implements zzadx {
    private final /* synthetic */ zzcgb a;

    st(zzcgb zzcgbVar) {
        this.a = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final JSONObject b() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a() {
        zzcbt zzcbtVar;
        zzcbt zzcbtVar2;
        zzcbtVar = this.a.d;
        if (zzcbtVar != null) {
            zzcbtVar2 = this.a.d;
            zzcbtVar2.a("_videoMediaView");
        }
    }
}
