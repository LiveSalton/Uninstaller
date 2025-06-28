package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.WorkerParameters;
import androidx.work.b;
import androidx.work.h;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.k;
import androidx.work.l;
import androidx.work.o;
import androidx.work.p;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class h extends o {
    private static h j;
    private static h k;
    private static final Object l = new Object();
    private Context a;
    private androidx.work.b b;
    private WorkDatabase c;
    private androidx.work.impl.utils.b.a d;
    private List<d> e;
    private c f;
    private androidx.work.impl.utils.e g;
    private boolean h;
    private BroadcastReceiver.PendingResult i;

    @Deprecated
    public static h a() {
        synchronized (l) {
            if (j != null) {
                return j;
            }
            return k;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static h b(Context context) {
        h a;
        synchronized (l) {
            a = a();
            if (a == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof b.InterfaceC0051b) {
                    b(applicationContext, ((b.InterfaceC0051b) applicationContext).a());
                    a = b(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return a;
    }

    public static void b(Context context, androidx.work.b bVar) {
        synchronized (l) {
            if (j != null && k != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class levelJavadoc for more information.");
            }
            if (j == null) {
                Context applicationContext = context.getApplicationContext();
                if (k == null) {
                    k = new h(applicationContext, bVar, new androidx.work.impl.utils.b.b(bVar.b()));
                }
                j = k;
            }
        }
    }

    public h(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar) {
        this(context, bVar, aVar, context.getResources().getBoolean(l.a.workmanager_test_configuration));
    }

    public h(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, boolean z) {
        Context applicationContext = context.getApplicationContext();
        WorkDatabase a = WorkDatabase.a(applicationContext, bVar.b(), z);
        androidx.work.h.a(new h.a(bVar.d()));
        List<d> a2 = a(applicationContext, aVar);
        a(context, bVar, aVar, a, a2, new c(context, bVar, aVar, a, a2));
    }

    public Context b() {
        return this.a;
    }

    public WorkDatabase c() {
        return this.c;
    }

    public androidx.work.b d() {
        return this.b;
    }

    public List<d> e() {
        return this.e;
    }

    public c f() {
        return this.f;
    }

    public androidx.work.impl.utils.b.a g() {
        return this.d;
    }

    public androidx.work.impl.utils.e h() {
        return this.g;
    }

    @Override // androidx.work.o
    public k a(List<? extends p> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new f(this, list).i();
    }

    @Override // androidx.work.o
    public k a(String str) {
        androidx.work.impl.utils.a a = androidx.work.impl.utils.a.a(str, this);
        this.d.a(a);
        return a.a();
    }

    public void b(String str) {
        a(str, (WorkerParameters.a) null);
    }

    public void a(String str, WorkerParameters.a aVar) {
        this.d.a(new androidx.work.impl.utils.g(this, str, aVar));
    }

    public void c(String str) {
        this.d.a(new androidx.work.impl.utils.h(this, str));
    }

    public void i() {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.a(b());
        }
        c().o().b();
        e.a(d(), c(), e());
    }

    public void j() {
        synchronized (l) {
            this.h = true;
            if (this.i != null) {
                this.i.finish();
                this.i = null;
            }
        }
    }

    public void a(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (l) {
            this.i = pendingResult;
            if (this.h) {
                this.i.finish();
                this.i = null;
            }
        }
    }

    private void a(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, List<d> list, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = bVar;
        this.d = aVar;
        this.c = workDatabase;
        this.e = list;
        this.f = cVar;
        this.g = new androidx.work.impl.utils.e(this.a);
        this.h = false;
        this.d.a(new ForceStopRunnable(applicationContext, this));
    }

    public List<d> a(Context context, androidx.work.impl.utils.b.a aVar) {
        return Arrays.asList(e.a(context, this), new androidx.work.impl.background.a.a(context, aVar, this));
    }
}
