package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
final class agm<R> implements zzdqb {
    public final zzdkn<R> a;
    public final zzdkm b;
    public final zzvk c;
    public final String d;
    public final Executor e;
    public final zzvw f;

    @Nullable
    private final zzdpq g;

    public agm(zzdkn<R> zzdknVar, zzdkm zzdkmVar, zzvk zzvkVar, String str, Executor executor, zzvw zzvwVar, @Nullable zzdpq zzdpqVar) {
        this.a = zzdknVar;
        this.b = zzdkmVar;
        this.c = zzvkVar;
        this.d = str;
        this.e = executor;
        this.f = zzvwVar;
        this.g = zzdpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final Executor a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    @Nullable
    public final zzdpq b() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzdqb
    public final zzdqb c() {
        return new agm(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
