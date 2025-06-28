package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzcnc implements zzdyb<zzatl, zzdnj> {
    private final zzbuh a;

    public zzcnc(zzbuh zzbuhVar) {
        this.a = zzbuhVar;
    }

    /* renamed from: a */
    protected abstract zzdyz<zzdnj> a2(zzatl zzatlVar) throws zzcme;

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final /* synthetic */ zzdyz<zzdnj> a(zzatl zzatlVar) throws Exception {
        zzatl zzatlVar2 = zzatlVar;
        this.a.a(zzatlVar2);
        zzdyz<zzdnj> a2 = a2(zzatlVar2);
        zzdyr.a(a2, new vm(this), zzazj.f);
        return a2;
    }
}
