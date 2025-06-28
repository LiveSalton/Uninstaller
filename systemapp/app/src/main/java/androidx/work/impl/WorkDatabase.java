package androidx.work.impl;

import android.content.Context;
import androidx.room.i;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.g;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class WorkDatabase extends androidx.room.i {
    private static final long d = TimeUnit.DAYS.toMillis(7);

    public abstract k o();

    public abstract androidx.work.impl.b.b p();

    public abstract n q();

    public abstract androidx.work.impl.b.e r();

    public abstract androidx.work.impl.b.h s();

    public static WorkDatabase a(Context context, Executor executor, boolean z) {
        i.a a;
        if (z) {
            a = androidx.room.h.a(context, WorkDatabase.class).a();
        } else {
            a = androidx.room.h.a(context, WorkDatabase.class, "androidx.work.workdb").a(executor);
        }
        return (WorkDatabase) a.a(l()).a(g.a).a(new g.a(context, 2, 3)).a(g.b).a(g.c).a(new g.a(context, 5, 6)).b().c();
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.WorkDatabase$1 */
    static class AnonymousClass1 extends i.b {
        AnonymousClass1() {
        }

        @Override // androidx.room.i.b
        public void b(androidx.g.a.b bVar) {
            super.b(bVar);
            bVar.a();
            try {
                bVar.c(WorkDatabase.m());
                bVar.c();
            } finally {
                bVar.b();
            }
        }
    }

    static i.b l() {
        return new i.b() { // from class: androidx.work.impl.WorkDatabase.1
            AnonymousClass1() {
            }

            @Override // androidx.room.i.b
            public void b(androidx.g.a.b bVar) {
                super.b(bVar);
                bVar.a();
                try {
                    bVar.c(WorkDatabase.m());
                    bVar.c();
                } finally {
                    bVar.b();
                }
            }
        };
    }

    static String m() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + n() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    static long n() {
        return System.currentTimeMillis() - d;
    }
}
