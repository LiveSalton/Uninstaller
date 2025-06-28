package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxk extends zzxc {
    private final Context a;
    private final zzbgm b;

    @VisibleForTesting
    private final zzdnp c = new zzdnp();

    @VisibleForTesting
    private final zzccn d = new zzccn();
    private zzwt e;

    public zzcxk(zzbgm zzbgmVar, Context context, String str) {
        this.b = zzbgmVar;
        this.c.a(str);
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final zzwy a() {
        zzccl a = this.d.a();
        this.c.a(a.f());
        this.c.b(a.g());
        zzdnp zzdnpVar = this.c;
        if (zzdnpVar.b() == null) {
            zzdnpVar.a(zzvn.a());
        }
        return new zzcxj(this.a, this.b, this.c, a, this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzwt zzwtVar) {
        this.e = zzwtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafj zzafjVar) {
        this.d.a(zzafjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafy zzafyVar) {
        this.d.a(zzafyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafk zzafkVar) {
        this.d.a(zzafkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(String str, zzafq zzafqVar, zzafp zzafpVar) {
        this.d.a(str, zzafqVar, zzafpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzadz zzadzVar) {
        this.c.a(zzadzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzajl zzajlVar) {
        this.c.a(zzajlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzajt zzajtVar) {
        this.d.a(zzajtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzxu zzxuVar) {
        this.c.a(zzxuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafx zzafxVar, zzvn zzvnVar) {
        this.d.a(zzafxVar);
        this.c.a(zzvnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(PublisherAdViewOptions publisherAdViewOptions) {
        this.c.a(publisherAdViewOptions);
    }
}
