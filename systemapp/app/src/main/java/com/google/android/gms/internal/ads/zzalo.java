package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzalo extends zzazx<zzalz> {
    private final Object a = new Object();
    private final zzals b;
    private boolean c;

    public zzalo(zzals zzalsVar) {
        this.b = zzalsVar;
    }

    public final void a() {
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            this.c = true;
            a(new ce(this), new zzazv());
            a(new cd(this), new cf(this));
        }
    }
}
