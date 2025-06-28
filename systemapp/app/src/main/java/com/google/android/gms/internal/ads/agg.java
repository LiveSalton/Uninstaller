package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class agg implements zzcyn<zzblv> {
    private final /* synthetic */ zzdjf a;

    agg(zzdjf zzdjfVar) {
        this.a = zzdjfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final void a() {
        synchronized (this.a) {
            this.a.a = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyn
    public final /* synthetic */ void a(zzblv zzblvVar) {
        zzdir zzdirVar;
        zzdir zzdirVar2;
        zzblv zzblvVar2 = zzblvVar;
        synchronized (this.a) {
            if (this.a.a != null) {
                this.a.a.b();
            }
            this.a.a = zzblvVar2;
            this.a.a(zzblvVar2);
            zzdirVar = this.a.g;
            zzdjf zzdjfVar = this.a;
            zzdirVar2 = this.a.g;
            zzdirVar.a(new zzbly(zzblvVar2, zzdjfVar, zzdirVar2));
            zzblvVar2.d_();
        }
    }
}
