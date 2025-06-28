package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ld implements zzdyo<String> {
    private final /* synthetic */ String a;
    private final /* synthetic */ zzbjv b;

    ld(zzbjv zzbjvVar, String str) {
        this.b = zzbjvVar;
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzdnv zzdnvVar;
        zzdrx zzdrxVar;
        zzdnj zzdnjVar;
        zzdmu zzdmuVar;
        zzdmu zzdmuVar2;
        zzdnvVar = this.b.g;
        zzdrxVar = this.b.f;
        zzdnjVar = this.b.d;
        zzdmuVar = this.b.e;
        String str = this.a;
        zzdmuVar2 = this.b.e;
        zzdnvVar.a(zzdrxVar.a(zzdnjVar, zzdmuVar, false, str, null, zzdmuVar2.d));
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(String str) {
        zzdnv zzdnvVar;
        zzdrx zzdrxVar;
        zzdnj zzdnjVar;
        zzdmu zzdmuVar;
        zzdmu zzdmuVar2;
        String str2 = str;
        zzdnvVar = this.b.g;
        zzdrxVar = this.b.f;
        zzdnjVar = this.b.d;
        zzdmuVar = this.b.e;
        String str3 = this.a;
        zzdmuVar2 = this.b.e;
        zzdnvVar.a(zzdrxVar.a(zzdnjVar, zzdmuVar, false, str3, str2, zzdmuVar2.d));
    }
}
