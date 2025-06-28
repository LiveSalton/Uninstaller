package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzals extends zzazx<zzako> {
    private com.google.android.gms.ads.internal.util.zzau<zzako> b;
    private final Object a = new Object();
    private boolean c = false;
    private int d = 0;

    public zzals(com.google.android.gms.ads.internal.util.zzau<zzako> zzauVar) {
        this.b = zzauVar;
    }

    public final zzalo a() {
        zzalo zzaloVar = new zzalo(this);
        synchronized (this.a) {
            a(new ch(this, zzaloVar), new cg(this, zzaloVar));
            Preconditions.a(this.d >= 0);
            this.d++;
        }
        return zzaloVar;
    }

    protected final void b() {
        synchronized (this.a) {
            Preconditions.a(this.d > 0);
            zzd.a("Releasing 1 reference for JS Engine");
            this.d--;
            f();
        }
    }

    public final void c() {
        synchronized (this.a) {
            Preconditions.a(this.d >= 0);
            zzd.a("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.c = true;
            f();
        }
    }

    private final void f() {
        synchronized (this.a) {
            Preconditions.a(this.d >= 0);
            if (this.c && this.d == 0) {
                zzd.a("No reference is left (including root). Cleaning up engine.");
                a(new cj(this), new zzazv());
            } else {
                zzd.a("There are still references to the engine. Not destroying.");
            }
        }
    }
}
