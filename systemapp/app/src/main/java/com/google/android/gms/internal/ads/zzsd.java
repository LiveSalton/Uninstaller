package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsd implements Comparator<zzrr> {
    public zzsd(zzsa zzsaVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzrr zzrrVar, zzrr zzrrVar2) {
        zzrr zzrrVar3 = zzrrVar;
        zzrr zzrrVar4 = zzrrVar2;
        if (zzrrVar3.b() < zzrrVar4.b()) {
            return -1;
        }
        if (zzrrVar3.b() > zzrrVar4.b()) {
            return 1;
        }
        if (zzrrVar3.a() < zzrrVar4.a()) {
            return -1;
        }
        if (zzrrVar3.a() > zzrrVar4.a()) {
            return 1;
        }
        float d = (zzrrVar3.d() - zzrrVar3.b()) * (zzrrVar3.c() - zzrrVar3.a());
        float d2 = (zzrrVar4.d() - zzrrVar4.b()) * (zzrrVar4.c() - zzrrVar4.a());
        if (d > d2) {
            return -1;
        }
        return d < d2 ? 1 : 0;
    }
}
