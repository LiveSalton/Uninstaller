package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfo extends zzgl {
    private static zzgo<String> d = new zzgo<>();
    private final Context e;

    public zzfo(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2, Context context) {
        super(zzfaVar, str, str2, c0060zza, i, 29);
        this.e = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.b.d("E");
        AtomicReference<String> a = d.a(this.e.getPackageName());
        if (a.get() == null) {
            synchronized (a) {
                if (a.get() == null) {
                    a.set((String) this.c.invoke(null, this.e));
                }
            }
        }
        String str = a.get();
        synchronized (this.b) {
            this.b.d(zzcv.a(str.getBytes(), true));
        }
    }
}
