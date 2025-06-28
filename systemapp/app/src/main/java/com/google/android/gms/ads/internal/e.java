package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final class e implements Callable<zzef> {
    private final /* synthetic */ zzj a;

    e(zzj zzjVar) {
        this.a = zzjVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzef call() throws Exception {
        zzazh zzazhVar;
        Context context;
        zzazhVar = this.a.a;
        String str = zzazhVar.a;
        context = this.a.d;
        return new zzef(zzeg.a(str, context, false));
    }
}
