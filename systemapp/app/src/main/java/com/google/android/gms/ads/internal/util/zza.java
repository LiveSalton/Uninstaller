package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzdyz;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zza {
    private volatile Thread b;
    private final Runnable a = new t(this);
    private boolean c = false;

    public abstract void a();

    public final zzdyz<?> b() {
        return zzazj.b.submit(this.a);
    }
}
