package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfm extends zzgl {
    private final Activity d;
    private final View e;

    public zzfm(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2, View view, Activity activity) {
        super(zzfaVar, str, str2, c0060zza, i, 62);
        this.e = view;
        this.d = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.e == null) {
            return;
        }
        boolean booleanValue = ((Boolean) zzwq.e().a(zzabf.bh)).booleanValue();
        Object[] objArr = (Object[]) this.c.invoke(null, this.e, this.d, Boolean.valueOf(booleanValue));
        synchronized (this.b) {
            this.b.E(((Long) objArr[0]).longValue());
            this.b.F(((Long) objArr[1]).longValue());
            if (booleanValue) {
                this.b.h((String) objArr[2]);
            }
        }
    }
}
