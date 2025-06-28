package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
final class akm implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final zzdts a;
    private final zzdti b;
    private final Object c = new Object();
    private boolean d = false;
    private boolean e = false;

    akm(Context context, Looper looper, zzdti zzdtiVar) {
        this.b = zzdtiVar;
        this.a = new zzdts(context, looper, this, this, 12800000);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
    }

    final void a() {
        synchronized (this.c) {
            if (!this.d) {
                this.d = true;
                this.a.f();
            }
        }
    }

    private final void b() {
        synchronized (this.c) {
            if (this.a.g() || this.a.h()) {
                this.a.i();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        synchronized (this.c) {
            if (this.e) {
                return;
            }
            this.e = true;
            try {
                this.a.w().a(new zzdtq(this.b.l()));
                b();
            } catch (Exception unused) {
                b();
            } catch (Throwable th) {
                b();
                throw th;
            }
        }
    }
}
