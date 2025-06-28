package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzi implements zzepf<zzbxy<zzbtj>> {
    private final zzbzc a;
    private final zzeps<Context> b;
    private final zzeps<zzazh> c;
    private final zzeps<zzdmu> d;
    private final zzeps<zzdnn> e;

    private zzbzi(zzbzc zzbzcVar, zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzdnn> zzepsVar4) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
        this.d = zzepsVar3;
        this.e = zzepsVar4;
    }

    public static zzbzi a(zzbzc zzbzcVar, zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzdnn> zzepsVar4) {
        return new zzbzi(zzbzcVar, zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(new zzbtj(this.b.b(), this.c.b(), this.d.b(), this.e.b()) { // from class: com.google.android.gms.internal.ads.qg
            private final Context a;
            private final zzazh b;
            private final zzdmu c;
            private final zzdnn d;

            {
                this.a = b;
                this.b = b2;
                this.c = b3;
                this.d = b4;
            }

            @Override // com.google.android.gms.internal.ads.zzbtj
            public final void a() {
                zzp.m().b(this.a, this.b.a, this.c.B.toString(), this.d.f);
            }
        }, zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
