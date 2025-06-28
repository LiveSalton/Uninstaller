package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzae {
    private final AtomicInteger a;
    private final Set<zzaa<?>> b;
    private final PriorityBlockingQueue<zzaa<?>> c;
    private final PriorityBlockingQueue<zzaa<?>> d;
    private final zzk e;
    private final zzx f;
    private final zzak g;
    private final zzw[] h;
    private zzm i;
    private final List<zzag> j;
    private final List<zzah> k;

    private zzae(zzk zzkVar, zzx zzxVar, int i, zzak zzakVar) {
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = zzkVar;
        this.f = zzxVar;
        this.h = new zzw[4];
        this.g = zzakVar;
    }

    private zzae(zzk zzkVar, zzx zzxVar, int i) {
        this(zzkVar, zzxVar, 4, new zzt(new Handler(Looper.getMainLooper())));
    }

    public zzae(zzk zzkVar, zzx zzxVar) {
        this(zzkVar, zzxVar, 4);
    }

    public final void a() {
        if (this.i != null) {
            this.i.a();
        }
        for (zzw zzwVar : this.h) {
            if (zzwVar != null) {
                zzwVar.a();
            }
        }
        this.i = new zzm(this.c, this.d, this.e, this.g);
        this.i.start();
        for (int i = 0; i < this.h.length; i++) {
            zzw zzwVar2 = new zzw(this.d, this.f, this.e, this.g);
            this.h[i] = zzwVar2;
            zzwVar2.start();
        }
    }

    public final <T> zzaa<T> a(zzaa<T> zzaaVar) {
        zzaaVar.a(this);
        synchronized (this.b) {
            this.b.add(zzaaVar);
        }
        zzaaVar.b(this.a.incrementAndGet());
        zzaaVar.b("add-to-queue");
        a(zzaaVar, 0);
        if (!zzaaVar.i()) {
            this.d.add(zzaaVar);
            return zzaaVar;
        }
        this.c.add(zzaaVar);
        return zzaaVar;
    }

    final <T> void b(zzaa<T> zzaaVar) {
        synchronized (this.b) {
            this.b.remove(zzaaVar);
        }
        synchronized (this.j) {
            Iterator<zzag> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(zzaaVar);
            }
        }
        a(zzaaVar, 5);
    }

    final void a(zzaa<?> zzaaVar, int i) {
        synchronized (this.k) {
            Iterator<zzah> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().a(zzaaVar, i);
            }
        }
    }
}
