package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class kr implements zzchi {
    private zzbwp a;
    private zzbrg b;
    private zzdnj c;
    private zzdkt d;
    private zzdjv e;
    private final /* synthetic */ zzbhg f;

    /* JADX INFO: Access modifiers changed from: private */
    kr(zzbhg zzbhgVar) {
        this.f = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    /* renamed from: a */
    public final zzchf b() {
        zzepl.a(this.a, (Class<zzbwp>) zzbwp.class);
        zzepl.a(this.b, (Class<zzbrg>) zzbrg.class);
        return new kq(this.f, new zzbpf(), new zzdol(), new zzbqq(), new zzcld(), this.a, this.b, new zzdot(), this.c, this.d, this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzchi
    public final /* synthetic */ zzchi a(zzbrg zzbrgVar) {
        this.b = (zzbrg) zzepl.a(zzbrgVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzchi
    public final /* synthetic */ zzchi a(zzbwp zzbwpVar) {
        this.a = (zzbwp) zzepl.a(zzbwpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzchf> a(zzdjv zzdjvVar) {
        this.e = zzdjvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzchf> a(zzdkt zzdktVar) {
        this.d = zzdktVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzchf> a(zzdnj zzdnjVar) {
        this.c = zzdnjVar;
        return this;
    }

    /* synthetic */ kr(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
