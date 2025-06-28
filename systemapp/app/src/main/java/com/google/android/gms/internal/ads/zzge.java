package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzge extends zzgl {
    private final boolean d;

    public zzge(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 61);
        this.d = zzfaVar.j();
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.c.invoke(null, this.a.a(), Boolean.valueOf(this.d))).longValue();
        synchronized (this.b) {
            this.b.D(longValue);
        }
    }
}
