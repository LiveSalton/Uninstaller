package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnk extends zzbme {
    private final zzagd c;
    private final Runnable d;
    private final Executor e;

    public zzbnk(zzbob zzbobVar, zzagd zzagdVar, Runnable runnable, Executor executor) {
        super(zzbobVar);
        this.c = zzagdVar;
        this.d = runnable;
        this.e = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final View a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void a(ViewGroup viewGroup, zzvn zzvnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzys c() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzdmx d() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzdmx e() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void d_() {
        this.e.execute(new Runnable(this, new Runnable(new AtomicReference(this.d)) { // from class: com.google.android.gms.internal.ads.lx
            private final AtomicReference a;

            {
                this.a = atomicReference;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = (Runnable) this.a.getAndSet(null);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }) { // from class: com.google.android.gms.internal.ads.ly
            private final zzbnk a;
            private final Runnable b;

            {
                this.a = this;
                this.b = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        });
    }

    final /* synthetic */ void a(Runnable runnable) {
        try {
            if (this.c.a(ObjectWrapper.a(runnable))) {
                return;
            }
            runnable.run();
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
