package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfp extends zzgl {
    public zzfp(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.b(-1L);
        this.b.c(-1L);
        int[] iArr = (int[]) this.c.invoke(null, this.a.a());
        synchronized (this.b) {
            this.b.b(iArr[0]);
            this.b.c(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.b.B(iArr[2]);
            }
        }
    }
}
