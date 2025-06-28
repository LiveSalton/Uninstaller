package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgh extends zzgl {
    public zzgh(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.a(zzcn.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.c.invoke(null, this.a.a())).booleanValue();
        synchronized (this.b) {
            try {
                if (booleanValue) {
                    this.b.a(zzcn.ENUM_TRUE);
                } else {
                    this.b.a(zzcn.ENUM_FALSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
