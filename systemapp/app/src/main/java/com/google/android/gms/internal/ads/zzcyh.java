package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcyh {
    private final zzcyl<zzboc> a;
    private final String b;

    @GuardedBy("this")
    private zzyn c;

    @GuardedBy("this")
    private boolean d = false;

    public zzcyh(zzcyl<zzboc> zzcylVar, String str) {
        this.a = zzcylVar;
        this.b = str;
    }

    public final synchronized boolean a() throws RemoteException {
        return this.a.a();
    }

    public final synchronized void a(zzvk zzvkVar, int i) throws RemoteException {
        this.c = null;
        this.d = this.a.a(zzvkVar, this.b, new zzcyq(i), new abg(this));
    }

    public final synchronized String b() {
        try {
            if (this.c == null) {
                return null;
            }
            return this.c.a();
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized String c() {
        try {
            if (this.c == null) {
                return null;
            }
            return this.c.a();
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
            return null;
        }
    }

    static /* synthetic */ boolean a(zzcyh zzcyhVar, boolean z) {
        zzcyhVar.d = false;
        return false;
    }
}
