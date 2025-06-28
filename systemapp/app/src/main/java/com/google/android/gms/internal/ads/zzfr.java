package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfr extends zzgl {
    private long d;

    public zzfr(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, long j, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 25);
        this.d = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.b) {
            this.b.G(longValue);
            if (this.d != 0) {
                this.b.i(longValue - this.d);
                this.b.l(this.d);
            }
        }
    }
}
