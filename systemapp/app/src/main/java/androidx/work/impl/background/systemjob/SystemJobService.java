package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import androidx.work.h;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements androidx.work.impl.a {
    private static final String a = h.a("SystemJobService");
    private androidx.work.impl.h b;
    private final Map<String, JobParameters> c = new HashMap();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            this.b = androidx.work.impl.h.b(getApplicationContext());
            this.b.f().a(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            h.a().d(a, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.f().b(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.b == null) {
            h.a().b(a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        PersistableBundle extras = jobParameters.getExtras();
        if (extras == null) {
            h.a().e(a, "No extras in JobParameters.", new Throwable[0]);
            return false;
        }
        String string = extras.getString("EXTRA_WORK_SPEC_ID");
        if (TextUtils.isEmpty(string)) {
            h.a().e(a, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.c) {
            if (this.c.containsKey(string)) {
                h.a().b(a, String.format("Job is already being executed by SystemJobService: %s", string), new Throwable[0]);
                return false;
            }
            h.a().b(a, String.format("onStartJob for %s", string), new Throwable[0]);
            this.c.put(string, jobParameters);
            WorkerParameters.a aVar = null;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar = new WorkerParameters.a();
                if (jobParameters.getTriggeredContentUris() != null) {
                    aVar.b = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    aVar.a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.c = jobParameters.getNetwork();
                }
            }
            this.b.a(string, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.b == null) {
            h.a().b(a, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        PersistableBundle extras = jobParameters.getExtras();
        if (extras == null) {
            h.a().e(a, "No extras in JobParameters.", new Throwable[0]);
            return false;
        }
        String string = extras.getString("EXTRA_WORK_SPEC_ID");
        if (TextUtils.isEmpty(string)) {
            h.a().e(a, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        h.a().b(a, String.format("onStopJob for %s", string), new Throwable[0]);
        synchronized (this.c) {
            this.c.remove(string);
        }
        this.b.c(string);
        return !this.b.f().d(string);
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        JobParameters remove;
        h.a().b(a, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.c) {
            remove = this.c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }
}
