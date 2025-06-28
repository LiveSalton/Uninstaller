package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaal extends zzyw {
    private final VideoController.VideoLifecycleCallbacks a;

    public zzaal(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.a = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void a() {
        this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void b() {
        this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void c() {
        this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void d() {
        this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void a(boolean z) {
        this.a.a(z);
    }
}
