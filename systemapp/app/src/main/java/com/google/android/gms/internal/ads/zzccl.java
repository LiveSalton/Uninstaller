package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccl {
    public static final zzccl a = new zzccn().a();
    private final zzafk b;
    private final zzafj c;
    private final zzafy d;
    private final zzafx e;
    private final zzajt f;
    private final androidx.b.g<String, zzafq> g;
    private final androidx.b.g<String, zzafp> h;

    public final zzafk a() {
        return this.b;
    }

    public final zzafj b() {
        return this.c;
    }

    public final zzafy c() {
        return this.d;
    }

    public final zzafx d() {
        return this.e;
    }

    public final zzajt e() {
        return this.f;
    }

    public final zzafq a(String str) {
        return this.g.get(str);
    }

    public final zzafp b(String str) {
        return this.h.get(str);
    }

    public final ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.d != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.b != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.c != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.g.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.f != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> g() {
        ArrayList<String> arrayList = new ArrayList<>(this.g.size());
        for (int i = 0; i < this.g.size(); i++) {
            arrayList.add(this.g.b(i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzccl(zzccn zzccnVar) {
        this.b = zzccnVar.a;
        this.c = zzccnVar.b;
        this.d = zzccnVar.c;
        this.g = new androidx.b.g<>(zzccnVar.f);
        this.h = new androidx.b.g<>(zzccnVar.g);
        this.e = zzccnVar.d;
        this.f = zzccnVar.e;
    }

    /* synthetic */ zzccl(zzccn zzccnVar, qy qyVar) {
        this(zzccnVar);
    }
}
