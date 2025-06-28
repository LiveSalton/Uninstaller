package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class fu<T> implements zzdyo<T> {
    private final /* synthetic */ zzazu a;
    private final /* synthetic */ zzazs b;

    fu(zzazx zzazxVar, zzazu zzazuVar, zzazs zzazsVar) {
        this.a = zzazuVar;
        this.b = zzazsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(T t) {
        this.a.a(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        this.b.a();
    }
}
