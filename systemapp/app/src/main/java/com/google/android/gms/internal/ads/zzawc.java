package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzawc extends zzavl {
    private FullScreenContentCallback a;
    private OnUserEarnedRewardListener b;

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a() {
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void b() {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a(zzve zzveVar) {
        if (this.a != null) {
            this.a.a(zzveVar.a());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavi
    public final void a(zzavc zzavcVar) {
        if (this.b != null) {
            this.b.a(new zzavv(zzavcVar));
        }
    }
}
