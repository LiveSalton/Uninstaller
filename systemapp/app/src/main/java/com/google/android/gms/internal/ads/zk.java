package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
final class zk<T> implements zzdyo<T> {
    private final /* synthetic */ long a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzdmu c;
    private final /* synthetic */ zzdmz d;
    private final /* synthetic */ zzcum e;

    zk(zzcum zzcumVar, long j, String str, zzdmu zzdmuVar, zzdmz zzdmzVar) {
        this.e = zzcumVar;
        this.a = j;
        this.b = str;
        this.c = zzdmuVar;
        this.d = zzdmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(T t) {
        Clock clock;
        boolean z;
        zzcrg zzcrgVar;
        zzcuo zzcuoVar;
        clock = this.e.a;
        long b = clock.b() - this.a;
        this.e.a(this.b, 0, b, this.c.ab);
        z = this.e.d;
        if (z) {
            zzcuoVar = this.e.b;
            zzcuoVar.a(this.d, this.c, 0, null, b);
        }
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue()) {
            zzcrgVar = this.e.e;
            zzcrgVar.a(this.c, b, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        Clock clock;
        int i;
        boolean z;
        zzcrg zzcrgVar;
        zzcuo zzcuoVar;
        clock = this.e.a;
        long b = clock.b() - this.a;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcuc) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdnr) {
            i = 5;
        } else {
            i = ((th instanceof zzcme) && zzdoi.a(th).a == 3) ? 1 : 6;
        }
        this.e.a(this.b, i, b, this.c.ab);
        z = this.e.d;
        if (z) {
            zzcuoVar = this.e.b;
            zzcuoVar.a(this.d, this.c, i, th instanceof zzcrd ? (zzcrd) th : null, b);
        }
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue()) {
            zzve a = zzdoi.a(th);
            if ((a.a == 3 || a.a == 0) && a.d != null && !a.d.c.equals("com.google.android.gms.ads")) {
                a = zzdoi.a(new zzcrd(zzdok.MEDIATION_NO_FILL, a.d));
            }
            zzcrgVar = this.e.e;
            zzcrgVar.a(this.c, b, a);
        }
    }
}
