package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfw extends zzgl {
    private static volatile Long d;
    private static final Object e = new Object();

    public zzfw(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.k(d.longValue());
        }
    }
}
