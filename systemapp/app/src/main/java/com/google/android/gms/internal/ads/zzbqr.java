package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqr implements zzepf<zzdvm<zzdmu, com.google.android.gms.ads.internal.util.zzag>> {
    private final zzeps<Context> a;
    private final zzeps<zzazh> b;
    private final zzeps<zzdnn> c;

    public zzbqr(zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdnn> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdvm) zzepl.a(new zzdvm(this.a.b(), this.b.b(), this.c.b()) { // from class: com.google.android.gms.internal.ads.ml
            private final Context a;
            private final zzazh b;
            private final zzdnn c;

            {
                this.a = b;
                this.b = b2;
                this.c = b3;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                Context context = this.a;
                zzazh zzazhVar = this.b;
                zzdnn zzdnnVar = this.c;
                zzdmu zzdmuVar = (zzdmu) obj;
                com.google.android.gms.ads.internal.util.zzag zzagVar = new com.google.android.gms.ads.internal.util.zzag(context);
                zzagVar.c(zzdmuVar.A);
                zzagVar.d(zzdmuVar.B.toString());
                zzagVar.b(zzazhVar.a);
                zzagVar.a(zzdnnVar.f);
                return zzagVar;
            }
        }, "Cannot return null from a non-@Nullable @Provides method");
    }
}
