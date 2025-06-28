package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ks implements zzcyy {
    private zzbrg a;
    private zzczo b;
    private final /* synthetic */ zzbhg c;

    /* JADX INFO: Access modifiers changed from: private */
    ks(zzbhg zzbhgVar) {
        this.c = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyy
    public final zzcyv a() {
        zzepl.a(this.a, (Class<zzbrg>) zzbrg.class);
        zzepl.a(this.b, (Class<zzczo>) zzczo.class);
        return new ku(this.c, this.b, new zzbpf(), new zzcld(), this.a, new zzdot());
    }

    @Override // com.google.android.gms.internal.ads.zzcyy
    @Deprecated
    public final /* synthetic */ zzcyy a(zzbwp zzbwpVar) {
        zzepl.a(zzbwpVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcyy
    public final /* synthetic */ zzcyy a(zzczo zzczoVar) {
        this.b = (zzczo) zzepl.a(zzczoVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcyy
    public final /* synthetic */ zzcyy a(zzbrg zzbrgVar) {
        this.a = (zzbrg) zzepl.a(zzbrgVar);
        return this;
    }

    /* synthetic */ ks(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
