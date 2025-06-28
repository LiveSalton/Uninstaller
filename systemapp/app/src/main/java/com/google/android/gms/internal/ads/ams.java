package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class ams<I, O, F, T> extends ani<O> implements Runnable {

    @NullableDecl
    private zzdyz<? extends I> a;

    @NullableDecl
    private F b;

    static <I, O> zzdyz<O> a(zzdyz<I> zzdyzVar, zzdyb<? super I, ? extends O> zzdybVar, Executor executor) {
        zzdvv.a(executor);
        amu amuVar = new amu(zzdyzVar, zzdybVar);
        zzdyzVar.a(amuVar, zzdzb.a(executor, amuVar));
        return amuVar;
    }

    @NullableDecl
    abstract T a(F f, @NullableDecl I i) throws Exception;

    abstract void a(@NullableDecl T t);

    static <I, O> zzdyz<O> a(zzdyz<I> zzdyzVar, zzdvm<? super I, ? extends O> zzdvmVar, Executor executor) {
        zzdvv.a(zzdvmVar);
        amt amtVar = new amt(zzdyzVar, zzdvmVar);
        zzdyzVar.a(amtVar, zzdzb.a(executor, amtVar));
        return amtVar;
    }

    ams(zzdyz<? extends I> zzdyzVar, F f) {
        this.a = (zzdyz) zzdvv.a(zzdyzVar);
        this.b = (F) zzdvv.a(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzdyz<? extends I> zzdyzVar = this.a;
        F f = this.b;
        if ((isCancelled() | (zzdyzVar == null)) || (f == null)) {
            return;
        }
        this.a = null;
        if (zzdyzVar.isCancelled()) {
            a((zzdyz) zzdyzVar);
            return;
        }
        try {
            try {
                try {
                    Object a = a((ams<I, O, F, T>) f, (F) zzdyr.a((Future) zzdyzVar));
                    this.b = null;
                    a((ams<I, O, F, T>) a);
                } catch (Throwable th) {
                    a(th);
                    this.b = null;
                }
            } catch (Throwable th2) {
                this.b = null;
                throw th2;
            }
        } catch (Error e) {
            a((Throwable) e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            a((Throwable) e2);
        } catch (ExecutionException e3) {
            a(e3.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final void b() {
        a((Future<?>) this.a);
        this.a = null;
        this.b = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final String a() {
        zzdyz<? extends I> zzdyzVar = this.a;
        F f = this.b;
        String a = super.a();
        String str = "";
        if (zzdyzVar != null) {
            String valueOf = String.valueOf(zzdyzVar);
            StringBuilder sb = new StringBuilder(16 + String.valueOf(valueOf).length());
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        }
        if (f == null) {
            if (a == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(a);
            return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
        }
        String valueOf4 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(11 + String.valueOf(str).length() + String.valueOf(valueOf4).length());
        sb2.append(str);
        sb2.append("function=[");
        sb2.append(valueOf4);
        sb2.append("]");
        return sb2.toString();
    }
}
