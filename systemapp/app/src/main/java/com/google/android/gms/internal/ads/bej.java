package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;

/* compiled from: source */
/* loaded from: classes.dex */
final class bej extends zzwp {
    private final /* synthetic */ zzzc a;

    bej(zzzc zzzcVar) {
        this.a = zzzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwp, com.google.android.gms.ads.AdListener
    public final void a() {
        VideoController videoController;
        videoController = this.a.d;
        videoController.a(this.a.m());
        super.a();
    }

    @Override // com.google.android.gms.internal.ads.zzwp, com.google.android.gms.ads.AdListener
    public final void a(int i) {
        VideoController videoController;
        videoController = this.a.d;
        videoController.a(this.a.m());
        super.a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwp, com.google.android.gms.ads.AdListener
    public final void a(LoadAdError loadAdError) {
        VideoController videoController;
        videoController = this.a.d;
        videoController.a(this.a.m());
        super.a(loadAdError);
    }
}
