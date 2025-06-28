package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import com.google.a.a.a.a;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {
    private static final String d = h.a("ConstraintTrkngWrkr");
    final Object a;
    volatile boolean b;
    androidx.work.impl.utils.a.c<ListenableWorker.a> c;
    private WorkerParameters e;
    private ListenableWorker f;

    @Override // androidx.work.impl.a.c
    public void a(List<String> list) {
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.e = workerParameters;
        this.a = new Object();
        this.b = false;
        this.c = androidx.work.impl.utils.a.c.d();
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.a();
        }
    }

    @Override // androidx.work.ListenableWorker
    public a<ListenableWorker.a> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ConstraintTrackingWorker.this.a();
            }
        });
        return this.c;
    }

    void a() {
        String a = getInputData().a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(a)) {
            h.a().e(d, "No worker to delegate to.", new Throwable[0]);
            b();
            return;
        }
        this.f = getWorkerFactory().b(getApplicationContext(), a, this.e);
        if (this.f == null) {
            h.a().b(d, "No worker to delegate to.", new Throwable[0]);
            b();
            return;
        }
        j b = d().o().b(getId().toString());
        if (b == null) {
            b();
            return;
        }
        d dVar = new d(getApplicationContext(), getTaskExecutor(), this);
        dVar.a(Collections.singletonList(b));
        if (dVar.a(getId().toString())) {
            h.a().b(d, String.format("Constraints met for delegate %s", a), new Throwable[0]);
            try {
                a<ListenableWorker.a> startWork = this.f.startWork();
                startWork.a(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.2
                    final /* synthetic */ a a;

                    AnonymousClass2(a startWork2) {
                        startWork = startWork2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ConstraintTrackingWorker.this.a) {
                            if (ConstraintTrackingWorker.this.b) {
                                ConstraintTrackingWorker.this.c();
                            } else {
                                ConstraintTrackingWorker.this.c.a(startWork);
                            }
                        }
                    }
                }, getBackgroundExecutor());
                return;
            } catch (Throwable th) {
                h.a().b(d, String.format("Delegated worker %s threw exception in startWork.", a), th);
                synchronized (this.a) {
                    if (this.b) {
                        h.a().b(d, "Constraints were unmet, Retrying.", new Throwable[0]);
                        c();
                    } else {
                        b();
                    }
                    return;
                }
            }
        }
        h.a().b(d, String.format("Constraints not met for delegate %s. Requesting retry.", a), new Throwable[0]);
        c();
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.workers.ConstraintTrackingWorker$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a a;

        AnonymousClass2(a startWork2) {
            startWork = startWork2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.a) {
                if (ConstraintTrackingWorker.this.b) {
                    ConstraintTrackingWorker.this.c();
                } else {
                    ConstraintTrackingWorker.this.c.a(startWork);
                }
            }
        }
    }

    void b() {
        this.c.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) ListenableWorker.a.c());
    }

    void c() {
        this.c.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) ListenableWorker.a.b());
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        if (this.f != null) {
            this.f.stop();
        }
    }

    public WorkDatabase d() {
        return androidx.work.impl.h.b(getApplicationContext()).c();
    }

    @Override // androidx.work.ListenableWorker
    public androidx.work.impl.utils.b.a getTaskExecutor() {
        return androidx.work.impl.h.b(getApplicationContext()).g();
    }

    @Override // androidx.work.impl.a.c
    public void b(List<String> list) {
        h.a().b(d, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.a) {
            this.b = true;
        }
    }
}
