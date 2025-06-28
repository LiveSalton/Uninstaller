package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzctg implements zzcrh<zzbyx, zzdoe, zzcst> {
    private final Context a;
    private final zzbzx b;
    private final zzazh c;
    private final Executor d;

    public zzctg(Context context, zzazh zzazhVar, zzbzx zzbzxVar, Executor executor) {
        this.a = context;
        this.c = zzazhVar;
        this.b = zzbzxVar;
        this.d = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr {
        if (this.c.c < 4100000) {
            zzcrbVar.b.a(this.a, zzdnjVar.a.a.d, zzdmuVar.u.toString(), zzcrbVar.c);
        } else {
            zzcrbVar.b.a(this.a, zzdnjVar.a.a.d, zzdmuVar.u.toString(), com.google.android.gms.ads.internal.util.zzbk.a((zzbl) zzdmuVar.r), zzcrbVar.c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbyx b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        zzbyz a = this.b.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzbzc(new zzcaf(zzcrbVar) { // from class: com.google.android.gms.internal.ads.za
            private final zzcrb a;

            {
                this.a = zzcrbVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.internal.ads.zzcaf
            public final void a(boolean z, Context context) {
                zzcrb zzcrbVar2 = this.a;
                try {
                    ((zzdoe) zzcrbVar2.b).a(z);
                    ((zzdoe) zzcrbVar2.b).b();
                } catch (zzdnr e) {
                    zzd.d("Cannot show interstitial.");
                    throw new zzcai(e.getCause());
                }
            }
        }));
        a.a().a((zzbso) new zzbjt(zzcrbVar.b), this.d);
        zzcrbVar.c.a((zzano) a.f());
        return a.h();
    }
}
