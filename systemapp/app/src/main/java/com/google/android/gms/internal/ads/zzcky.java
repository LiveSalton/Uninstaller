package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzcky {
    protected final zzaze b;
    private final Executor d;
    private final boolean e;
    private final String c = zzacu.b.a();
    protected final Map<String, String> a = new HashMap();

    protected zzcky(Executor executor, zzaze zzazeVar) {
        this.d = executor;
        this.b = zzazeVar;
        this.e = ((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() ? ((Boolean) zzwq.e().a(zzabf.aX)).booleanValue() : ((double) zzwq.h().nextFloat()) <= zzacu.a.a().doubleValue();
    }

    protected abstract void b();

    public final void a(Map<String, String> map) {
        String b = b(map);
        if (this.e) {
            this.d.execute(new Runnable(this, b) { // from class: com.google.android.gms.internal.ads.uq
                private final zzcky a;
                private final String b;

                {
                    this.a = this;
                    this.b = b;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcky zzckyVar = this.a;
                    zzckyVar.b.a(this.b);
                }
            });
        }
        zzd.a(b);
    }

    protected final String b(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.c).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }
}
