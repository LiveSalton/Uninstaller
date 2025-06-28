package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvl {
    public static final zzvl a = new zzvl();

    @VisibleForTesting
    protected zzvl() {
    }

    public static zzvk a(Context context, zzza zzzaVar) {
        Context context2;
        List list;
        zzvc zzvcVar;
        String str;
        Date a2 = zzzaVar.a();
        long time = a2 != null ? a2.getTime() : -1L;
        String b = zzzaVar.b();
        int d = zzzaVar.d();
        Set<String> e = zzzaVar.e();
        if (e.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(e));
            context2 = context;
        }
        boolean a3 = zzzaVar.a(context2);
        Location f = zzzaVar.f();
        Bundle a4 = zzzaVar.a(AdMobAdapter.class);
        if (zzzaVar.q() != null) {
            zzvcVar = new zzvc(zzzaVar.q().b(), zzwq.i().containsKey(zzzaVar.q().a()) ? zzwq.i().get(zzzaVar.q().a()) : "");
        } else {
            zzvcVar = null;
        }
        boolean g = zzzaVar.g();
        String h = zzzaVar.h();
        SearchAdRequest j = zzzaVar.j();
        zzaag zzaagVar = j != null ? new zzaag(j) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwq.a();
            str = zzayr.a(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean p = zzzaVar.p();
        RequestConfiguration d2 = zzzd.a().d();
        return new zzvk(8, time, a4, d, list, a3, Math.max(zzzaVar.m(), d2.a()), g, h, zzaagVar, f, b, zzzaVar.l(), zzzaVar.n(), Collections.unmodifiableList(new ArrayList(zzzaVar.o())), zzzaVar.i(), str, p, zzvcVar, Math.max(zzzaVar.r(), d2.b()), (String) Collections.max(Arrays.asList(zzzaVar.s(), d2.c()), bdv.a), zzzaVar.c(), zzzaVar.t());
    }

    static final /* synthetic */ int a(String str, String str2) {
        return RequestConfiguration.a.indexOf(str) - RequestConfiguration.a.indexOf(str2);
    }
}
