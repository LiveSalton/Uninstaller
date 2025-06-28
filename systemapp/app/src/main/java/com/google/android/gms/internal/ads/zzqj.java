package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzqj {
    private final Handler a;
    private final zzqg b;

    public zzqj(Handler handler, zzqg zzqgVar) {
        this.a = zzqgVar != null ? (Handler) zzpc.a(handler) : null;
        this.b = zzqgVar;
    }

    public final void a(zzjm zzjmVar) {
        if (this.b != null) {
            this.a.post(new bbl(this, zzjmVar));
        }
    }

    public final void a(String str, long j, long j2) {
        if (this.b != null) {
            this.a.post(new bbn(this, str, j, j2));
        }
    }

    public final void a(zzhp zzhpVar) {
        if (this.b != null) {
            this.a.post(new bbm(this, zzhpVar));
        }
    }

    public final void a(int i, long j) {
        if (this.b != null) {
            this.a.post(new bbp(this, i, j));
        }
    }

    public final void a(int i, int i2, int i3, float f) {
        if (this.b != null) {
            this.a.post(new bbo(this, i, i2, i3, f));
        }
    }

    public final void a(Surface surface) {
        if (this.b != null) {
            this.a.post(new bbr(this, surface));
        }
    }

    public final void b(zzjm zzjmVar) {
        if (this.b != null) {
            this.a.post(new bbq(this, zzjmVar));
        }
    }
}
