package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class kj implements zzcaa {
    private zzbwp a;
    private zzbrg b;
    private zzcwq c;
    private zzdnj d;
    private zzdkt e;
    private zzdjv f;
    private final /* synthetic */ zzbhg g;

    /* JADX INFO: Access modifiers changed from: private */
    kj(zzbhg zzbhgVar) {
        this.g = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    /* renamed from: a */
    public final zzbzx b() {
        zzepl.a(this.a, (Class<zzbwp>) zzbwp.class);
        zzepl.a(this.b, (Class<zzbrg>) zzbrg.class);
        zzepl.a(this.c, (Class<zzcwq>) zzcwq.class);
        return new kl(this.g, new zzbpf(), new zzdol(), new zzbqq(), new zzcld(), this.a, this.b, new zzdot(), this.c, this.d, this.e, this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final /* synthetic */ zzcaa a(zzcwq zzcwqVar) {
        this.c = (zzcwq) zzepl.a(zzcwqVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final /* synthetic */ zzcaa a(zzbrg zzbrgVar) {
        this.b = (zzbrg) zzepl.a(zzbrgVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final /* synthetic */ zzcaa a(zzbwp zzbwpVar) {
        this.a = (zzbwp) zzepl.a(zzbwpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzbzx> a(zzdjv zzdjvVar) {
        this.f = zzdjvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzbzx> a(zzdkt zzdktVar) {
        this.e = zzdktVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzbzx> a(zzdnj zzdnjVar) {
        this.d = zzdnjVar;
        return this;
    }

    /* synthetic */ kj(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
