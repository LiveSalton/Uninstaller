package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgd extends zzgl {
    private final StackTraceElement[] d;

    public zzgd(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfaVar, str, str2, c0060zza, i, 45);
        this.d = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        zzcn zzcnVar;
        if (this.d != null) {
            zzew zzewVar = new zzew((String) this.c.invoke(null, this.d));
            synchronized (this.b) {
                this.b.x(zzewVar.a.longValue());
                if (zzewVar.b.booleanValue()) {
                    zzcf.zza.C0060zza c0060zza = this.b;
                    if (zzewVar.c.booleanValue()) {
                        zzcnVar = zzcn.ENUM_FALSE;
                    } else {
                        zzcnVar = zzcn.ENUM_TRUE;
                    }
                    c0060zza.c(zzcnVar);
                } else {
                    this.b.c(zzcn.ENUM_FAILURE);
                }
            }
        }
    }
}
