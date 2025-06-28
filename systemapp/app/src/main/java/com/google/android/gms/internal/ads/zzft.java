package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzft implements Callable {
    private final zzfa a;
    private final zzcf.zza.C0060zza b;

    public zzft(zzfa zzfaVar, zzcf.zza.C0060zza c0060zza) {
        this.a = zzfaVar;
        this.b = c0060zza;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public final Void call() throws Exception {
        if (this.a.m() != null) {
            this.a.m().get();
        }
        zzcf.zza l = this.a.l();
        if (l == null) {
            return null;
        }
        try {
            synchronized (this.b) {
                zzcf.zza.C0060zza c0060zza = this.b;
                byte[] l2 = l.l();
                c0060zza.a(l2, 0, l2.length, zzeju.b());
            }
            return null;
        } catch (zzeks unused) {
            return null;
        }
    }
}
