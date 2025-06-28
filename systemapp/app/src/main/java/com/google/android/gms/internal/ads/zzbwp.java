package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbwp {
    private final Set<zzbxy<zzva>> a;
    private final Set<zzbxy<zzbru>> b;
    private final Set<zzbxy<zzbsm>> c;
    private final Set<zzbxy<zzbto>> d;
    private final Set<zzbxy<zzbtj>> e;
    private final Set<zzbxy<zzbrz>> f;
    private final Set<zzbxy<zzbsi>> g;
    private final Set<zzbxy<AdMetadataListener>> h;
    private final Set<zzbxy<AppEventListener>> i;
    private final Set<zzbxy<zzbub>> j;
    private final Set<zzbxy<zzp>> k;
    private final zzdki l;
    private zzbrx m;
    private zzcum n;

    private zzbwp(zza zzaVar) {
        this.a = zzaVar.a;
        this.c = zzaVar.c;
        this.d = zzaVar.d;
        this.b = zzaVar.b;
        this.e = zzaVar.e;
        this.f = zzaVar.f;
        this.g = zzaVar.i;
        this.h = zzaVar.g;
        this.i = zzaVar.h;
        this.j = zzaVar.j;
        this.l = zzaVar.l;
        this.k = zzaVar.k;
    }

    /* compiled from: source */
    public static class zza {
        private Set<zzbxy<zzva>> a = new HashSet();
        private Set<zzbxy<zzbru>> b = new HashSet();
        private Set<zzbxy<zzbsm>> c = new HashSet();
        private Set<zzbxy<zzbto>> d = new HashSet();
        private Set<zzbxy<zzbtj>> e = new HashSet();
        private Set<zzbxy<zzbrz>> f = new HashSet();
        private Set<zzbxy<AdMetadataListener>> g = new HashSet();
        private Set<zzbxy<AppEventListener>> h = new HashSet();
        private Set<zzbxy<zzbsi>> i = new HashSet();
        private Set<zzbxy<zzbub>> j = new HashSet();
        private Set<zzbxy<zzp>> k = new HashSet();
        private zzdki l;

        public final zza a(zzbru zzbruVar, Executor executor) {
            this.b.add(new zzbxy<>(zzbruVar, executor));
            return this;
        }

        public final zza a(zzbtj zzbtjVar, Executor executor) {
            this.e.add(new zzbxy<>(zzbtjVar, executor));
            return this;
        }

        public final zza a(zzbrz zzbrzVar, Executor executor) {
            this.f.add(new zzbxy<>(zzbrzVar, executor));
            return this;
        }

        public final zza a(zzbsi zzbsiVar, Executor executor) {
            this.i.add(new zzbxy<>(zzbsiVar, executor));
            return this;
        }

        public final zza a(AdMetadataListener adMetadataListener, Executor executor) {
            this.g.add(new zzbxy<>(adMetadataListener, executor));
            return this;
        }

        public final zza a(AppEventListener appEventListener, Executor executor) {
            this.h.add(new zzbxy<>(appEventListener, executor));
            return this;
        }

        public final zza a(zzxo zzxoVar, Executor executor) {
            if (this.h != null) {
                zzcxq zzcxqVar = new zzcxq();
                zzcxqVar.a(zzxoVar);
                this.h.add(new zzbxy<>(zzcxqVar, executor));
            }
            return this;
        }

        public final zza a(zzva zzvaVar, Executor executor) {
            this.a.add(new zzbxy<>(zzvaVar, executor));
            return this;
        }

        public final zza a(zzbsm zzbsmVar, Executor executor) {
            this.c.add(new zzbxy<>(zzbsmVar, executor));
            return this;
        }

        public final zza a(zzbto zzbtoVar, Executor executor) {
            this.d.add(new zzbxy<>(zzbtoVar, executor));
            return this;
        }

        public final zza a(zzp zzpVar, Executor executor) {
            this.k.add(new zzbxy<>(zzpVar, executor));
            return this;
        }

        public final zza a(zzbub zzbubVar, Executor executor) {
            this.j.add(new zzbxy<>(zzbubVar, executor));
            return this;
        }

        public final zza a(zzdki zzdkiVar) {
            this.l = zzdkiVar;
            return this;
        }

        public final zzbwp a() {
            return new zzbwp(this);
        }
    }

    public final Set<zzbxy<zzbru>> a() {
        return this.b;
    }

    public final Set<zzbxy<zzbtj>> b() {
        return this.e;
    }

    public final Set<zzbxy<zzbrz>> c() {
        return this.f;
    }

    public final Set<zzbxy<zzbsi>> d() {
        return this.g;
    }

    public final Set<zzbxy<AdMetadataListener>> e() {
        return this.h;
    }

    public final Set<zzbxy<AppEventListener>> f() {
        return this.i;
    }

    public final Set<zzbxy<zzva>> g() {
        return this.a;
    }

    public final Set<zzbxy<zzbsm>> h() {
        return this.c;
    }

    public final Set<zzbxy<zzbto>> i() {
        return this.d;
    }

    public final Set<zzbxy<zzbub>> j() {
        return this.j;
    }

    public final Set<zzbxy<zzp>> k() {
        return this.k;
    }

    public final zzdki l() {
        return this.l;
    }

    public final zzbrx a(Set<zzbxy<zzbrz>> set) {
        if (this.m == null) {
            this.m = new zzbrx(set);
        }
        return this.m;
    }

    public final zzcum a(Clock clock, zzcuo zzcuoVar, zzcrg zzcrgVar) {
        if (this.n == null) {
            this.n = new zzcum(clock, zzcuoVar, zzcrgVar);
        }
        return this.n;
    }

    /* synthetic */ zzbwp(zza zzaVar, pm pmVar) {
        this(zzaVar);
    }
}
