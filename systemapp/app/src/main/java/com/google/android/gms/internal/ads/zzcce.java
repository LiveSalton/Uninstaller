package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcce {
    private int a;
    private zzys b;
    private zzaeb c;
    private View d;
    private List<?> e;
    private zzzk g;
    private Bundle h;
    private zzbdv i;
    private zzbdv j;
    private IObjectWrapper k;
    private View l;
    private IObjectWrapper m;
    private double n;
    private zzaej o;
    private zzaej p;
    private String q;
    private float t;
    private String u;
    private androidx.b.g<String, zzadv> r = new androidx.b.g<>();
    private androidx.b.g<String, String> s = new androidx.b.g<>();
    private List<zzzk> f = Collections.emptyList();

    public final synchronized void a(int i) {
        this.a = i;
    }

    public final synchronized void a(zzys zzysVar) {
        this.b = zzysVar;
    }

    public final synchronized void a(zzaeb zzaebVar) {
        this.c = zzaebVar;
    }

    public final synchronized void a(List<zzadv> list) {
        this.e = list;
    }

    public final synchronized void b(List<zzzk> list) {
        this.f = list;
    }

    public final synchronized void a(zzzk zzzkVar) {
        this.g = zzzkVar;
    }

    public final synchronized void a(View view) {
        this.l = view;
    }

    public final synchronized void a(double d) {
        this.n = d;
    }

    public final synchronized void a(zzaej zzaejVar) {
        this.o = zzaejVar;
    }

    public final synchronized void b(zzaej zzaejVar) {
        this.p = zzaejVar;
    }

    public final synchronized void a(String str) {
        this.q = str;
    }

    public final synchronized void a(zzbdv zzbdvVar) {
        this.i = zzbdvVar;
    }

    public final synchronized void b(zzbdv zzbdvVar) {
        this.j = zzbdvVar;
    }

    public final synchronized void a(IObjectWrapper iObjectWrapper) {
        this.k = iObjectWrapper;
    }

    public final synchronized void a(String str, String str2) {
        if (str2 == null) {
            this.s.remove(str);
        } else {
            this.s.put(str, str2);
        }
    }

    public final synchronized void a(String str, zzadv zzadvVar) {
        if (zzadvVar == null) {
            this.r.remove(str);
        } else {
            this.r.put(str, zzadvVar);
        }
    }

    private final synchronized void a(float f) {
        this.t = f;
    }

    public final synchronized void b(String str) {
        this.u = str;
    }

    private final synchronized String c(String str) {
        return this.s.get(str);
    }

    public final synchronized int a() {
        return this.a;
    }

    public final synchronized zzys b() {
        return this.b;
    }

    public final synchronized zzaeb c() {
        return this.c;
    }

    public final synchronized View d() {
        return this.d;
    }

    public final synchronized String e() {
        return c("headline");
    }

    public final synchronized List<?> f() {
        return this.e;
    }

    public final zzaej g() {
        if (this.e == null || this.e.size() == 0) {
            return null;
        }
        Object obj = this.e.get(0);
        if (obj instanceof IBinder) {
            return zzaei.a((IBinder) obj);
        }
        return null;
    }

    public final synchronized List<zzzk> h() {
        return this.f;
    }

    public final synchronized zzzk i() {
        return this.g;
    }

    public final synchronized String j() {
        return c("body");
    }

    public final synchronized Bundle k() {
        if (this.h == null) {
            this.h = new Bundle();
        }
        return this.h;
    }

    public final synchronized String l() {
        return c("call_to_action");
    }

    public final synchronized View m() {
        return this.l;
    }

    public final synchronized IObjectWrapper n() {
        return this.m;
    }

    public final synchronized String o() {
        return c("store");
    }

    public final synchronized String p() {
        return c("price");
    }

    public final synchronized double q() {
        return this.n;
    }

    public final synchronized zzaej r() {
        return this.o;
    }

    public final synchronized String s() {
        return c("advertiser");
    }

    public final synchronized zzaej t() {
        return this.p;
    }

    public final synchronized String u() {
        return this.q;
    }

    public final synchronized zzbdv v() {
        return this.i;
    }

    public final synchronized zzbdv w() {
        return this.j;
    }

    public final synchronized IObjectWrapper x() {
        return this.k;
    }

    public final synchronized androidx.b.g<String, zzadv> y() {
        return this.r;
    }

    public final synchronized float z() {
        return this.t;
    }

    public final synchronized String A() {
        return this.u;
    }

    public final synchronized androidx.b.g<String, String> B() {
        return this.s;
    }

    public final synchronized void C() {
        if (this.i != null) {
            this.i.destroy();
            this.i = null;
        }
        if (this.j != null) {
            this.j.destroy();
            this.j = null;
        }
        this.k = null;
        this.r.clear();
        this.s.clear();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public static zzcce a(zzanw zzanwVar) {
        try {
            zzccb a = a(zzanwVar.l(), (zzaob) null);
            zzaeb m = zzanwVar.m();
            View view = (View) b(zzanwVar.k());
            String a2 = zzanwVar.a();
            List<?> b = zzanwVar.b();
            String c = zzanwVar.c();
            Bundle j = zzanwVar.j();
            String e = zzanwVar.e();
            View view2 = (View) b(zzanwVar.n());
            IObjectWrapper o = zzanwVar.o();
            String f = zzanwVar.f();
            zzaej d = zzanwVar.d();
            zzcce zzcceVar = new zzcce();
            zzcceVar.a = 1;
            zzcceVar.b = a;
            zzcceVar.c = m;
            zzcceVar.d = view;
            zzcceVar.a("headline", a2);
            zzcceVar.e = b;
            zzcceVar.a("body", c);
            zzcceVar.h = j;
            zzcceVar.a("call_to_action", e);
            zzcceVar.l = view2;
            zzcceVar.m = o;
            zzcceVar.a("advertiser", f);
            zzcceVar.p = d;
            return zzcceVar;
        } catch (RemoteException e2) {
            zzd.d("Failed to get native ad from content ad mapper", e2);
            return null;
        }
    }

    public static zzcce a(zzanv zzanvVar) {
        try {
            zzccb a = a(zzanvVar.m(), (zzaob) null);
            zzaeb o = zzanvVar.o();
            View view = (View) b(zzanvVar.n());
            String a2 = zzanvVar.a();
            List<?> b = zzanvVar.b();
            String c = zzanvVar.c();
            Bundle l = zzanvVar.l();
            String e = zzanvVar.e();
            View view2 = (View) b(zzanvVar.p());
            IObjectWrapper q = zzanvVar.q();
            String g = zzanvVar.g();
            String h = zzanvVar.h();
            double f = zzanvVar.f();
            zzaej d = zzanvVar.d();
            zzcce zzcceVar = new zzcce();
            zzcceVar.a = 2;
            zzcceVar.b = a;
            zzcceVar.c = o;
            zzcceVar.d = view;
            zzcceVar.a("headline", a2);
            zzcceVar.e = b;
            zzcceVar.a("body", c);
            zzcceVar.h = l;
            zzcceVar.a("call_to_action", e);
            zzcceVar.l = view2;
            zzcceVar.m = q;
            zzcceVar.a("store", g);
            zzcceVar.a("price", h);
            zzcceVar.n = f;
            zzcceVar.o = d;
            return zzcceVar;
        } catch (RemoteException e2) {
            zzd.d("Failed to get native ad from app install ad mapper", e2);
            return null;
        }
    }

    public static zzcce a(zzaob zzaobVar) {
        try {
            return a(a(zzaobVar.j(), zzaobVar), zzaobVar.k(), (View) b(zzaobVar.l()), zzaobVar.a(), zzaobVar.b(), zzaobVar.c(), zzaobVar.o(), zzaobVar.e(), (View) b(zzaobVar.m()), zzaobVar.n(), zzaobVar.h(), zzaobVar.i(), zzaobVar.g(), zzaobVar.d(), zzaobVar.f(), zzaobVar.s());
        } catch (RemoteException e) {
            zzd.d("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzcce b(zzanv zzanvVar) {
        try {
            return a(a(zzanvVar.m(), (zzaob) null), zzanvVar.o(), (View) b(zzanvVar.n()), zzanvVar.a(), zzanvVar.b(), zzanvVar.c(), zzanvVar.l(), zzanvVar.e(), (View) b(zzanvVar.p()), zzanvVar.q(), zzanvVar.g(), zzanvVar.h(), zzanvVar.f(), zzanvVar.d(), null, 0.0f);
        } catch (RemoteException e) {
            zzd.d("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzcce b(zzanw zzanwVar) {
        try {
            return a(a(zzanwVar.l(), (zzaob) null), zzanwVar.m(), (View) b(zzanwVar.k()), zzanwVar.a(), zzanwVar.b(), zzanwVar.c(), zzanwVar.j(), zzanwVar.e(), (View) b(zzanwVar.n()), zzanwVar.o(), null, null, -1.0d, zzanwVar.d(), zzanwVar.f(), 0.0f);
        } catch (RemoteException e) {
            zzd.d("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzcce a(zzys zzysVar, zzaeb zzaebVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaej zzaejVar, String str6, float f) {
        zzcce zzcceVar = new zzcce();
        zzcceVar.a = 6;
        zzcceVar.b = zzysVar;
        zzcceVar.c = zzaebVar;
        zzcceVar.d = view;
        zzcceVar.a("headline", str);
        zzcceVar.e = list;
        zzcceVar.a("body", str2);
        zzcceVar.h = bundle;
        zzcceVar.a("call_to_action", str3);
        zzcceVar.l = view2;
        zzcceVar.m = iObjectWrapper;
        zzcceVar.a("store", str4);
        zzcceVar.a("price", str5);
        zzcceVar.n = d;
        zzcceVar.o = zzaejVar;
        zzcceVar.a("advertiser", str6);
        zzcceVar.a(f);
        return zzcceVar;
    }

    private static <T> T b(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.a(iObjectWrapper);
    }

    private static zzccb a(zzys zzysVar, zzaob zzaobVar) {
        if (zzysVar == null) {
            return null;
        }
        return new zzccb(zzysVar, zzaobVar);
    }
}
