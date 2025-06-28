package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcpv implements zzbrz, zzbtj {
    private static final Object a = new Object();
    private static int b;
    private final zzcqe c;

    public zzcpv(zzcqe zzcqeVar) {
        this.c = zzcqeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        a(false);
    }

    private static boolean b() {
        boolean z;
        synchronized (a) {
            z = b < ((Integer) zzwq.e().a(zzabf.dt)).intValue();
        }
        return z;
    }

    private final void a(boolean z) {
        if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue() && b()) {
            this.c.a(z);
            synchronized (a) {
                b++;
            }
        }
    }
}
