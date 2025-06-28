package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class jy implements zzbls {
    private zzbwp a;
    private zzbrg b;
    private zzdnj c;
    private zzdkt d;
    private zzdjv e;
    private final /* synthetic */ zzbhg f;

    /* JADX INFO: Access modifiers changed from: private */
    jy(zzbhg zzbhgVar) {
        this.f = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    @Deprecated
    public final /* synthetic */ zzbls a(zzblz zzblzVar) {
        zzepl.a(zzblzVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ zzbls a(zzbrg zzbrgVar) {
        this.b = (zzbrg) zzepl.a(zzbrgVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ zzbls a(zzbwp zzbwpVar) {
        this.a = (zzbwp) zzepl.a(zzbwpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzblp b() {
        zzepl.a(this.a, (Class<zzbwp>) zzbwp.class);
        zzepl.a(this.b, (Class<zzbrg>) zzbrg.class);
        return new jx(this.f, new zzbpf(), new zzdol(), new zzbqq(), new zzcld(), this.a, this.b, new zzdot(), this.c, this.d, this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzblp> a(zzdjv zzdjvVar) {
        this.e = zzdjvVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzblp> a(zzdkt zzdktVar) {
        this.d = zzdktVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final /* synthetic */ zzbrd<zzblp> a(zzdnj zzdnjVar) {
        this.c = zzdnjVar;
        return this;
    }

    /* synthetic */ jy(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
