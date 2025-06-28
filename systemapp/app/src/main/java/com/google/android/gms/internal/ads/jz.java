package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class jz implements zzblf {
    private zzbwp a;
    private zzbrg b;
    private zzdnj c;
    private zzdkt d;
    private zzdjv e;
    private final /* synthetic */ zzbhg f;

    /* JADX INFO: Access modifiers changed from: private */
    jz(zzbhg zzbhgVar) {
        this.f = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    @Deprecated
    public final /* synthetic */ zzblf a(zzblz zzblzVar) {
        zzepl.a(zzblzVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf a(zzbrg zzbrgVar) {
        this.b = (zzbrg) zzepl.a(zzbrgVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzblf
    public final /* synthetic */ zzblf a(zzbwp zzbwpVar) {
        this.a = (zzbwp) zzepl.a(zzbwpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzblg b() {
        zzepl.a(this.a, (Class<zzbwp>) zzbwp.class);
        zzepl.a(this.b, (Class<zzbrg>) zzbrg.class);
        return new kc(this.f, new zzbpf(), new zzdol(), new zzbqq(), new zzcld(), this.a, this.b, new zzdot(), this.c, this.d, this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzblg> a(zzdjv zzdjvVar) {
        this.e = zzdjvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzblg> a(zzdkt zzdktVar) {
        this.d = zzdktVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzblg> a(zzdnj zzdnjVar) {
        this.c = zzdnjVar;
        return this;
    }

    /* synthetic */ jz(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
