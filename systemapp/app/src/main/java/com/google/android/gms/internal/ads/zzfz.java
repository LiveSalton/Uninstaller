package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfz extends zzgl {
    public zzfz(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        zzej zzejVar = new zzej((String) this.c.invoke(null, this.a.a(), Boolean.valueOf(((Boolean) zzwq.e().a(zzabf.bj)).booleanValue())));
        synchronized (this.b) {
            this.b.a(zzejVar.a);
            this.b.C(zzejVar.b);
        }
    }
}
