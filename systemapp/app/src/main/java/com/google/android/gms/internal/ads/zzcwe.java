package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwe implements zzcqz<zzbme> {
    private final Context a;
    private final zzbna b;
    private final zzacb c;
    private final zzdzc d;
    private final zzdro e;

    public zzcwe(Context context, zzbna zzbnaVar, zzdro zzdroVar, zzdzc zzdzcVar, zzacb zzacbVar) {
        this.a = context;
        this.b = zzbnaVar;
        this.e = zzdroVar;
        this.d = zzdzcVar;
        this.c = zzacbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (this.c == null || zzdmuVar.r == null || zzdmuVar.r.a == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzbme> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        zzbmd a = this.b.a(new zzbos(zzdnjVar, zzdmuVar, null), new aaf(this, new View(this.a), null, aae.a, zzdmuVar.t.get(0)));
        return this.e.a((zzdro) zzdrl.CUSTOM_RENDER_SYN).a(new zzdqy(this, new zzabu(a.k(), zzdmuVar.r.b, zzdmuVar.r.a)) { // from class: com.google.android.gms.internal.ads.aag
            private final zzcwe a;
            private final zzabu b;

            {
                this.a = this;
                this.b = zzabuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqy
            public final void a() {
                this.a.a(this.b);
            }
        }, this.d).a((zzdrg<?>) zzdrl.CUSTOM_RENDER_ACK).a((zzdyz) zzdyr.a(a.h())).a();
    }

    final /* synthetic */ void a(zzabu zzabuVar) throws Exception {
        this.c.a(zzabuVar);
    }
}
