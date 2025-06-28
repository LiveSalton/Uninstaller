package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwj<AdT> implements zzcqz<AdT> {
    private final zzacb a;
    private final zzdzc b;
    private final zzdro c;
    private final zzcwo<AdT> d;

    public zzcwj(zzdro zzdroVar, zzdzc zzdzcVar, zzacb zzacbVar, zzcwo<AdT> zzcwoVar) {
        this.c = zzdroVar;
        this.b = zzdzcVar;
        this.a = zzacbVar;
        this.d = zzcwoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (this.a == null || zzdmuVar.r == null || zzdmuVar.r.a == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<AdT> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        zzazq zzazqVar = new zzazq();
        zzcwr zzcwrVar = new zzcwr();
        zzcwrVar.a(new aah(this, zzazqVar, zzdnjVar, zzdmuVar, zzcwrVar));
        return this.c.a((zzdro) zzdrl.CUSTOM_RENDER_SYN).a(new zzdqy(this, new zzabu(zzcwrVar, zzdmuVar.r.b, zzdmuVar.r.a)) { // from class: com.google.android.gms.internal.ads.aai
            private final zzcwj a;
            private final zzabu b;

            {
                this.a = this;
                this.b = zzabuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqy
            public final void a() {
                this.a.a(this.b);
            }
        }, this.b).a((zzdrg<?>) zzdrl.CUSTOM_RENDER_ACK).a((zzdyz) zzazqVar).a();
    }

    final /* synthetic */ void a(zzabu zzabuVar) throws Exception {
        this.a.a(zzabuVar);
    }
}
