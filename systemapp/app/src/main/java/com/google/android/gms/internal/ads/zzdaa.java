package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdaa implements zzdfj<Bundle> {
    private final zzdnn a;

    public zzdaa(zzdnn zzdnnVar) {
        Preconditions.a(zzdnnVar, "the targeting must not be null");
        this.a = zzdnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzvk zzvkVar = this.a.d;
        bundle2.putInt("http_timeout_millis", this.a.d.w);
        bundle2.putString("slotname", this.a.f);
        switch (acg.a[this.a.n.a - 1]) {
            case 1:
                bundle2.putBoolean("is_new_rewarded", true);
                break;
            case 2:
                bundle2.putBoolean("is_rewarded_interstitial", true);
                break;
        }
        zzdnx.a(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzvkVar.b)), zzvkVar.b != -1);
        zzdnx.a(bundle2, "extras", zzvkVar.c);
        zzdnx.a(bundle2, "cust_gender", Integer.valueOf(zzvkVar.d), zzvkVar.d != -1);
        zzdnx.a(bundle2, "kw", zzvkVar.e);
        zzdnx.a(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzvkVar.g), zzvkVar.g != -1);
        if (zzvkVar.f) {
            bundle2.putBoolean("test_request", zzvkVar.f);
        }
        zzdnx.a(bundle2, "d_imp_hdr", (Integer) 1, zzvkVar.a >= 2 && zzvkVar.h);
        zzdnx.a(bundle2, "ppid", zzvkVar.i, zzvkVar.a >= 2 && !TextUtils.isEmpty(zzvkVar.i));
        if (zzvkVar.k != null) {
            Location location = zzvkVar.k;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong("lat", valueOf3.longValue());
            bundle3.putLong("long", valueOf4.longValue());
            bundle3.putLong("time", valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdnx.a(bundle2, "url", zzvkVar.l);
        zzdnx.a(bundle2, "neighboring_content_urls", zzvkVar.v);
        zzdnx.a(bundle2, "custom_targeting", zzvkVar.n);
        zzdnx.a(bundle2, "category_exclusions", zzvkVar.o);
        zzdnx.a(bundle2, "request_agent", zzvkVar.p);
        zzdnx.a(bundle2, "request_pkg", zzvkVar.q);
        zzdnx.a(bundle2, "is_designed_for_families", Boolean.valueOf(zzvkVar.r), zzvkVar.a >= 7);
        if (zzvkVar.a >= 8) {
            zzdnx.a(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzvkVar.t), zzvkVar.t != -1);
            zzdnx.a(bundle2, "max_ad_content_rating", zzvkVar.u);
        }
    }
}
