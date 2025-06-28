package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaus extends zzauo {
    private RewardedVideoAdListener a;

    public zzaus(RewardedVideoAdListener rewardedVideoAdListener) {
        this.a = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void c() {
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void d() {
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void a(zzauf zzaufVar) {
        if (this.a != null) {
            this.a.a(new zzauq(zzaufVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void e() {
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void f() {
        if (this.a != null) {
            this.a.f();
        }
    }
}
