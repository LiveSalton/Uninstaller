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
public final class zzcns extends zzcnu {
    public zzcns(Context context) {
        this.f = new zzast(context, zzp.q().a(), this, this);
    }

    public final zzdyz<InputStream> a(zzatl zzatlVar) {
        synchronized (this.b) {
            if (this.c) {
                return this.a;
            }
            this.c = true;
            this.e = zzatlVar;
            this.f.f();
            this.a.a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.vw
                private final zzcns a;

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
                    this.f.w().a(this.e, new zzcnt(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzp.g().a(th, "RemoteAdRequestClientTask.onConnected");
                    this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
                }
            }
        }
    }
}
