package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class amw<InputT, OutputT> extends amz<OutputT> {
    private static final Logger a = Logger.getLogger(amw.class.getName());

    @NullableDecl
    private zzdwl<? extends zzdyz<? extends InputT>> b;
    private final boolean c;
    private final boolean d;

    /* compiled from: source */
    enum a {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    amw(zzdwl<? extends zzdyz<? extends InputT>> zzdwlVar, boolean z, boolean z2) {
        super(zzdwlVar.size());
        this.b = (zzdwl) zzdvv.a(zzdwlVar);
        this.c = z;
        this.d = z2;
    }

    abstract void a(int i, @NullableDecl InputT inputt);

    abstract void i();

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final void b() {
        super.b();
        zzdwl<? extends zzdyz<? extends InputT>> zzdwlVar = this.b;
        a(a.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdwlVar != null)) {
            boolean d = d();
            zzdxh zzdxhVar = (zzdxh) zzdwlVar.iterator();
            while (zzdxhVar.hasNext()) {
                ((Future) zzdxhVar.next()).cancel(d);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final String a() {
        zzdwl<? extends zzdyz<? extends InputT>> zzdwlVar = this.b;
        if (zzdwlVar != null) {
            String valueOf = String.valueOf(zzdwlVar);
            StringBuilder sb = new StringBuilder(8 + String.valueOf(valueOf).length());
            sb.append("futures=");
            sb.append(valueOf);
            return sb.toString();
        }
        return super.a();
    }

    final void h() {
        if (this.b.isEmpty()) {
            i();
            return;
        }
        if (this.c) {
            int i = 0;
            zzdxh zzdxhVar = (zzdxh) this.b.iterator();
            while (zzdxhVar.hasNext()) {
                zzdyz zzdyzVar = (zzdyz) zzdxhVar.next();
                zzdyzVar.a(new amv(this, zzdyzVar, i), anf.INSTANCE);
                i++;
            }
            return;
        }
        amx amxVar = new amx(this, this.d ? this.b : null);
        zzdxh zzdxhVar2 = (zzdxh) this.b.iterator();
        while (zzdxhVar2.hasNext()) {
            ((zzdyz) zzdxhVar2.next()).a(amxVar, anf.INSTANCE);
        }
    }

    private final void b(Throwable th) {
        zzdvv.a(th);
        if (this.c && !a(th) && a(j(), th)) {
            c(th);
        } else if (th instanceof Error) {
            c(th);
        }
    }

    private static void c(Throwable th) {
        a.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // com.google.android.gms.internal.ads.amz
    final void a(Set<Throwable> set) {
        zzdvv.a(set);
        if (isCancelled()) {
            return;
        }
        a(set, e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i, Future<? extends InputT> future) {
        try {
            a(i, (int) zzdyr.a((Future) future));
        } catch (ExecutionException e) {
            b(e.getCause());
        } catch (Throwable th) {
            b(th);
        }
    }

    public final void a(@NullableDecl zzdwl<? extends Future<? extends InputT>> zzdwlVar) {
        int k = k();
        int i = 0;
        if (!(k >= 0)) {
            throw new IllegalStateException(String.valueOf("Less than 0 remaining futures"));
        }
        if (k == 0) {
            if (zzdwlVar != null) {
                zzdxh zzdxhVar = (zzdxh) zzdwlVar.iterator();
                while (zzdxhVar.hasNext()) {
                    Future<? extends InputT> future = (Future) zzdxhVar.next();
                    if (!future.isCancelled()) {
                        a(i, (Future) future);
                    }
                    i++;
                }
            }
            l();
            i();
            a(a.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    void a(a aVar) {
        zzdvv.a(aVar);
        this.b = null;
    }

    private static boolean a(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    static /* synthetic */ zzdwl a(amw amwVar, zzdwl zzdwlVar) {
        amwVar.b = null;
        return null;
    }
}
