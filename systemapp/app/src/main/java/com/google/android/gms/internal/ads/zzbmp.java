package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmp implements zzepf<zzbxy<zzbtj>> {
    private final zzbmh a;
    private final zzeps<Context> b;
    private final zzeps<zzazh> c;
    private final zzeps<zzdmu> d;
    private final zzeps<zzdnn> e;

    public zzbmp(zzbmh zzbmhVar, zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzdnn> zzepsVar4) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
        this.d = zzepsVar3;
        this.e = zzepsVar4;
    }

    public static zzbxy<zzbtj> a(zzbmh zzbmhVar, Context context, zzazh zzazhVar, zzdmu zzdmuVar, zzdnn zzdnnVar) {
        return (zzbxy) zzepl.a(new zzbxy(new zzbtj(context, zzazhVar, zzdmuVar, zzdnnVar) { // from class: com.google.android.gms.internal.ads.lu
            private final Context a;
            private final zzazh b;
            private final zzdmu c;
            private final zzdnn d;

            {
                this.a = context;
                this.b = zzazhVar;
                this.c = zzdmuVar;
                this.d = zzdnnVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtj
            public final void a() {
                zzp.m().b(this.a, this.b.a, this.c.B.toString(), this.d.f);
            }
        }, zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
