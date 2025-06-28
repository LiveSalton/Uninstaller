package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzayf {
    private final Clock a;
    private final zzayq b;
    private final String e;
    private final String f;
    private final Object d = new Object();

    @GuardedBy("lock")
    private long g = -1;

    @GuardedBy("lock")
    private long h = -1;

    @GuardedBy("lock")
    private boolean i = false;

    @GuardedBy("lock")
    private long j = -1;

    @GuardedBy("lock")
    private long k = 0;

    @GuardedBy("lock")
    private long l = -1;

    @GuardedBy("lock")
    private long m = -1;

    @GuardedBy("lock")
    private final LinkedList<fb> c = new LinkedList<>();

    zzayf(Clock clock, zzayq zzayqVar, String str, String str2) {
        this.a = clock;
        this.b = zzayqVar;
        this.e = str;
        this.f = str2;
    }

    public final void a(zzvk zzvkVar) {
        synchronized (this.d) {
            this.l = this.a.b();
            this.b.a(zzvkVar, this.l);
        }
    }

    public final void a(long j) {
        synchronized (this.d) {
            this.m = j;
            if (this.m != -1) {
                this.b.a(this);
            }
        }
    }

    public final void a() {
        synchronized (this.d) {
            if (this.m != -1 && this.h == -1) {
                this.h = this.a.b();
                this.b.a(this);
            }
            this.b.b();
        }
    }

    public final void b() {
        synchronized (this.d) {
            if (this.m != -1) {
                fb fbVar = new fb(this);
                fbVar.c();
                this.c.add(fbVar);
                this.k++;
                this.b.a();
                this.b.a(this);
            }
        }
    }

    public final void c() {
        synchronized (this.d) {
            if (this.m != -1 && !this.c.isEmpty()) {
                fb last = this.c.getLast();
                if (last.a() == -1) {
                    last.b();
                    this.b.a(this);
                }
            }
        }
    }

    public final void a(boolean z) {
        synchronized (this.d) {
            if (this.m != -1) {
                this.j = this.a.b();
            }
        }
    }

    public final Bundle d() {
        Bundle bundle;
        synchronized (this.d) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.e);
            bundle.putString("slotid", this.f);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.l);
            bundle.putLong("tresponse", this.m);
            bundle.putLong("timp", this.h);
            bundle.putLong("tload", this.j);
            bundle.putLong("pcc", this.k);
            bundle.putLong("tfetch", this.g);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<fb> it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String e() {
        return this.e;
    }
}
