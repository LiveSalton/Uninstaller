package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class cm extends cl<zzhy, zzhy> {
    cm() {
    }

    /* renamed from: a */
    private static void a2(Object obj, zzhy zzhyVar) {
        ((zzfd) obj).zzb = zzhyVar;
    }

    @Override // com.google.android.gms.internal.measurement.cl
    final void b(Object obj) {
        ((zzfd) obj).zzb.b();
    }

    @Override // com.google.android.gms.internal.measurement.cl
    final /* synthetic */ zzhy b(zzhy zzhyVar, zzhy zzhyVar2) {
        zzhy zzhyVar3 = zzhyVar;
        zzhy zzhyVar4 = zzhyVar2;
        return zzhyVar4.equals(zzhy.a()) ? zzhyVar3 : zzhy.a(zzhyVar3, zzhyVar4);
    }

    @Override // com.google.android.gms.internal.measurement.cl
    final /* synthetic */ zzhy a(Object obj) {
        return ((zzfd) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.cl
    final /* bridge */ /* synthetic */ void a(Object obj, zzhy zzhyVar) {
        a2(obj, zzhyVar);
    }
}
