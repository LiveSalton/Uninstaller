package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
final class ajy extends zzbwk<zzdru> implements zzdrm<zzdrl> {
    ajy(Set<zzbxy<zzdru>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final void a(zzdqx<zzdrl, ?> zzdqxVar) {
        a(new zzbwm(zzdqxVar) { // from class: com.google.android.gms.internal.ads.aka
            private final zzdqx a;

            {
                this.a = zzdqxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                zzdqx zzdqxVar2 = this.a;
                ((zzdru) obj).a((zzdrl) zzdqxVar2.a(), zzdqxVar2.b());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final void b(zzdqx<zzdrl, ?> zzdqxVar) {
        a(new zzbwm(zzdqxVar) { // from class: com.google.android.gms.internal.ads.ajz
            private final zzdqx a;

            {
                this.a = zzdqxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                zzdqx zzdqxVar2 = this.a;
                ((zzdru) obj).b((zzdrl) zzdqxVar2.a(), zzdqxVar2.b());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final void a(zzdqx<zzdrl, ?> zzdqxVar, Throwable th) {
        a(new zzbwm(zzdqxVar, th) { // from class: com.google.android.gms.internal.ads.akc
            private final zzdqx a;
            private final Throwable b;

            {
                this.a = zzdqxVar;
                this.b = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                zzdqx zzdqxVar2 = this.a;
                ((zzdru) obj).a((zzdrl) zzdqxVar2.a(), zzdqxVar2.b(), this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final void c(zzdqx<zzdrl, ?> zzdqxVar) {
        a(new zzbwm(zzdqxVar) { // from class: com.google.android.gms.internal.ads.akb
            private final zzdqx a;

            {
                this.a = zzdqxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                zzdqx zzdqxVar2 = this.a;
                ((zzdru) obj).c((zzdrl) zzdqxVar2.a(), zzdqxVar2.b());
            }
        });
    }
}
