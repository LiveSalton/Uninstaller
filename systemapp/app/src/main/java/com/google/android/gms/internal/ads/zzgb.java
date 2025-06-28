package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgb extends zzgl {
    private List<Long> d;

    public zzgb(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 31);
        this.d = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.m(-1L);
        this.b.n(-1L);
        if (this.d == null) {
            this.d = (List) this.c.invoke(null, this.a.a());
        }
        if (this.d == null || this.d.size() != 2) {
            return;
        }
        synchronized (this.b) {
            this.b.m(this.d.get(0).longValue());
            this.b.n(this.d.get(1).longValue());
        }
    }
}
