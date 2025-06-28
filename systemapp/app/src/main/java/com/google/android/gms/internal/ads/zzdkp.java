package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkp {
    public static zzdkl<zzblg, zzbll> a(Context context, zzdpa zzdpaVar, zzdpr zzdprVar) {
        return c(context, zzdpaVar, zzdprVar);
    }

    public static zzdkl<zzblp, zzblv> b(Context context, zzdpa zzdpaVar, zzdpr zzdprVar) {
        return c(context, zzdpaVar, zzdprVar);
    }

    private static <AppOpenAdRequestComponent extends zzbre<AppOpenAd>, AppOpenAd extends zzboc> zzdkl<AppOpenAdRequestComponent, AppOpenAd> c(Context context, zzdpa zzdpaVar, zzdpr zzdprVar) {
        if (((Integer) zzwq.e().a(zzabf.dN)).intValue() > 0) {
            zzdpu a = zzdprVar.a(zzdpj.AppOpen, context, zzdpaVar, new agn(new zzdjk()));
            return new zzdjp(new zzdkc(new zzdkd()), new zzdju(a.a, zzazj.a), a.b, zzazj.a);
        }
        return new zzdkd();
    }
}
