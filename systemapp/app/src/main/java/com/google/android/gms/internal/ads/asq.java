package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: source */
/* loaded from: classes.dex */
final class asq implements Comparator<zzeiu> {
    asq() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzeiu zzeiuVar, zzeiu zzeiuVar2) {
        int b;
        int b2;
        zzeiu zzeiuVar3 = zzeiuVar;
        zzeiu zzeiuVar4 = zzeiuVar2;
        zzejd zzejdVar = (zzejd) zzeiuVar3.iterator();
        zzejd zzejdVar2 = (zzejd) zzeiuVar4.iterator();
        while (zzejdVar.hasNext() && zzejdVar2.hasNext()) {
            b = zzeiu.b(zzejdVar.a());
            b2 = zzeiu.b(zzejdVar2.a());
            int compare = Integer.compare(b, b2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeiuVar3.b(), zzeiuVar4.b());
    }
}
