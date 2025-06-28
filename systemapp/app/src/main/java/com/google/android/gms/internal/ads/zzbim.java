package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbim {
    private zza a;

    /* compiled from: source */
    public static abstract class zza {
        public abstract zzbdf a();

        public abstract zzbao b();

        public abstract zztx c();

        public abstract zzaws d();

        public abstract zzarq e();

        public abstract zzamy f();

        public abstract zzacl g();
    }

    public zzbim(zza zzaVar) {
        this.a = zzaVar;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzawn, com.google.android.gms.internal.ads.zzawt] */
    public final com.google.android.gms.ads.internal.zzb a() {
        zza zzaVar = this.a;
        return new com.google.android.gms.ads.internal.zzb(zzaVar.a(), zzaVar.b(), new zzawn(zzaVar.d()), zzaVar.c(), zzaVar.e(), zzaVar.g());
    }

    public final zzaws b() {
        return this.a.d();
    }

    public final zzarq c() {
        return this.a.e();
    }

    public final zzamy d() {
        return this.a.f();
    }

    public final zzacl e() {
        return this.a.g();
    }
}
