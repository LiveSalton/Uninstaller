package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    private static final String a = androidx.work.h.a("Schedulers");

    public static void a(androidx.work.b bVar, WorkDatabase workDatabase, List<d> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        k o = workDatabase.o();
        workDatabase.g();
        try {
            List<j> a2 = o.a(bVar.g());
            if (a2 != null && a2.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<j> it = a2.iterator();
                while (it.hasNext()) {
                    o.b(it.next().a, currentTimeMillis);
                }
            }
            workDatabase.j();
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            j[] jVarArr = (j[]) a2.toArray(new j[0]);
            Iterator<d> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().a(jVarArr);
            }
        } finally {
            workDatabase.h();
        }
    }

    static d a(Context context, h hVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b bVar = new androidx.work.impl.background.systemjob.b(context, hVar);
            androidx.work.impl.utils.d.a(context, SystemJobService.class, true);
            androidx.work.h.a().b(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        d a2 = a(context);
        if (a2 != null) {
            return a2;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        androidx.work.impl.utils.d.a(context, SystemAlarmService.class, true);
        androidx.work.h.a().b(a, "Created SystemAlarmScheduler", new Throwable[0]);
        return fVar;
    }

    private static d a(Context context) {
        try {
            d dVar = (d) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            androidx.work.h.a().b(a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return dVar;
        } catch (Throwable th) {
            androidx.work.h.a().b(a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
