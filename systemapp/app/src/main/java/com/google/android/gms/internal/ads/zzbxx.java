package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxx extends zzbwk<zzqu> implements zzqu {

    @GuardedBy("this")
    private Map<View, zzqq> a;
    private final Context b;
    private final zzdmu c;

    public zzbxx(Context context, Set<zzbxy<zzqu>> set, zzdmu zzdmuVar) {
        super(set);
        this.a = new WeakHashMap(1);
        this.b = context;
        this.c = zzdmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final synchronized void a(zzqv zzqvVar) {
        a(new zzbwm(zzqvVar) { // from class: com.google.android.gms.internal.ads.pt
            private final zzqv a;

            {
                this.a = zzqvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzqu) obj).a(this.a);
            }
        });
    }

    public final synchronized void a(View view) {
        zzqq zzqqVar = this.a.get(view);
        if (zzqqVar == null) {
            zzqqVar = new zzqq(this.b, view);
            zzqqVar.a(this);
            this.a.put(view, zzqqVar);
        }
        if (this.c != null && this.c.R) {
            if (((Boolean) zzwq.e().a(zzabf.aG)).booleanValue()) {
                zzqqVar.a(((Long) zzwq.e().a(zzabf.aF)).longValue());
                return;
            }
        }
        zzqqVar.a();
    }

    public final synchronized void b(View view) {
        if (this.a.containsKey(view)) {
            this.a.get(view).b(this);
            this.a.remove(view);
        }
    }
}
