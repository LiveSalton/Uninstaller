package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class aaq implements zzdyo<zzbme> {
    final /* synthetic */ zzcxm a;
    private final /* synthetic */ zzbna b;

    aaq(zzcxm zzcxmVar, zzbna zzbnaVar) {
        this.a = zzcxmVar;
        this.b = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzbua zzbuaVar;
        zzbgm zzbgmVar;
        zzve a = this.b.b().a(th);
        synchronized (this.a) {
            zzcxm.a(this.a, (zzdyz) null);
            this.b.a().a_(a);
            if (((Boolean) zzwq.e().a(zzabf.en)).booleanValue()) {
                zzbgmVar = this.a.a;
                zzbgmVar.a().execute(new Runnable(this, a) { // from class: com.google.android.gms.internal.ads.aar
                    private final aaq a;
                    private final zzve b;

                    {
                        this.a = this;
                        this.b = a;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcxq zzcxqVar;
                        aaq aaqVar = this.a;
                        zzve zzveVar = this.b;
                        zzcxqVar = aaqVar.a.d;
                        zzcxqVar.a_(zzveVar);
                    }
                });
            }
            zzbuaVar = this.a.f;
            zzbuaVar.a(60);
            zzdob.a(a.a, th, "BannerAdManagerShim.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzbme zzbmeVar) {
        zzbme zzbmeVar2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzbua zzbuaVar;
        zzbgm zzbgmVar;
        zzcxq zzcxqVar;
        zzcxq zzcxqVar2;
        zzcyd zzcydVar;
        zzbme zzbmeVar3;
        zzbme zzbmeVar4 = zzbmeVar;
        synchronized (this.a) {
            zzcxm.a(this.a, (zzdyz) null);
            zzbmeVar2 = this.a.j;
            if (zzbmeVar2 != null) {
                zzbmeVar3 = this.a.j;
                zzbmeVar3.b();
            }
            this.a.j = zzbmeVar4;
            viewGroup = this.a.c;
            viewGroup.removeAllViews();
            if (zzbmeVar4.a() != null) {
                ViewParent parent = zzbmeVar4.a().getParent();
                if (parent instanceof ViewGroup) {
                    String k = this.a.k();
                    StringBuilder sb = new StringBuilder(78 + String.valueOf(k).length());
                    sb.append("Banner view provided from ");
                    sb.append(k);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzd.e(sb.toString());
                    ((ViewGroup) parent).removeView(zzbmeVar4.a());
                }
            }
            if (((Boolean) zzwq.e().a(zzabf.en)).booleanValue()) {
                zzbvn m = zzbmeVar4.m();
                zzcxqVar2 = this.a.d;
                zzbvn a = m.a(zzcxqVar2);
                zzcydVar = this.a.e;
                a.a(zzcydVar);
            }
            viewGroup2 = this.a.c;
            viewGroup2.addView(zzbmeVar4.a());
            zzbmeVar4.d_();
            if (((Boolean) zzwq.e().a(zzabf.en)).booleanValue()) {
                zzbgmVar = this.a.a;
                Executor a2 = zzbgmVar.a();
                zzcxqVar = this.a.d;
                zzcxqVar.getClass();
                a2.execute(aas.a(zzcxqVar));
            }
            zzbuaVar = this.a.f;
            zzbuaVar.a(zzbmeVar4.f());
        }
    }
}
