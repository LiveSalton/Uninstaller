package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgf extends zzgl {
    private final zzfh d;
    private long e;

    public zzgf(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2, zzfh zzfhVar) {
        super(zzfaVar, str, str2, c0060zza, i, 53);
        this.d = zzfhVar;
        if (zzfhVar != null) {
            this.e = zzfhVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.d != null) {
            this.b.A(((Long) this.c.invoke(null, Long.valueOf(this.e))).longValue());
        }
    }
}
