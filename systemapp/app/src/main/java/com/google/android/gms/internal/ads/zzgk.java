package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgk extends zzgl {
    private final View d;

    public zzgk(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2, View view) {
        super(zzfaVar, str, str2, c0060zza, i, 57);
        this.d = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.d != null) {
            Boolean bool = (Boolean) zzwq.e().a(zzabf.bs);
            zzfi zzfiVar = new zzfi((String) this.c.invoke(null, this.d, this.a.a().getResources().getDisplayMetrics(), bool));
            zzcf.zza.zzf.C0062zza a = zzcf.zza.zzf.a();
            a.a(zzfiVar.a.longValue()).b(zzfiVar.b.longValue()).c(zzfiVar.c.longValue());
            if (bool.booleanValue()) {
                a.d(zzfiVar.d.longValue());
            }
            this.b.a((zzcf.zza.zzf) ((zzekh) a.g()));
        }
    }
}
