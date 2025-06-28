package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.n;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {
    private static final String a = androidx.work.h.a("ForceStopRunnable");
    private static final long b = TimeUnit.DAYS.toMillis(3650);
    private final Context c;
    private final androidx.work.impl.h d;

    public ForceStopRunnable(Context context, androidx.work.impl.h hVar) {
        this.c = context.getApplicationContext();
        this.d = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx.work.h.a().b(a, "Performing cleanup operations.", new Throwable[0]);
        boolean b2 = b();
        if (c()) {
            androidx.work.h.a().b(a, "Rescheduling Workers.", new Throwable[0]);
            this.d.i();
            this.d.h().a(false);
        } else if (a()) {
            androidx.work.h.a().b(a, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.d.i();
        } else if (b2) {
            androidx.work.h.a().b(a, "Found unfinished work, scheduling it.", new Throwable[0]);
            androidx.work.impl.e.a(this.d.d(), this.d.c(), this.d.e());
        }
        this.d.j();
    }

    public boolean a() {
        if (a(this.c, 536870912) != null) {
            return false;
        }
        b(this.c);
        return true;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b.b(this.c);
        }
        WorkDatabase c = this.d.c();
        k o = c.o();
        c.g();
        try {
            List<j> d = o.d();
            boolean z = (d == null || d.isEmpty()) ? false : true;
            if (z) {
                for (j jVar : d) {
                    o.a(n.a.ENQUEUED, jVar.a);
                    o.b(jVar.a, -1L);
                }
            }
            c.j();
            return z;
        } finally {
            c.h();
        }
    }

    boolean c() {
        return this.d.h().a();
    }

    private static PendingIntent a(Context context, int i) {
        return PendingIntent.getBroadcast(context, -1, a(context), i);
    }

    static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    static void b(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent a2 = a(context, 134217728);
        long currentTimeMillis = System.currentTimeMillis() + b;
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, a2);
            } else {
                alarmManager.set(0, currentTimeMillis, a2);
            }
        }
    }

    /* compiled from: source */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String a = androidx.work.h.a("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            androidx.work.h.a().a(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.b(context);
        }
    }
}
