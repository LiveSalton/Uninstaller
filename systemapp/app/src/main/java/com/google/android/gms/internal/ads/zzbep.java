package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbep extends zzyr {
    private final zzbbe a;
    private final boolean c;
    private final boolean d;

    @GuardedBy("lock")
    private int e;

    @GuardedBy("lock")
    private zzyt f;

    @GuardedBy("lock")
    private boolean g;

    @GuardedBy("lock")
    private float i;

    @GuardedBy("lock")
    private float j;

    @GuardedBy("lock")
    private float k;

    @GuardedBy("lock")
    private boolean l;

    @GuardedBy("lock")
    private boolean m;

    @GuardedBy("lock")
    private zzafv n;
    private final Object b = new Object();

    @GuardedBy("lock")
    private boolean h = true;

    public zzbep(zzbbe zzbbeVar, float f, boolean z, boolean z2) {
        this.a = zzbbeVar;
        this.i = f;
        this.c = z;
        this.d = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a() {
        a("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void b() {
        a("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void c() {
        a("stop", null);
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(boolean z) {
        a(z ? "mute" : "unmute", null);
    }

    public final void a(zzaak zzaakVar) {
        boolean z = zzaakVar.a;
        boolean z2 = zzaakVar.b;
        boolean z3 = zzaakVar.c;
        synchronized (this.b) {
            this.l = z2;
            this.m = z3;
        }
        a("initialState", CollectionUtils.a("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void a(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzazj.e.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.ix
            private final zzbep a;
            private final Map b;

            {
                this.a = this;
                this.b = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean d() {
        boolean z;
        synchronized (this.b) {
            z = this.h;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final int e() {
        int i;
        synchronized (this.b) {
            i = this.e;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float i() {
        float f;
        synchronized (this.b) {
            f = this.k;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float f() {
        float f;
        synchronized (this.b) {
            f = this.i;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float g() {
        float f;
        synchronized (this.b) {
            f = this.j;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(zzyt zzytVar) {
        synchronized (this.b) {
            this.f = zzytVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final zzyt h() throws RemoteException {
        zzyt zzytVar;
        synchronized (this.b) {
            zzytVar = this.f;
        }
        return zzytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean j() {
        boolean z;
        synchronized (this.b) {
            z = this.c && this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean k() {
        boolean z;
        boolean j = j();
        synchronized (this.b) {
            if (!j) {
                try {
                    z = this.m && this.d;
                } finally {
                }
            }
        }
        return z;
    }

    public final void a(float f) {
        synchronized (this.b) {
            this.j = f;
        }
    }

    public final void l() {
        boolean z;
        int i;
        synchronized (this.b) {
            z = this.h;
            i = this.e;
            this.e = 3;
        }
        b(i, 3, z, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x0013, B:12:0x0031, B:13:0x003a), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.b
            monitor-enter(r0)
            float r1 = r3.i     // Catch: java.lang.Throwable -> L51
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L12
            float r1 = r3.k     // Catch: java.lang.Throwable -> L51
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L10
            goto L12
        L10:
            r1 = 0
            goto L13
        L12:
            r1 = 1
        L13:
            r3.i = r5     // Catch: java.lang.Throwable -> L51
            r3.j = r4     // Catch: java.lang.Throwable -> L51
            boolean r4 = r3.h     // Catch: java.lang.Throwable -> L51
            r3.h = r7     // Catch: java.lang.Throwable -> L51
            int r5 = r3.e     // Catch: java.lang.Throwable -> L51
            r3.e = r6     // Catch: java.lang.Throwable -> L51
            float r2 = r3.k     // Catch: java.lang.Throwable -> L51
            r3.k = r8     // Catch: java.lang.Throwable -> L51
            float r8 = r3.k     // Catch: java.lang.Throwable -> L51
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch: java.lang.Throwable -> L51
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L3a
            com.google.android.gms.internal.ads.zzbbe r8 = r3.a     // Catch: java.lang.Throwable -> L51
            android.view.View r8 = r8.getView()     // Catch: java.lang.Throwable -> L51
            r8.invalidate()     // Catch: java.lang.Throwable -> L51
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L4d
            com.google.android.gms.internal.ads.zzafv r8 = r3.n     // Catch: android.os.RemoteException -> L47
            if (r8 == 0) goto L4d
            com.google.android.gms.internal.ads.zzafv r8 = r3.n     // Catch: android.os.RemoteException -> L47
            r8.a()     // Catch: android.os.RemoteException -> L47
            goto L4d
        L47:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzaza.e(r0, r8)
        L4d:
            r3.b(r5, r6, r4, r7)
            return
        L51:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L51
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbep.a(float, float, int, boolean, float):void");
    }

    public final void a(zzafv zzafvVar) {
        synchronized (this.b) {
            this.n = zzafvVar;
        }
    }

    private final void b(int i, int i2, boolean z, boolean z2) {
        zzazj.e.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.iy
            private final zzbep a;
            private final int b;
            private final int c;
            private final boolean d;
            private final boolean e;

            {
                this.a = this;
                this.b = i;
                this.c = i2;
                this.d = z;
                this.e = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b, this.c, this.d, this.e);
            }
        });
    }

    final /* synthetic */ void a(int i, int i2, boolean z, boolean z2) {
        synchronized (this.b) {
            boolean z3 = i != i2;
            boolean z4 = !this.g && i2 == 1;
            boolean z5 = z3 && i2 == 1;
            boolean z6 = z3 && i2 == 2;
            boolean z7 = z3 && i2 == 3;
            boolean z8 = z != z2;
            this.g = this.g || z4;
            if (z4) {
                try {
                    if (this.f != null) {
                        this.f.a();
                    }
                } catch (RemoteException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
            if (z5 && this.f != null) {
                this.f.b();
            }
            if (z6 && this.f != null) {
                this.f.c();
            }
            if (z7) {
                if (this.f != null) {
                    this.f.d();
                }
                this.a.p();
            }
            if (z8 && this.f != null) {
                this.f.a(z2);
            }
        }
    }

    final /* synthetic */ void a(Map map) {
        this.a.a("pubVideoCmd", (Map<String, ?>) map);
    }
}
