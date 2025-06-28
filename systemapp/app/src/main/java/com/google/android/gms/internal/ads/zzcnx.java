package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcnx extends zzcnu {
    private String g;
    private int h = wc.a;

    public zzcnx(Context context) {
        this.f = new zzast(context, zzp.q().a(), this, this);
    }

    public final zzdyz<InputStream> a(zzatl zzatlVar) {
        synchronized (this.b) {
            if (this.h != wc.a && this.h != wc.b) {
                return zzdyr.a((Throwable) new zzcoh(zzdok.INVALID_REQUEST));
            }
            if (this.c) {
                return this.a;
            }
            this.h = wc.b;
            this.c = true;
            this.e = zzatlVar;
            this.f.f();
            this.a.a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.wa
                private final zzcnx a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a();
                }
            }, zzazj.f);
            return this.a;
        }
    }

    public final zzdyz<InputStream> a(String str) {
        synchronized (this.b) {
            if (this.h != wc.a && this.h != wc.c) {
                return zzdyr.a((Throwable) new zzcoh(zzdok.INVALID_REQUEST));
            }
            if (this.c) {
                return this.a;
            }
            this.h = wc.c;
            this.c = true;
            this.g = str;
            this.f.f();
            this.a.a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.vy
                private final zzcnx a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a();
                }
            }, zzazj.f);
            return this.a;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcnu, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
        zzd.b("Cannot connect to remote service, fallback to local instance.");
        this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        synchronized (this.b) {
            if (!this.d) {
                this.d = true;
                try {
                    if (this.h == wc.b) {
                        this.f.w().c(this.e, new zzcnt(this));
                    } else if (this.h == wc.c) {
                        this.f.w().a(this.g, new zzcnt(this));
                    } else {
                        this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzp.g().a(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
                }
            }
        }
    }
}
