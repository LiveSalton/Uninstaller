package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdsv {
    private final Context a;
    private final Executor b;
    private final zzdsi c;
    private final zzdsj d;
    private final akr e;
    private final akr f;
    private Task<zzcf.zza> g;
    private Task<zzcf.zza> h;

    @VisibleForTesting
    private zzdsv(Context context, Executor executor, zzdsi zzdsiVar, zzdsj zzdsjVar, akp akpVar, aks aksVar) {
        this.a = context;
        this.b = executor;
        this.c = zzdsiVar;
        this.d = zzdsjVar;
        this.e = akpVar;
        this.f = aksVar;
    }

    public static zzdsv a(Context context, Executor executor, zzdsi zzdsiVar, zzdsj zzdsjVar) {
        zzdsv zzdsvVar = new zzdsv(context, executor, zzdsiVar, zzdsjVar, new akp(), new aks());
        if (zzdsvVar.d.b()) {
            zzdsvVar.g = zzdsvVar.a(new Callable(zzdsvVar) { // from class: com.google.android.gms.internal.ads.ako
                private final zzdsv a;

                {
                    this.a = zzdsvVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.d();
                }
            });
        } else {
            zzdsvVar.g = Tasks.a(zzdsvVar.e.a());
        }
        zzdsvVar.h = zzdsvVar.a(new Callable(zzdsvVar) { // from class: com.google.android.gms.internal.ads.akn
            private final zzdsv a;

            {
                this.a = zzdsvVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.c();
            }
        });
        return zzdsvVar;
    }

    public final zzcf.zza a() {
        return a(this.g, this.e.a());
    }

    public final zzcf.zza b() {
        return a(this.h, this.f.a());
    }

    private final Task<zzcf.zza> a(Callable<zzcf.zza> callable) {
        return Tasks.a(this.b, callable).a(this.b, new OnFailureListener(this) { // from class: com.google.android.gms.internal.ads.akq
            private final zzdsv a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void a(Exception exc) {
                this.a.a(exc);
            }
        });
    }

    private static zzcf.zza a(Task<zzcf.zza> task, zzcf.zza zzaVar) {
        return !task.b() ? zzaVar : task.d();
    }

    final /* synthetic */ void a(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.c.a(2025, -1L, exc);
    }

    final /* synthetic */ zzcf.zza c() throws Exception {
        return this.f.a(this.a);
    }

    final /* synthetic */ zzcf.zza d() throws Exception {
        return this.e.a(this.a);
    }
}
