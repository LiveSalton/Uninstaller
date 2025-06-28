package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdsi {
    private static volatile zzbw.zza.zzc d = zzbw.zza.zzc.UNKNOWN;
    private final Context a;
    private final Executor b;
    private final Task<zztx> c;

    static void a(zzbw.zza.zzc zzcVar) {
        d = zzcVar;
    }

    public static zzdsi a(Context context, Executor executor) {
        return new zzdsi(context, executor, Tasks.a(executor, new Callable(context) { // from class: com.google.android.gms.internal.ads.akf
            private final Context a;

            {
                this.a = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdsi.a(this.a);
            }
        }));
    }

    private zzdsi(Context context, Executor executor, Task<zztx> task) {
        this.a = context;
        this.b = executor;
        this.c = task;
    }

    public final Task<Boolean> a(int i, long j) {
        return a(i, j, null, null, null, null);
    }

    public final Task<Boolean> a(int i, long j, Exception exc) {
        return a(i, j, exc, null, null, null);
    }

    public final Task<Boolean> a(int i, long j, String str, Map<String, String> map) {
        return a(i, j, null, str, null, null);
    }

    public final Task<Boolean> a(int i, String str) {
        return a(i, 0L, null, null, null, str);
    }

    public final Task<Boolean> a(int i, long j, String str) {
        return a(i, j, null, null, null, str);
    }

    private final Task<Boolean> a(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.C0057zza a = zzbw.zza.a().a(this.a.getPackageName()).a(j);
        a.a(d);
        if (exc != null) {
            a.b(zzdwe.c(exc)).c(exc.getClass().getName());
        }
        if (str2 != null) {
            a.d(str2);
        }
        if (str != null) {
            a.e(str);
        }
        return this.c.a(this.b, new Continuation(a, i) { // from class: com.google.android.gms.internal.ads.akg
            private final zzbw.zza.C0057zza a;
            private final int b;

            {
                this.a = a;
                this.b = i;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task) {
                return zzdsi.a(this.a, this.b, task);
            }
        });
    }

    static final /* synthetic */ Boolean a(zzbw.zza.C0057zza c0057zza, int i, Task task) throws Exception {
        if (task.b()) {
            zzub a = ((zztx) task.d()).a(((zzbw.zza) ((zzekh) c0057zza.g())).l());
            a.b(i);
            a.a();
            return true;
        }
        return false;
    }

    static final /* synthetic */ zztx a(Context context) throws Exception {
        return new zztx(context, "GLAS", null);
    }
}
