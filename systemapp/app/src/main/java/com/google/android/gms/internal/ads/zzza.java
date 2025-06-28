package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzza {
    private final Date a;
    private final String b;
    private final List<String> c;
    private final int d;
    private final Set<String> e;
    private final Location f;
    private final boolean g;
    private final Bundle h;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> i;
    private final String j;
    private final String k;
    private final SearchAdRequest l;
    private final int m;
    private final Set<String> n;
    private final Bundle o;
    private final Set<String> p;
    private final boolean q;
    private final AdInfo r;
    private final int s;
    private final String t;
    private final int u;

    public zzza(zzyz zzyzVar) {
        this(zzyzVar, null);
    }

    public zzza(zzyz zzyzVar, SearchAdRequest searchAdRequest) {
        Date date;
        String str;
        List<String> list;
        int i;
        HashSet hashSet;
        Location location;
        boolean z;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i2;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z2;
        AdInfo adInfo;
        int i3;
        String str4;
        int i4;
        date = zzyzVar.g;
        this.a = date;
        str = zzyzVar.h;
        this.b = str;
        list = zzyzVar.i;
        this.c = list;
        i = zzyzVar.j;
        this.d = i;
        hashSet = zzyzVar.a;
        this.e = Collections.unmodifiableSet(hashSet);
        location = zzyzVar.k;
        this.f = location;
        z = zzyzVar.l;
        this.g = z;
        bundle = zzyzVar.b;
        this.h = bundle;
        hashMap = zzyzVar.c;
        this.i = Collections.unmodifiableMap(hashMap);
        str2 = zzyzVar.m;
        this.j = str2;
        str3 = zzyzVar.n;
        this.k = str3;
        this.l = searchAdRequest;
        i2 = zzyzVar.o;
        this.m = i2;
        hashSet2 = zzyzVar.d;
        this.n = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzyzVar.e;
        this.o = bundle2;
        hashSet3 = zzyzVar.f;
        this.p = Collections.unmodifiableSet(hashSet3);
        z2 = zzyzVar.p;
        this.q = z2;
        adInfo = zzyzVar.q;
        this.r = adInfo;
        i3 = zzyzVar.r;
        this.s = i3;
        str4 = zzyzVar.s;
        this.t = str4;
        i4 = zzyzVar.t;
        this.u = i4;
    }

    @Deprecated
    public final Date a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final List<String> c() {
        return new ArrayList(this.c);
    }

    @Deprecated
    public final int d() {
        return this.d;
    }

    public final Set<String> e() {
        return this.e;
    }

    public final Location f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final Bundle a(Class<? extends MediationExtrasReceiver> cls) {
        return this.h.getBundle(cls.getName());
    }

    public final String h() {
        return this.j;
    }

    public final String i() {
        return this.k;
    }

    public final SearchAdRequest j() {
        return this.l;
    }

    public final boolean a(Context context) {
        RequestConfiguration d = zzzd.a().d();
        zzwq.a();
        String a = zzayr.a(context);
        return this.n.contains(a) || d.d().contains(a);
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> k() {
        return this.i;
    }

    public final Bundle l() {
        return this.h;
    }

    public final int m() {
        return this.m;
    }

    public final Bundle n() {
        return this.o;
    }

    public final Set<String> o() {
        return this.p;
    }

    @Deprecated
    public final boolean p() {
        return this.q;
    }

    public final AdInfo q() {
        return this.r;
    }

    public final int r() {
        return this.s;
    }

    public final String s() {
        return this.t;
    }

    public final int t() {
        return this.u;
    }
}
