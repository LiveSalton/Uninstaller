package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvo implements zzcrh<zzchc, zzdoe, zzcsw> {
    private final Context a;
    private final Executor b;
    private final zzchf c;

    public zzcvo(Context context, Executor executor, zzchf zzchfVar) {
        this.a = context;
        this.b = executor;
        this.c = zzchfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcsw> zzcrbVar) throws zzdnr {
        if (!zzcrbVar.b.g()) {
            zzcrbVar.c.a(new zz(this, zzdnjVar, zzdmuVar, zzcrbVar));
            zzcrbVar.b.a(this.a, zzdnjVar.a.a.d, (String) null, zzcrbVar.c, zzdmuVar.u.toString());
            return;
        }
        c(zzdnjVar, zzdmuVar, zzcrbVar);
    }

    public static void c(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcsw> zzcrbVar) {
        try {
            zzcrbVar.b.a(zzdnjVar.a.a.d, zzdmuVar.u.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrbVar.a);
            zzd.d(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzchc b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcsw> zzcrbVar) throws zzdnr, zzcuq {
        zzche a = this.c.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzchd(new zzcaf(zzcrbVar) { // from class: com.google.android.gms.internal.ads.zx
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
                    ((zzdoe) zzcrbVar2.b).f();
                } catch (zzdnr e) {
                    zzd.d("Cannot show rewarded video.", e);
                    throw new zzcai(e.getCause());
                }
            }
        }));
        a.a().a((zzbso) new zzbjt(zzcrbVar.b), this.b);
        zzbsu b = a.b();
        zzbrt c = a.c();
        zzcrbVar.c.a((zzauw) new aaa(this, a.i(), c, b, a.k()));
        return a.h();
    }
}
