package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfl<T> {
    private final Set<zzdfi<? extends zzdfj<T>>> a;
    private final Executor b;

    public zzdfl(Executor executor, Set<zzdfi<? extends zzdfj<T>>> set) {
        this.b = executor;
        this.a = set;
    }

    public final zzdyz<T> a(T t) {
        ArrayList arrayList = new ArrayList(this.a.size());
        for (zzdfi<? extends zzdfj<T>> zzdfiVar : this.a) {
            zzdyz<? extends zzdfj<T>> a = zzdfiVar.a();
            if (zzada.a.a().booleanValue()) {
                a.a(new Runnable(zzdfiVar, zzp.j().b()) { // from class: com.google.android.gms.internal.ads.aei
                    private final zzdfi a;
                    private final long b;

                    {
                        this.a = zzdfiVar;
                        this.b = b;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdfi zzdfiVar2 = this.a;
                        long j = this.b;
                        String canonicalName = zzdfiVar2.getClass().getCanonicalName();
                        long b2 = zzp.j().b() - j;
                        StringBuilder sb = new StringBuilder(40 + String.valueOf(canonicalName).length());
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(b2);
                        zzd.a(sb.toString());
                    }
                }, zzazj.f);
            }
            arrayList.add(a);
        }
        return zzdyr.c(arrayList).a(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.aej
            private final List a;
            private final Object b;

            {
                this.a = arrayList;
                this.b = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List list = this.a;
                Object obj = this.b;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzdfj zzdfjVar = (zzdfj) ((zzdyz) it.next()).get();
                    if (zzdfjVar != null) {
                        zzdfjVar.a(obj);
                    }
                }
                return obj;
            }
        }, this.b);
    }
}
