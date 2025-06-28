package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfx extends zzgl {
    private long d;

    public zzfx(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 12);
        this.d = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.e(-1L);
        this.b.e(((Long) this.c.invoke(null, this.a.a())).longValue());
    }
}
