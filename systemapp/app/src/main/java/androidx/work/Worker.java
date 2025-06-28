package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    androidx.work.impl.utils.a.c<ListenableWorker.a> a;

    public abstract ListenableWorker.a doWork();

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* compiled from: source */
    /* renamed from: androidx.work.Worker$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.a.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) Worker.this.doWork());
            } catch (Throwable th) {
                Worker.this.a.a(th);
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public final com.google.a.a.a.a<ListenableWorker.a> startWork() {
        this.a = androidx.work.impl.utils.a.c.d();
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.Worker.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Worker.this.a.a((androidx.work.impl.utils.a.c<ListenableWorker.a>) Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.a.a(th);
                }
            }
        });
        return this.a;
    }
}
