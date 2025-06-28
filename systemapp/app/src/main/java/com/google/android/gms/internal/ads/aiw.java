package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedList;

/* compiled from: source */
/* loaded from: classes.dex */
final class aiw {
    private final int b;
    private final int c;
    private final LinkedList<zzdpn<?>> a = new LinkedList<>();
    private final ajf d = new ajf();

    public aiw(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public final boolean a(zzdpn<?> zzdpnVar) {
        this.d.a();
        h();
        if (this.a.size() == this.b) {
            return false;
        }
        this.a.add(zzdpnVar);
        return true;
    }

    public final zzdpn<?> a() {
        this.d.a();
        h();
        if (this.a.isEmpty()) {
            return null;
        }
        zzdpn<?> remove = this.a.remove();
        if (remove != null) {
            this.d.b();
        }
        return remove;
    }

    public final int b() {
        h();
        return this.a.size();
    }

    public final long c() {
        return this.d.d();
    }

    public final long d() {
        return this.d.e();
    }

    public final int e() {
        return this.d.f();
    }

    public final String f() {
        return this.d.h();
    }

    public final zzdqg g() {
        return this.d.g();
    }

    private final void h() {
        while (!this.a.isEmpty()) {
            if (!(zzp.j().a() - this.a.getFirst().d >= ((long) this.c))) {
                return;
            }
            this.d.c();
            this.a.remove();
        }
    }
}
