package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaal;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzys;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class VideoController {
    private final Object a = new Object();

    @GuardedBy("lock")
    private zzys b;

    @GuardedBy("lock")
    private VideoLifecycleCallbacks c;

    /* compiled from: source */
    public static abstract class VideoLifecycleCallbacks {
        public void a() {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public final void a(zzys zzysVar) {
        synchronized (this.a) {
            this.b = zzysVar;
            if (this.c != null) {
                a(this.c);
            }
        }
    }

    public final zzys a() {
        zzys zzysVar;
        synchronized (this.a) {
            zzysVar = this.b;
        }
        return zzysVar;
    }

    public final void a(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.a(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.a) {
            this.c = videoLifecycleCallbacks;
            if (this.b == null) {
                return;
            }
            try {
                this.b.a(new zzaal(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzaza.c("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.b != null;
        }
        return z;
    }
}
