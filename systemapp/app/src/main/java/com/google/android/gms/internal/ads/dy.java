package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final class dy implements Callable<zzatq> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzats b;

    dy(zzats zzatsVar, Context context) {
        this.b = zzatsVar;
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzatq call() throws Exception {
        WeakHashMap weakHashMap;
        zzatq a;
        WeakHashMap weakHashMap2;
        weakHashMap = this.b.a;
        dx dxVar = (dx) weakHashMap.get(this.a);
        if (dxVar != null) {
            if (!(dxVar.a + zzact.a.a().longValue() < zzp.j().a())) {
                a = new zzatt(this.a, dxVar.b).a();
                weakHashMap2 = this.b.a;
                weakHashMap2.put(this.a, new dx(this.b, a));
                return a;
            }
        }
        a = new zzatt(this.a).a();
        weakHashMap2 = this.b.a;
        weakHashMap2.put(this.a, new dx(this.b, a));
        return a;
    }
}
