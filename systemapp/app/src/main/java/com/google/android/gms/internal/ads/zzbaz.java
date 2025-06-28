package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbaz {
    private long b;
    private final long a = TimeUnit.MILLISECONDS.toNanos(((Long) zzwq.e().a(zzabf.u)).longValue());
    private boolean c = true;

    zzbaz() {
    }

    public final void a() {
        this.c = true;
    }

    public final void a(SurfaceTexture surfaceTexture, zzbam zzbamVar) {
        if (zzbamVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.c || Math.abs(timestamp - this.b) >= this.a) {
            this.c = false;
            this.b = timestamp;
            com.google.android.gms.ads.internal.util.zzm.a.post(new gn(this, zzbamVar));
        }
    }
}
