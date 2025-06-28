package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.h;
import androidx.work.impl.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class e implements androidx.work.impl.a {
    static final String a = h.a("SystemAlarmDispatcher");
    final Context b;
    final androidx.work.impl.background.systemalarm.b c;
    final List<Intent> d;
    Intent e;
    private final androidx.work.impl.utils.b.a f;
    private final g g;
    private final androidx.work.impl.c h;
    private final androidx.work.impl.h i;
    private final Handler j;
    private b k;

    /* compiled from: source */
    interface b {
        void a();
    }

    e(Context context) {
        this(context, null, null);
    }

    e(Context context, androidx.work.impl.c cVar, androidx.work.impl.h hVar) {
        this.b = context.getApplicationContext();
        this.c = new androidx.work.impl.background.systemalarm.b(this.b);
        this.g = new g();
        this.i = hVar == null ? androidx.work.impl.h.b(context) : hVar;
        this.h = cVar == null ? this.i.f() : cVar;
        this.f = this.i.g();
        this.h.a(this);
        this.d = new ArrayList();
        this.e = null;
        this.j = new Handler(Looper.getMainLooper());
    }

    void a() {
        h.a().b(a, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.h.b(this);
        this.g.a();
        this.k = null;
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        a(new a(this, androidx.work.impl.background.systemalarm.b.a(this.b, str, z), 0));
    }

    public boolean a(Intent intent, int i) {
        h.a().b(a, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        h();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            h.a().d(a, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && a("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.d) {
            boolean z = !this.d.isEmpty();
            this.d.add(intent);
            if (!z) {
                g();
            }
        }
        return true;
    }

    void a(b bVar) {
        if (this.k != null) {
            h.a().e(a, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.k = bVar;
        }
    }

    androidx.work.impl.c b() {
        return this.h;
    }

    g c() {
        return this.g;
    }

    androidx.work.impl.h d() {
        return this.i;
    }

    androidx.work.impl.utils.b.a e() {
        return this.f;
    }

    void a(Runnable runnable) {
        this.j.post(runnable);
    }

    void f() {
        h.a().b(a, "Checking if commands are complete.", new Throwable[0]);
        h();
        synchronized (this.d) {
            if (this.e != null) {
                h.a().b(a, String.format("Removing command %s", this.e), new Throwable[0]);
                if (!this.d.remove(0).equals(this.e)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.e = null;
            }
            if (!this.c.a() && this.d.isEmpty()) {
                h.a().b(a, "No more commands & intents.", new Throwable[0]);
                if (this.k != null) {
                    this.k.a();
                }
            } else if (!this.d.isEmpty()) {
                g();
            }
        }
    }

    private void g() {
        h();
        PowerManager.WakeLock a2 = i.a(this.b, "ProcessCommand");
        try {
            a2.acquire();
            this.i.g().a(new Runnable() { // from class: androidx.work.impl.background.systemalarm.e.1
                AnonymousClass1() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v12, types: [androidx.work.impl.background.systemalarm.e] */
                /* JADX WARN: Type inference failed for: r0v15 */
                /* JADX WARN: Type inference failed for: r0v16 */
                /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r0v9 */
                /* JADX WARN: Type inference failed for: r1v10, types: [androidx.work.h] */
                /* JADX WARN: Type inference failed for: r1v6, types: [androidx.work.h] */
                /* JADX WARN: Type inference failed for: r2v13, types: [androidx.work.impl.background.systemalarm.e] */
                /* JADX WARN: Type inference failed for: r2v9, types: [androidx.work.impl.background.systemalarm.e] */
                /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable[]] */
                /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Throwable[]] */
                /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object[]] */
                /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object[]] */
                /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
                /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
                /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object[]] */
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    c cVar;
                    synchronized (e.this.d) {
                        i = 0;
                        i = 0;
                        e.this.e = e.this.d.get(0);
                    }
                    if (e.this.e != null) {
                        ?? action = e.this.e.getAction();
                        int intExtra = e.this.e.getIntExtra("KEY_START_ID", 0);
                        int i2 = 2;
                        i2 = 2;
                        h.a().b(e.a, String.format("Processing command %s, %s", e.this.e, Integer.valueOf(intExtra)), new Throwable[0]);
                        PowerManager.WakeLock a3 = i.a(e.this.b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            try {
                                h.a().b(e.a, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, a3}), new Throwable[0]);
                                a3.acquire();
                                e.this.c.a(e.this.e, intExtra, e.this);
                                ?? r6 = {action, a3};
                                ?? r3 = new Throwable[0];
                                h.a().b(e.a, String.format("Releasing operation wake lock (%s) %s", r6), r3);
                                a3.release();
                                e eVar = e.this;
                                ?? r2 = e.this;
                                cVar = new c(r2);
                                action = eVar;
                                a3 = r2;
                                i = r3;
                                i2 = r6;
                            } catch (Throwable th) {
                                h.a().e(e.a, "Unexpected error in onHandleIntent", th);
                                ?? r62 = {action, a3};
                                ?? r32 = new Throwable[0];
                                h.a().b(e.a, String.format("Releasing operation wake lock (%s) %s", r62), r32);
                                a3.release();
                                e eVar2 = e.this;
                                ?? r22 = e.this;
                                cVar = new c(r22);
                                action = eVar2;
                                a3 = r22;
                                i = r32;
                                i2 = r62;
                            }
                            action.a(cVar);
                        } catch (Throwable th2) {
                            h a4 = h.a();
                            String str = e.a;
                            ?? r63 = new Object[i2];
                            r63[i] = action;
                            r63[1] = a3;
                            a4.b(str, String.format("Releasing operation wake lock (%s) %s", r63), new Throwable[i]);
                            a3.release();
                            e.this.a(new c(e.this));
                            throw th2;
                        }
                    }
                }
            });
        } finally {
            a2.release();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.background.systemalarm.e$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [androidx.work.impl.background.systemalarm.e] */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v10, types: [androidx.work.h] */
        /* JADX WARN: Type inference failed for: r1v6, types: [androidx.work.h] */
        /* JADX WARN: Type inference failed for: r2v13, types: [androidx.work.impl.background.systemalarm.e] */
        /* JADX WARN: Type inference failed for: r2v9, types: [androidx.work.impl.background.systemalarm.e] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable[]] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Throwable[]] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object[]] */
        @Override // java.lang.Runnable
        public void run() {
            int i;
            c cVar;
            synchronized (e.this.d) {
                i = 0;
                i = 0;
                e.this.e = e.this.d.get(0);
            }
            if (e.this.e != null) {
                ?? action = e.this.e.getAction();
                int intExtra = e.this.e.getIntExtra("KEY_START_ID", 0);
                int i2 = 2;
                i2 = 2;
                h.a().b(e.a, String.format("Processing command %s, %s", e.this.e, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock a3 = i.a(e.this.b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    try {
                        h.a().b(e.a, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, a3}), new Throwable[0]);
                        a3.acquire();
                        e.this.c.a(e.this.e, intExtra, e.this);
                        ?? r6 = {action, a3};
                        ?? r3 = new Throwable[0];
                        h.a().b(e.a, String.format("Releasing operation wake lock (%s) %s", r6), r3);
                        a3.release();
                        e eVar = e.this;
                        ?? r2 = e.this;
                        cVar = new c(r2);
                        action = eVar;
                        a3 = r2;
                        i = r3;
                        i2 = r6;
                    } catch (Throwable th) {
                        h.a().e(e.a, "Unexpected error in onHandleIntent", th);
                        ?? r62 = {action, a3};
                        ?? r32 = new Throwable[0];
                        h.a().b(e.a, String.format("Releasing operation wake lock (%s) %s", r62), r32);
                        a3.release();
                        e eVar2 = e.this;
                        ?? r22 = e.this;
                        cVar = new c(r22);
                        action = eVar2;
                        a3 = r22;
                        i = r32;
                        i2 = r62;
                    }
                    action.a(cVar);
                } catch (Throwable th2) {
                    h a4 = h.a();
                    String str = e.a;
                    ?? r63 = new Object[i2];
                    r63[i] = action;
                    r63[1] = a3;
                    a4.b(str, String.format("Releasing operation wake lock (%s) %s", r63), new Throwable[i]);
                    a3.release();
                    e.this.a(new c(e.this));
                    throw th2;
                }
            }
        }
    }

    private boolean a(String str) {
        h();
        synchronized (this.d) {
            Iterator<Intent> it = this.d.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void h() {
        if (this.j.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    /* compiled from: source */
    static class c implements Runnable {
        private final e a;

        c(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f();
        }
    }

    /* compiled from: source */
    static class a implements Runnable {
        private final e a;
        private final Intent b;
        private final int c;

        a(e eVar, Intent intent, int i) {
            this.a = eVar;
            this.b = intent;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }
}
