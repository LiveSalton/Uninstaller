package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgc extends zzgl {
    public zzgc(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        try {
            this.b.d(((Boolean) this.c.invoke(null, this.a.a())).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.b.d(zzcn.ENUM_FAILURE);
        }
    }
}
