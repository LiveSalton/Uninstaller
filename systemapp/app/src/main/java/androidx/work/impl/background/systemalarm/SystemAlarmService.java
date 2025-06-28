package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.h;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.utils.i;

/* compiled from: source */
/* loaded from: classes.dex */
public class SystemAlarmService extends LifecycleService implements e.b {
    private static final String a = h.a("SystemAlarmService");
    private e b;
    private boolean c;

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        c();
        this.c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.c = true;
        this.b.a();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.c) {
            h.a().c(a, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.b.a();
            c();
            this.c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.b.a(intent, i2);
        return 3;
    }

    @Override // androidx.work.impl.background.systemalarm.e.b
    public void a() {
        this.c = true;
        h.a().b(a, "All commands completed in dispatcher", new Throwable[0]);
        i.a();
        stopSelf();
    }

    private void c() {
        this.b = new e(this);
        this.b.a(this);
    }
}
