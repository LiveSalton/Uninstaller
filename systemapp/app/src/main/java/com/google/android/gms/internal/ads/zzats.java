package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzats {
    private WeakHashMap<Context, dx> a = new WeakHashMap<>();

    public final Future<zzatq> a(Context context) {
        return zzazj.a.submit(new dy(this, context));
    }
}
