package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.d;
import androidx.work.impl.utils.c;
import androidx.work.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public class b implements d {
    private static final String a = h.a("SystemJobScheduler");
    private final Context b;
    private final JobScheduler c;
    private final androidx.work.impl.h d;
    private final c e;
    private final a f;

    public b(Context context, androidx.work.impl.h hVar) {
        this(context, hVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public b(Context context, androidx.work.impl.h hVar, JobScheduler jobScheduler, a aVar) {
        this.b = context;
        this.d = hVar;
        this.c = jobScheduler;
        this.e = new c(context);
        this.f = aVar;
    }

    @Override // androidx.work.impl.d
    public void a(j... jVarArr) {
        List<Integer> a2;
        int a3;
        WorkDatabase c = this.d.c();
        for (j jVar : jVarArr) {
            c.g();
            try {
                j b = c.o().b(jVar.a);
                if (b == null) {
                    h.a().d(a, "Skipping scheduling " + jVar.a + " because it's no longer in the DB", new Throwable[0]);
                    c.j();
                } else if (b.b != n.a.ENQUEUED) {
                    h.a().d(a, "Skipping scheduling " + jVar.a + " because it is no longer enqueued", new Throwable[0]);
                    c.j();
                } else {
                    androidx.work.impl.b.d a4 = c.r().a(jVar.a);
                    int a5 = a4 != null ? a4.b : this.e.a(this.d.d().e(), this.d.d().f());
                    if (a4 == null) {
                        this.d.c().r().a(new androidx.work.impl.b.d(jVar.a, a5));
                    }
                    a(jVar, a5);
                    if (Build.VERSION.SDK_INT == 23 && (a2 = a(this.b, this.c, jVar.a)) != null) {
                        int indexOf = a2.indexOf(Integer.valueOf(a5));
                        if (indexOf >= 0) {
                            a2.remove(indexOf);
                        }
                        if (!a2.isEmpty()) {
                            a3 = a2.get(0).intValue();
                        } else {
                            a3 = this.e.a(this.d.d().e(), this.d.d().f());
                        }
                        a(jVar, a3);
                    }
                    c.j();
                }
            } finally {
                c.h();
            }
        }
    }

    public void a(j jVar, int i) {
        JobInfo a2 = this.f.a(jVar, i);
        h.a().b(a, String.format("Scheduling work ID %s Job ID %s", jVar.a, Integer.valueOf(i)), new Throwable[0]);
        try {
            this.c.schedule(a2);
        } catch (IllegalStateException e) {
            List<JobInfo> a3 = a(this.b, this.c);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(a3 != null ? a3.size() : 0), Integer.valueOf(this.d.c().o().c().size()), Integer.valueOf(this.d.d().g()));
            h.a().e(a, format, new Throwable[0]);
            throw new IllegalStateException(format, e);
        } catch (Throwable th) {
            h.a().e(a, String.format("Unable to schedule %s", jVar), th);
        }
    }

    @Override // androidx.work.impl.d
    public void a(String str) {
        List<Integer> a2 = a(this.b, this.c, str);
        if (a2 == null || a2.isEmpty()) {
            return;
        }
        Iterator<Integer> it = a2.iterator();
        while (it.hasNext()) {
            a(this.c, it.next().intValue());
        }
        this.d.c().r().b(str);
    }

    private static void a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            h.a().e(a, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static void a(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (a2 = a(context, jobScheduler)) == null || a2.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = a2.iterator();
        while (it.hasNext()) {
            a(jobScheduler, it.next().getId());
        }
    }

    public static void b(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (a2 = a(context, jobScheduler)) == null || a2.isEmpty()) {
            return;
        }
        for (JobInfo jobInfo : a2) {
            PersistableBundle extras = jobInfo.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                a(jobScheduler, jobInfo.getId());
            }
        }
    }

    private static List<JobInfo> a(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            h.a().e(a, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static List<Integer> a(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> a2 = a(context, jobScheduler);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : a2) {
            PersistableBundle extras = jobInfo.getExtras();
            if (extras != null && extras.containsKey("EXTRA_WORK_SPEC_ID") && str.equals(extras.getString("EXTRA_WORK_SPEC_ID"))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }
}
