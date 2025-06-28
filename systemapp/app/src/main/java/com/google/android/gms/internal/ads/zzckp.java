package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckp {
    private final Map<String, String> a = new ConcurrentHashMap();
    private final /* synthetic */ zzckq b;

    @VisibleForTesting
    zzckp(zzckq zzckqVar) {
        this.b = zzckqVar;
    }

    public final zzckp d() {
        this.a.putAll(this.b.c);
        return this;
    }

    public final zzckp a(zzdmz zzdmzVar) {
        this.a.put("gqi", zzdmzVar.b);
        return this;
    }

    public final zzckp a(zzdmu zzdmuVar) {
        this.a.put("aai", zzdmuVar.v);
        return this;
    }

    public final zzckp a(String str, String str2) {
        this.a.put(str, str2);
        return this;
    }

    public final void a() {
        this.b.b.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.uo
            private final zzckp a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        });
    }

    public final String b() {
        return this.b.a.b(this.a);
    }

    final /* synthetic */ void c() {
        this.b.a.a(this.a);
    }
}
