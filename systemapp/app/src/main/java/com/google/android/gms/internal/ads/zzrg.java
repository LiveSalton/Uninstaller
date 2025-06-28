package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrg {
    private final Object a = new Object();

    @GuardedBy("activityTrackerLock")
    private bcd b = null;

    @GuardedBy("activityTrackerLock")
    private boolean c = false;

    public final void a(Context context) {
        synchronized (this.a) {
            if (!this.c) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzd.e("Can not cast Context to Application");
                    return;
                }
                if (this.b == null) {
                    this.b = new bcd();
                }
                this.b.a(application, context);
                this.c = true;
            }
        }
    }

    public final void a(zzrl zzrlVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new bcd();
            }
            this.b.a(zzrlVar);
        }
    }

    public final void b(zzrl zzrlVar) {
        synchronized (this.a) {
            if (this.b == null) {
                return;
            }
            this.b.b(zzrlVar);
        }
    }

    public final Activity a() {
        synchronized (this.a) {
            if (this.b == null) {
                return null;
            }
            return this.b.a();
        }
    }

    public final Context b() {
        synchronized (this.a) {
            if (this.b == null) {
                return null;
            }
            return this.b.b();
        }
    }
}
