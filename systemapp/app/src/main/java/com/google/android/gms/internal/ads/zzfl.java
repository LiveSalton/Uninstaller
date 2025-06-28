package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfl extends zzgl {
    public zzfl(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.b(zzcn.ENUM_FAILURE);
        try {
            this.b.b(((Boolean) this.c.invoke(null, this.a.a())).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
