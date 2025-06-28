package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzwq {
    private static zzwq a = new zzwq();
    private final zzayr b;
    private final zzvx c;
    private final String d;
    private final zzaaw e;
    private final zzaay f;
    private final zzabb g;
    private final zzazh h;
    private final Random i;
    private final WeakHashMap<QueryInfo, String> j;

    protected zzwq() {
        this(new zzayr(), new zzvx(new zzvi(), new zzvf(), new zzzp(), new zzagn(), new zzaut(), new zzavx(), new zzarh(), new zzagm()), new zzaaw(), new zzaay(), new zzabb(), zzayr.c(), new zzazh(0, 203404000, true), new Random(), new WeakHashMap());
    }

    private zzwq(zzayr zzayrVar, zzvx zzvxVar, zzaaw zzaawVar, zzaay zzaayVar, zzabb zzabbVar, String str, zzazh zzazhVar, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.b = zzayrVar;
        this.c = zzvxVar;
        this.e = zzaawVar;
        this.f = zzaayVar;
        this.g = zzabbVar;
        this.d = str;
        this.h = zzazhVar;
        this.i = random;
        this.j = weakHashMap;
    }

    public static zzayr a() {
        return a.b;
    }

    public static zzvx b() {
        return a.c;
    }

    public static zzaay c() {
        return a.f;
    }

    public static zzaaw d() {
        return a.e;
    }

    public static zzabb e() {
        return a.g;
    }

    public static String f() {
        return a.d;
    }

    public static zzazh g() {
        return a.h;
    }

    public static Random h() {
        return a.i;
    }

    public static WeakHashMap<QueryInfo, String> i() {
        return a.j;
    }
}
