package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsx {
    private final Runnable a = new bcl(this);
    private final Object b = new Object();

    @GuardedBy("lock")
    private zztc c;

    @GuardedBy("lock")
    private Context d;

    @GuardedBy("lock")
    private zztg e;

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.b) {
            if (this.d != null) {
                return;
            }
            this.d = context.getApplicationContext();
            if (((Boolean) zzwq.e().a(zzabf.bS)).booleanValue()) {
                b();
            } else {
                if (((Boolean) zzwq.e().a(zzabf.bR)).booleanValue()) {
                    zzp.f().a(new bcn(this));
                }
            }
        }
    }

    public final void a() {
        if (((Boolean) zzwq.e().a(zzabf.bT)).booleanValue()) {
            synchronized (this.b) {
                b();
                com.google.android.gms.ads.internal.util.zzm.a.removeCallbacks(this.a);
                com.google.android.gms.ads.internal.util.zzm.a.postDelayed(this.a, ((Long) zzwq.e().a(zzabf.bU)).longValue());
            }
        }
    }

    public final zzta a(zztf zztfVar) {
        synchronized (this.b) {
            if (this.e == null) {
                return new zzta();
            }
            try {
                if (this.c.x()) {
                    return this.e.b(zztfVar);
                }
                return this.e.a(zztfVar);
            } catch (RemoteException e) {
                zzd.c("Unable to call into cache service.", e);
                return new zzta();
            }
        }
    }

    public final long b(zztf zztfVar) {
        synchronized (this.b) {
            if (this.e == null) {
                return -2L;
            }
            if (this.c.x()) {
                try {
                    return this.e.c(zztfVar);
                } catch (RemoteException e) {
                    zzd.c("Unable to call into cache service.", e);
                }
            }
            return -2L;
        }
    }

    public final void b() {
        synchronized (this.b) {
            if (this.d != null && this.c == null) {
                this.c = a(new bcm(this), new bco(this));
                this.c.f();
            }
        }
    }

    @VisibleForTesting
    private final synchronized zztc a(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztc(this.d, zzp.q().a(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void c() {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            if (this.c.g() || this.c.h()) {
                this.c.i();
            }
            this.c = null;
            this.e = null;
            Binder.flushPendingCommands();
        }
    }

    static /* synthetic */ zztc a(zzsx zzsxVar, zztc zztcVar) {
        zzsxVar.c = null;
        return null;
    }
}
