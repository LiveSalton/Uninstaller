package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcln implements AppEventListener, zzbru, zzbrz, zzbsm, zzbsp, zzbtj, zzbui, zzdru, zzva {
    private final List<Object> a;
    private final zzclb b;
    private long c;

    public zzcln(zzclb zzclbVar, zzbgm zzbgmVar) {
        this.b = zzclbVar;
        this.a = Collections.singletonList(zzbgmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzdnj zzdnjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void a(Context context) {
        a(zzbsp.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void b(Context context) {
        a(zzbsp.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void c(Context context) {
        a(zzbsp.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void a(String str, String str2) {
        a(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        long b = zzp.j().b() - this.c;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(b);
        zzd.a(sb.toString());
        a(zzbtj.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        a(zzbrz.class, "onAdFailedToLoad", Integer.valueOf(zzveVar.a), zzveVar.b, zzveVar.c);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
        a(zzbru.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
        a(zzbru.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
        a(zzbru.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        a(zzva.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        a(zzbsm.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
        a(zzbru.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    @ParametersAreNonnullByDefault
    public final void a(zzauf zzaufVar, String str, String str2) {
        a(zzbru.class, "onRewarded", zzaufVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
        a(zzbru.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str) {
        a(zzdrm.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void b(zzdrl zzdrlVar, String str) {
        a(zzdrm.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str, Throwable th) {
        a(zzdrm.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void c(zzdrl zzdrlVar, String str) {
        a(zzdrm.class, "onTaskSucceeded", str);
    }

    private final void a(Class<?> cls, String str, Object... objArr) {
        zzclb zzclbVar = this.b;
        List<Object> list = this.a;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzclbVar.a(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzatl zzatlVar) {
        this.c = zzp.j().b();
        a(zzbui.class, "onAdRequest", new Object[0]);
    }
}
