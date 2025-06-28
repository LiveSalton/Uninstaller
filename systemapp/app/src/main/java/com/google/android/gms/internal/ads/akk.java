package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
final class akk implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    @VisibleForTesting
    private zzdts a;
    private final String b;
    private final String c;
    private final LinkedBlockingQueue<zzcf.zza> d;
    private final HandlerThread e = new HandlerThread("GassClient");

    public akk(Context context, String str, String str2) {
        this.b = str;
        this.c = str2;
        this.e.start();
        this.a = new zzdts(context, this.e.getLooper(), this, this, 9200000);
        this.d = new LinkedBlockingQueue<>();
        this.a.f();
    }

    public final zzcf.zza b(int i) {
        zzcf.zza zzaVar;
        try {
            zzaVar = this.d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVar = null;
        }
        return zzaVar == null ? c() : zzaVar;
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
            this.d.put(c());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        zzdtv a = a();
        try {
            if (a != null) {
                try {
                    try {
                        this.d.put(a.a(new zzdtr(this.b, this.c)).a());
                    } catch (Throwable unused) {
                        this.d.put(c());
                    }
                } catch (InterruptedException unused2) {
                }
            }
        } finally {
            b();
            this.e.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
        try {
            this.d.put(c());
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
    private static zzcf.zza c() {
        return (zzcf.zza) ((zzekh) zzcf.zza.h().j(32768L).g());
    }
}
