package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.c;
import androidx.work.d;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.b.j;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
class a {
    private static final String a = h.a("SystemJobInfoConverter");
    private final ComponentName b;

    a(Context context) {
        this.b = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    JobInfo a(j jVar, int i) {
        c cVar = jVar.j;
        int a2 = a(cVar.a());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", jVar.a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", jVar.a());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.b).setRequiredNetworkType(a2).setRequiresCharging(cVar.b()).setRequiresDeviceIdle(cVar.c()).setExtras(persistableBundle);
        if (!cVar.c()) {
            extras.setBackoffCriteria(jVar.m, jVar.l == androidx.work.a.LINEAR ? 0 : 1);
        }
        extras.setMinimumLatency(Math.max(jVar.c() - System.currentTimeMillis(), 0L));
        if (Build.VERSION.SDK_INT >= 24 && cVar.i()) {
            Iterator<d.a> it = cVar.h().a().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(a(it.next()));
            }
            extras.setTriggerContentUpdateDelay(cVar.f());
            extras.setTriggerContentMaxDelay(cVar.g());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(cVar.d());
            extras.setRequiresStorageNotLow(cVar.e());
        }
        return extras.build();
    }

    private static JobInfo.TriggerContentUri a(d.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    static int a(i iVar) {
        switch (iVar) {
            case NOT_REQUIRED:
                return 0;
            case CONNECTED:
                return 1;
            case UNMETERED:
                return 2;
            case NOT_ROAMING:
                if (Build.VERSION.SDK_INT >= 24) {
                    return 3;
                }
                break;
            case METERED:
                if (Build.VERSION.SDK_INT >= 26) {
                    return 4;
                }
                break;
        }
        h.a().b(a, String.format("API version too low. Cannot convert network type value %s", iVar), new Throwable[0]);
        return 1;
    }
}
