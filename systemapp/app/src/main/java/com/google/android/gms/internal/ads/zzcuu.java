package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcuu implements zzcrh<zzchc, zzdoe, zzcst> {
    private final Context a;
    private final Executor b;
    private final zzchf c;

    public zzcuu(Context context, Executor executor, zzchf zzchfVar) {
        this.a = context;
        this.b = executor;
        this.c = zzchfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr {
        try {
            zzdnn zzdnnVar = zzdnjVar.a.a;
            if (zzdnnVar.n.a == zzdnf.c) {
                zzcrbVar.b.c(this.a, zzdnnVar.d, zzdmuVar.u.toString(), zzcrbVar.c);
            } else {
                zzcrbVar.b.b(this.a, zzdnnVar.d, zzdmuVar.u.toString(), zzcrbVar.c);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrbVar.a);
            zzd.d(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzchc b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        zzche a = this.c.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzchd(new zzcaf(zzcrbVar) { // from class: com.google.android.gms.internal.ads.zm
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
                    ((zzdoe) zzcrbVar2.b).b(context);
                } catch (zzdnr e) {
                    throw new zzcai(e.getCause());
                }
            }
        }));
        a.a().a((zzbso) new zzbjt(zzcrbVar.b), this.b);
        zzcrbVar.c.a((zzano) a.m());
        return a.h();
    }
}
