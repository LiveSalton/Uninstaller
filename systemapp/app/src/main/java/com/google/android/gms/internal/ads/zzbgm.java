package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbim;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzbgm implements zzbjl {

    @GuardedBy("AppComponent.class")
    private static zzbgm a;

    protected abstract zzdga a(zzdhn zzdhnVar);

    public abstract Executor a();

    public abstract ScheduledExecutorService b();

    public abstract Executor c();

    public abstract zzdzc d();

    public abstract zzbua e();

    public abstract zzciq f();

    public abstract zzbiu g();

    public abstract zzbmz h();

    public abstract zzblf i();

    public abstract zzbls j();

    public abstract zzdii k();

    public abstract zzcaa l();

    public abstract zzdlc m();

    public abstract zzcaw n();

    public abstract zzchi o();

    public abstract zzdmp p();

    public abstract zzcyy q();

    public abstract zzcyx r();

    public abstract zzcqy s();

    public abstract zzdod<zzcgh> t();

    public static zzbgm a(Context context, zzani zzaniVar, int i) {
        zzbgm a2 = a(context, i);
        a2.f().a(zzaniVar);
        return a2;
    }

    @Deprecated
    public static zzbgm a(Context context, int i) {
        synchronized (zzbgm.class) {
            if (a != null) {
                return a;
            }
            return a(new zzazh(203404000, i, true, false), context, new zzbhh());
        }
    }

    @Deprecated
    private static zzbgm a(zzazh zzazhVar, Context context, zzbim.zza zzaVar) {
        zzbgm zzbgmVar;
        synchronized (zzbgm.class) {
            if (a == null) {
                a = new zzbib().a(new zzbgl(new zzbgl.zza().a(zzazhVar).a(context))).a(new zzbim(zzaVar)).a();
                zzabf.a(context);
                zzp.g().a(context, zzazhVar);
                zzp.i().a(context);
                zzp.c().a(context);
                zzp.c().b(context);
                zzp.c();
                com.google.android.gms.ads.internal.util.zzm.q(context);
                com.google.android.gms.ads.internal.util.zzb.a(context);
                zzp.f().a(context);
                zzp.x().a(context);
                if (((Boolean) zzwq.e().a(zzabf.ds)).booleanValue()) {
                    new zzcqh(context, zzazhVar, new zzts(new zztx(context)), new zzcpr(new zzcpp(context), a.d())).a();
                }
            }
            zzbgmVar = a;
        }
        return zzbgmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjl
    public final zzdga a(zzatl zzatlVar, int i) {
        return a(new zzdhn(zzatlVar, i));
    }
}
