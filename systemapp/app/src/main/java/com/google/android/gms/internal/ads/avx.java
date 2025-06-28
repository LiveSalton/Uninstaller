package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class avx extends avw<zzeni, zzeni> {
    avx() {
    }

    @Override // com.google.android.gms.internal.ads.avw
    final boolean a(aux auxVar) {
        return false;
    }

    /* renamed from: a */
    private static void a2(Object obj, zzeni zzeniVar) {
        ((zzekh) obj).zzino = zzeniVar;
    }

    @Override // com.google.android.gms.internal.ads.avw
    final void d(Object obj) {
        ((zzekh) obj).zzino.c();
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ int f(zzeni zzeniVar) {
        return zzeniVar.e();
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ int e(zzeni zzeniVar) {
        return zzeniVar.d();
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ zzeni c(zzeni zzeniVar, zzeni zzeniVar2) {
        zzeni zzeniVar3 = zzeniVar;
        zzeni zzeniVar4 = zzeniVar2;
        return zzeniVar4.equals(zzeni.a()) ? zzeniVar3 : zzeni.a(zzeniVar3, zzeniVar4);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void b(zzeni zzeniVar, awo awoVar) throws IOException {
        zzeniVar.a(awoVar);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void a(zzeni zzeniVar, awo awoVar) throws IOException {
        zzeniVar.b(awoVar);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void b(Object obj, zzeni zzeniVar) {
        a2(obj, zzeniVar);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ zzeni c(Object obj) {
        zzeni zzeniVar = ((zzekh) obj).zzino;
        if (zzeniVar != zzeni.a()) {
            return zzeniVar;
        }
        zzeni b = zzeni.b();
        a2(obj, b);
        return b;
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ zzeni b(Object obj) {
        return ((zzekh) obj).zzino;
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void a(Object obj, zzeni zzeniVar) {
        a2(obj, zzeniVar);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ zzeni a(zzeni zzeniVar) {
        zzeni zzeniVar2 = zzeniVar;
        zzeniVar2.c();
        return zzeniVar2;
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ zzeni a() {
        return zzeni.b();
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void a(zzeni zzeniVar, int i, zzeni zzeniVar2) {
        zzeniVar.a((i << 3) | 3, zzeniVar2);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void a(zzeni zzeniVar, int i, zzeiu zzeiuVar) {
        zzeniVar.a((i << 3) | 2, zzeiuVar);
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void b(zzeni zzeniVar, int i, long j) {
        zzeniVar.a((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void a(zzeni zzeniVar, int i, int i2) {
        zzeniVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.avw
    final /* synthetic */ void a(zzeni zzeniVar, int i, long j) {
        zzeniVar.a(i << 3, Long.valueOf(j));
    }
}
