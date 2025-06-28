package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzmp implements zznm {
    private final zznm[] a;

    public zzmp(zznm[] zznmVarArr) {
        this.a = zznmVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final long e() {
        long j = Long.MAX_VALUE;
        for (zznm zznmVar : this.a) {
            long e = zznmVar.e();
            if (e != Long.MIN_VALUE) {
                j = Math.min(j, e);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final boolean b(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long e = e();
            if (e == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zznm zznmVar : this.a) {
                if (zznmVar.e() == e) {
                    z |= zznmVar.b(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
