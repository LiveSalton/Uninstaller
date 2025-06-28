package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbwk<ListenerT> {

    @GuardedBy("this")
    private final Map<ListenerT, Executor> a = new HashMap();

    protected zzbwk(Set<zzbxy<ListenerT>> set) {
        a(set);
    }

    public final synchronized void a(zzbxy<ListenerT> zzbxyVar) {
        a(zzbxyVar.a, zzbxyVar.b);
    }

    public final synchronized void a(ListenerT listenert, Executor executor) {
        this.a.put(listenert, executor);
    }

    private final synchronized void a(Set<zzbxy<ListenerT>> set) {
        Iterator<zzbxy<ListenerT>> it = set.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    protected final synchronized void a(zzbwm<ListenerT> zzbwmVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.a.entrySet()) {
            entry.getValue().execute(new Runnable(zzbwmVar, entry.getKey()) { // from class: com.google.android.gms.internal.ads.pl
                private final zzbwm a;
                private final Object b;

                {
                    this.a = zzbwmVar;
                    this.b = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.a.a(this.b);
                    } catch (Throwable th) {
                        zzp.g().b(th, "EventEmitter.notify");
                        zzd.a("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
