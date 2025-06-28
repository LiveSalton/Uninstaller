package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzik {
    private final Handler a;
    private final zzih b;

    public zzik(Handler handler, zzih zzihVar) {
        this.a = zzihVar != null ? (Handler) zzpc.a(handler) : null;
        this.b = zzihVar;
    }

    public final void a(zzjm zzjmVar) {
        if (this.b != null) {
            this.a.post(new ayd(this, zzjmVar));
        }
    }

    public final void a(String str, long j, long j2) {
        if (this.b != null) {
            this.a.post(new ayf(this, str, j, j2));
        }
    }

    public final void a(zzhp zzhpVar) {
        if (this.b != null) {
            this.a.post(new aye(this, zzhpVar));
        }
    }

    public final void a(int i, long j, long j2) {
        if (this.b != null) {
            this.a.post(new ayh(this, i, j, j2));
        }
    }

    public final void b(zzjm zzjmVar) {
        if (this.b != null) {
            this.a.post(new ayg(this, zzjmVar));
        }
    }

    public final void a(int i) {
        if (this.b != null) {
            this.a.post(new ayi(this, i));
        }
    }
}
