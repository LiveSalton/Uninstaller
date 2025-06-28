package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzal;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzabk;
import com.google.android.gms.internal.ads.zzakl;
import com.google.android.gms.internal.ads.zzamc;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzawx;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzazy;
import com.google.android.gms.internal.ads.zzbcu;
import com.google.android.gms.internal.ads.zzbed;
import com.google.android.gms.internal.ads.zzrg;
import com.google.android.gms.internal.ads.zzsx;
import com.google.android.gms.internal.ads.zztq;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzp {
    private static zzp a = new zzp();
    private final zzby A;
    private final zzbcu B;
    private final zzazy C;
    private final com.google.android.gms.ads.internal.overlay.zza b;
    private final zzo c;
    private final zzm d;
    private final zzbed e;
    private final zzu f;
    private final zzrg g;
    private final zzayg h;
    private final zzad i;
    private final zzsx j;
    private final Clock k;
    private final zze l;
    private final zzabk m;
    private final zzal n;
    private final zzats o;
    private final zzakl p;
    private final zzazt q;
    private final zzamc r;
    private final zzbo s;
    private final zzx t;
    private final zzw u;
    private final zzang v;
    private final zzbn w;
    private final zzard x;
    private final zztq y;
    private final zzawx z;

    protected zzp() {
        this(new com.google.android.gms.ads.internal.overlay.zza(), new zzo(), new zzm(), new zzbed(), zzu.a(Build.VERSION.SDK_INT), new zzrg(), new zzayg(), new zzad(), new zzsx(), DefaultClock.d(), new zze(), new zzabk(), new zzal(), new zzats(), new zzakl(), new zzazt(), new zzamc(), new zzbo(), new zzx(), new zzw(), new zzang(), new zzbn(), new zzard(), new zztq(), new zzawx(), new zzby(), new zzbcu(), new zzazy());
    }

    private zzp(com.google.android.gms.ads.internal.overlay.zza zzaVar, zzo zzoVar, zzm zzmVar, zzbed zzbedVar, zzu zzuVar, zzrg zzrgVar, zzayg zzaygVar, zzad zzadVar, zzsx zzsxVar, Clock clock, zze zzeVar, zzabk zzabkVar, zzal zzalVar, zzats zzatsVar, zzakl zzaklVar, zzazt zzaztVar, zzamc zzamcVar, zzbo zzboVar, zzx zzxVar, zzw zzwVar, zzang zzangVar, zzbn zzbnVar, zzard zzardVar, zztq zztqVar, zzawx zzawxVar, zzby zzbyVar, zzbcu zzbcuVar, zzazy zzazyVar) {
        this.b = zzaVar;
        this.c = zzoVar;
        this.d = zzmVar;
        this.e = zzbedVar;
        this.f = zzuVar;
        this.g = zzrgVar;
        this.h = zzaygVar;
        this.i = zzadVar;
        this.j = zzsxVar;
        this.k = clock;
        this.l = zzeVar;
        this.m = zzabkVar;
        this.n = zzalVar;
        this.o = zzatsVar;
        this.p = zzaklVar;
        this.q = zzaztVar;
        this.r = zzamcVar;
        this.s = zzboVar;
        this.t = zzxVar;
        this.u = zzwVar;
        this.v = zzangVar;
        this.w = zzbnVar;
        this.x = zzardVar;
        this.y = zztqVar;
        this.z = zzawxVar;
        this.A = zzbyVar;
        this.B = zzbcuVar;
        this.C = zzazyVar;
    }

    public static com.google.android.gms.ads.internal.overlay.zza a() {
        return a.b;
    }

    public static zzo b() {
        return a.c;
    }

    public static zzm c() {
        return a.d;
    }

    public static zzbed d() {
        return a.e;
    }

    public static zzu e() {
        return a.f;
    }

    public static zzrg f() {
        return a.g;
    }

    public static zzayg g() {
        return a.h;
    }

    public static zzad h() {
        return a.i;
    }

    public static zzsx i() {
        return a.j;
    }

    public static Clock j() {
        return a.k;
    }

    public static zze k() {
        return a.l;
    }

    public static zzabk l() {
        return a.m;
    }

    public static zzal m() {
        return a.n;
    }

    public static zzats n() {
        return a.o;
    }

    public static zzazt o() {
        return a.q;
    }

    public static zzamc p() {
        return a.r;
    }

    public static zzbo q() {
        return a.s;
    }

    public static zzard r() {
        return a.x;
    }

    public static zzx s() {
        return a.t;
    }

    public static zzw t() {
        return a.u;
    }

    public static zzang u() {
        return a.v;
    }

    public static zzbn v() {
        return a.w;
    }

    public static zztq w() {
        return a.y;
    }

    public static zzby x() {
        return a.A;
    }

    public static zzbcu y() {
        return a.B;
    }

    public static zzazy z() {
        return a.C;
    }

    public static zzawx A() {
        return a.z;
    }
}
