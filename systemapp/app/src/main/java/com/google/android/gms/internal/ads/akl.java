package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
final class akl implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    @VisibleForTesting
    private zzdts a;
    private final String b;
    private final String c;
    private final zzgn d;
    private final LinkedBlockingQueue<zzdud> f;
    private final zzdsi h;
    private final long i;
    private final int e = 1;
    private final HandlerThread g = new HandlerThread("GassDGClient");

    public akl(Context context, int i, zzgn zzgnVar, String str, String str2, String str3, zzdsi zzdsiVar) {
        this.b = str;
        this.d = zzgnVar;
        this.c = str2;
        this.h = zzdsiVar;
        this.g.start();
        this.i = System.currentTimeMillis();
        this.a = new zzdts(context, this.g.getLooper(), this, this, 19621000);
        this.f = new LinkedBlockingQueue<>();
        this.a.f();
    }

    public final zzdud b(int i) {
        zzdud zzdudVar;
        try {
            zzdudVar = this.f.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            a(2009, this.i, e);
            zzdudVar = null;
        }
        a(3004, this.i, null);
        if (zzdudVar != null) {
            if (zzdudVar.b == 7) {
                zzdsi.a(zzbw.zza.zzc.DISABLED);
            } else {
                zzdsi.a(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzdudVar == null ? c() : zzdudVar;
    }

    private final zzdtv a() {
        try {
            return this.a.w();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(int i) {
        try {
            a(4011, this.i, null);
            this.f.put(c());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        zzdtv a = a();
        if (a != null) {
            try {
                zzdud a2 = a.a(new zzdub(this.e, this.d, this.b, this.c));
                a(5011, this.i, null);
                this.f.put(a2);
            } catch (Throwable th) {
                a(2010, this.i, new Exception(th));
            } finally {
                b();
                this.g.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
        try {
            a(4012, this.i, null);
            this.f.put(c());
        } catch (InterruptedException unused) {
        }
    }

    private final void b() {
        if (this.a != null) {
            if (this.a.g() || this.a.h()) {
                this.a.i();
            }
        }
    }

    @VisibleForTesting
    private static zzdud c() {
        return new zzdud(null, 1);
    }

    private final void a(int i, long j, Exception exc) {
        if (this.h != null) {
            this.h.a(i, System.currentTimeMillis() - j, exc);
        }
    }
}
