package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayr implements zziv {
    private final /* synthetic */ zzjc a;

    /* JADX INFO: Access modifiers changed from: private */
    ayr(zzjc zzjcVar) {
        this.a = zzjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final void a(int i) {
        zzik zzikVar;
        zzikVar = this.a.b;
        zzikVar.a(i);
        zzjc.b(i);
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final void a() {
        zzjc.v();
        zzjc.a(this.a, true);
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final void a(int i, long j, long j2) {
        zzik zzikVar;
        zzikVar = this.a.b;
        zzikVar.a(i, j, j2);
        zzjc.a(i, j, j2);
    }

    /* synthetic */ ayr(zzjc zzjcVar, ayp aypVar) {
        this(zzjcVar);
    }
}
