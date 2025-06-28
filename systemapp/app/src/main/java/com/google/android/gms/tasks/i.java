package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class i<TResult> extends Task<TResult> {
    private final Object a = new Object();
    private final f<TResult> b = new f<>();

    @GuardedBy("mLock")
    private boolean c;
    private volatile boolean d;

    @GuardedBy("mLock")
    private TResult e;

    @GuardedBy("mLock")
    private Exception f;

    i() {
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean c() {
        return this.d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.d && this.f == null;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult d() {
        TResult tresult;
        synchronized (this.a) {
            g();
            i();
            if (this.f != null) {
                throw new RuntimeExecutionException(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception e() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Executor executor, OnFailureListener onFailureListener) {
        this.b.a(new e(zzv.a(executor), onFailureListener));
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> a(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        i iVar = new i();
        this.b.a(new b(zzv.a(executor), continuation, iVar));
        j();
        return iVar;
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            h();
            this.c = true;
            this.e = tresult;
        }
        this.b.a(this);
    }

    public final void a(Exception exc) {
        Preconditions.a(exc, "Exception must not be null");
        synchronized (this.a) {
            h();
            this.c = true;
            this.f = exc;
        }
        this.b.a(this);
    }

    public final boolean f() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = true;
            this.b.a(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    private final void g() {
        Preconditions.a(this.c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void h() {
        if (this.c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    @GuardedBy("mLock")
    private final void i() {
        if (this.d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void j() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }
}
