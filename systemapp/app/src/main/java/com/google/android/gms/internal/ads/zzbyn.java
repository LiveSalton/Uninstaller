package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyn extends zzbwk<VideoController.VideoLifecycleCallbacks> {

    @GuardedBy("this")
    private boolean a;

    protected zzbyn(Set<zzbxy<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void a() {
        a(pz.a);
    }

    public final void b() {
        a(py.a);
    }

    public final synchronized void c() {
        a(qb.a);
        this.a = true;
    }

    public final synchronized void d() {
        if (!this.a) {
            a(qa.a);
            this.a = true;
        }
        a(qc.a);
    }
}
