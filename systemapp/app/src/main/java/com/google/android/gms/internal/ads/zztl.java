package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztl {

    @GuardedBy("lock")
    private zztc a;

    @GuardedBy("lock")
    private boolean b;
    private final Context c;
    private final Object d = new Object();

    zztl(Context context) {
        this.c = context;
    }

    final Future<zztt> a(zztf zztfVar) {
        bcp bcpVar = new bcp(this);
        bcr bcrVar = new bcr(this, zztfVar, bcpVar);
        bcu bcuVar = new bcu(this, bcpVar);
        synchronized (this.d) {
            this.a = new zztc(this.c, zzp.q().a(), bcrVar, bcuVar);
            this.a.f();
        }
        return bcpVar;
    }

    public final void a() {
        synchronized (this.d) {
            if (this.a == null) {
                return;
            }
            this.a.i();
            this.a = null;
            Binder.flushPendingCommands();
        }
    }

    static /* synthetic */ boolean a(zztl zztlVar, boolean z) {
        zztlVar.b = true;
        return true;
    }
}
