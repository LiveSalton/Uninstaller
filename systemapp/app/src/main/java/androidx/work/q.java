package androidx.work;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class q {
    private static final String a = h.a("WorkerFactory");

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        ListenableWorker a2 = a(context, str, workerParameters);
        if (a2 != null) {
            return a2;
        }
        try {
            try {
                return (ListenableWorker) Class.forName(str).asSubclass(ListenableWorker.class).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Exception e) {
                h.a().e(a, "Could not instantiate " + str, e);
                return null;
            }
        } catch (ClassNotFoundException unused) {
            h.a().e(a, "Class not found: " + str, new Throwable[0]);
            return null;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.q$1 */
    static class AnonymousClass1 extends q {
        @Override // androidx.work.q
        public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
            return null;
        }

        AnonymousClass1() {
        }
    }

    public static q a() {
        return new q() { // from class: androidx.work.q.1
            @Override // androidx.work.q
            public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }

            AnonymousClass1() {
            }
        };
    }
}
