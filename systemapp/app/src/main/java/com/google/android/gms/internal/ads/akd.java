package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class akd implements zzdtn {
    private final /* synthetic */ zzdsi a;

    akd(zzdsi zzdsiVar) {
        this.a = zzdsiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final void a(int i, long j) {
        this.a.a(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final void a(int i, long j, String str) {
        this.a.a(i, System.currentTimeMillis() - j, str);
    }
}
