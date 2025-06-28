package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class b implements androidx.work.impl.a {
    private static final String a = h.a("CommandHandler");
    private final Context b;
    private final Map<String, androidx.work.impl.a> c = new HashMap();
    private final Object d = new Object();

    static Intent a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent c(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent b(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    b(Context context) {
        this.b = context;
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        synchronized (this.d) {
            androidx.work.impl.a remove = this.c.remove(str);
            if (remove != null) {
                remove.a(str, z);
            }
        }
    }

    boolean a() {
        boolean z;
        synchronized (this.d) {
            z = !this.c.isEmpty();
        }
        return z;
    }

    void a(Intent intent, int i, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            e(intent, i, eVar);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            f(intent, i, eVar);
            return;
        }
        if (!a(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            h.a().e(a, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            b(intent, i, eVar);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            c(intent, i, eVar);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            d(intent, i, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            g(intent, i, eVar);
        } else {
            h.a().d(a, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }

    private void b(Intent intent, int i, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h.a().b(a, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase c = eVar.d().c();
        c.g();
        try {
            j b = c.o().b(string);
            if (b == null) {
                h.a().d(a, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (b.b.a()) {
                h.a().d(a, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long c2 = b.c();
            if (!b.d()) {
                h.a().b(a, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(c2)), new Throwable[0]);
                a.a(this.b, eVar.d(), string, c2);
            } else {
                h.a().b(a, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(c2)), new Throwable[0]);
                a.a(this.b, eVar.d(), string, c2);
                eVar.a(new e.a(eVar, a(this.b), i));
            }
            c.j();
        } finally {
            c.h();
        }
    }

    private void c(Intent intent, int i, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.d) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            h.a().b(a, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.c.containsKey(string)) {
                d dVar = new d(this.b, i, string, eVar);
                this.c.put(string, dVar);
                dVar.a();
            } else {
                h.a().b(a, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }

    private void d(Intent intent, int i, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        h.a().b(a, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        eVar.d().c(string);
        a.a(this.b, eVar.d(), string);
        eVar.a(string, false);
    }

    private void e(Intent intent, int i, e eVar) {
        h.a().b(a, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.b, i, eVar).a();
    }

    private void f(Intent intent, int i, e eVar) {
        h.a().b(a, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
        eVar.d().i();
    }

    private void g(Intent intent, int i, e eVar) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        h.a().b(a, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i)), new Throwable[0]);
        a(string, z);
    }

    private static boolean a(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }
}
