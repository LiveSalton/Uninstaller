package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzayq implements zzrl {
    private final zzf b;

    @VisibleForTesting
    private final zzayn d;
    private final Object a = new Object();

    @VisibleForTesting
    private final HashSet<zzayf> e = new HashSet<>();

    @VisibleForTesting
    private final HashSet<zzayo> f = new HashSet<>();
    private boolean g = false;
    private final zzayp c = new zzayp();

    public zzayq(String str, zzf zzfVar) {
        this.d = new zzayn(str, zzfVar);
        this.b = zzfVar;
    }

    public final void a(zzayf zzayfVar) {
        synchronized (this.a) {
            this.e.add(zzayfVar);
        }
    }

    public final void a(HashSet<zzayf> hashSet) {
        synchronized (this.a) {
            this.e.addAll(hashSet);
        }
    }

    public final Bundle a(Context context, zzaym zzaymVar) {
        HashSet<zzayf> hashSet = new HashSet<>();
        synchronized (this.a) {
            hashSet.addAll(this.e);
            this.e.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.d.a(context, this.c.b()));
        Bundle bundle2 = new Bundle();
        Iterator<zzayo> it = this.f.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzayf> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().d());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzaymVar.a(hashSet);
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzrl
    public final void a(boolean z) {
        long a = zzp.j().a();
        if (z) {
            if (a - this.b.i() > ((Long) zzwq.e().a(zzabf.ar)).longValue()) {
                this.d.a = -1;
            } else {
                this.d.a = this.b.j();
            }
            this.g = true;
            return;
        }
        this.b.a(a);
        this.b.b(this.d.a);
    }

    public final void a() {
        synchronized (this.a) {
            this.d.a();
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.d.b();
        }
    }

    public final void a(zzvk zzvkVar, long j) {
        synchronized (this.a) {
            this.d.a(zzvkVar, j);
        }
    }

    public final zzayf a(Clock clock, String str) {
        return new zzayf(clock, this, this.c.a(), str);
    }

    public final boolean c() {
        return this.g;
    }
}
