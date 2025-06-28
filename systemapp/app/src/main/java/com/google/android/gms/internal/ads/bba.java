package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class bba implements s {
    private final Map<String, List<zzaa<?>>> a = new HashMap();
    private final zzm b;

    bba(zzm zzmVar) {
        this.b = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.s
    public final void a(zzaa<?> zzaaVar, zzaj<?> zzajVar) {
        List<zzaa<?>> remove;
        if (zzajVar.b == null || zzajVar.b.a()) {
            a(zzaaVar);
            return;
        }
        String f = zzaaVar.f();
        synchronized (this) {
            remove = this.a.remove(f);
        }
        if (remove != null) {
            if (zzaq.a) {
                zzaq.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), f);
            }
            Iterator<zzaa<?>> it = remove.iterator();
            while (it.hasNext()) {
                this.b.e.a(it.next(), zzajVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.s
    public final synchronized void a(zzaa<?> zzaaVar) {
        String f = zzaaVar.f();
        List<zzaa<?>> remove = this.a.remove(f);
        if (remove != null && !remove.isEmpty()) {
            if (zzaq.a) {
                zzaq.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), f);
            }
            zzaa<?> remove2 = remove.remove(0);
            this.a.put(f, remove);
            remove2.a((s) this);
            try {
                this.b.c.put(remove2);
            } catch (InterruptedException e) {
                zzaq.c("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.b.a();
            }
        }
    }

    public final synchronized boolean b(zzaa<?> zzaaVar) {
        String f = zzaaVar.f();
        if (this.a.containsKey(f)) {
            List<zzaa<?>> list = this.a.get(f);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzaaVar.b("waiting-for-response");
            list.add(zzaaVar);
            this.a.put(f, list);
            if (zzaq.a) {
                zzaq.b("Request for cacheKey=%s is in flight, putting on hold.", f);
            }
            return true;
        }
        this.a.put(f, null);
        zzaaVar.a((s) this);
        if (zzaq.a) {
            zzaq.b("new request, sending to network %s", f);
        }
        return false;
    }
}
