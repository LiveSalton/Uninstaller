package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aje<AdT> implements zzdyo<zzdpn<AdT>> {
    private final /* synthetic */ zzdpv a;

    aje(zzdpv zzdpvVar) {
        this.a = zzdpvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzdqc zzdqcVar;
        zzdzh zzdzhVar;
        synchronized (this.a) {
            zzdqcVar = this.a.g;
            zzdqcVar.a(th);
            zzdzhVar = this.a.c;
            zzdzhVar.a(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(Object obj) {
        zzdqc zzdqcVar;
        int i;
        int i2;
        zzdzh zzdzhVar;
        zzdqb zzdqbVar;
        zzdpd zzdpdVar;
        zzdqb zzdqbVar2;
        zzdpn<?> zzdpnVar = (zzdpn) obj;
        synchronized (this.a) {
            zzdqcVar = this.a.g;
            zzdqcVar.a(zzdpnVar);
            i = this.a.e;
            if (i != ajg.b) {
                zzdpdVar = this.a.f;
                zzdqbVar2 = this.a.b;
                zzdpdVar.a(zzdqbVar2.b(), zzdpnVar);
            }
            i2 = this.a.e;
            if (i2 == ajg.a) {
                zzdpv zzdpvVar = this.a;
                zzdqbVar = this.a.b;
                zzdpvVar.c(zzdqbVar);
            }
            this.a.e = ajg.a;
            zzdzhVar = this.a.c;
            zzdzhVar.b((zzdzh) zzdpnVar);
        }
    }
}
