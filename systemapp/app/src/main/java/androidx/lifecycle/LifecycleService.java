package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: source */
/* loaded from: classes.dex */
public class LifecycleService extends Service implements j {
    private final u a = new u(this);

    @Override // android.app.Service
    public void onCreate() {
        this.a.a();
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.a.b();
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        this.a.c();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.a.d();
        super.onDestroy();
    }

    @Override // androidx.lifecycle.j
    public f b() {
        return this.a.e();
    }
}
