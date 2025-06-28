package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzcud<AdT> implements zzcqz<AdT> {
    protected abstract zzdyz<AdT> a(zzdnn zzdnnVar, Bundle bundle);

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return !TextUtils.isEmpty(zzdmuVar.u.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<AdT> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        String optString = zzdmuVar.u.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdnn zzdnnVar = zzdnjVar.a.a;
        zzdnp a = new zzdnp().a(zzdnnVar).a(optString);
        Bundle a2 = a(zzdnnVar.d.m);
        Bundle a3 = a(a2.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        a3.putInt("gw", 1);
        String optString2 = zzdmuVar.u.optString("mad_hac", null);
        if (optString2 != null) {
            a3.putString("mad_hac", optString2);
        }
        String optString3 = zzdmuVar.u.optString("adJson", null);
        if (optString3 != null) {
            a3.putString("_ad", optString3);
        }
        a3.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdmuVar.C.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdmuVar.C.optString(next, null);
            if (next != null) {
                a3.putString(next, optString4);
            }
        }
        a2.putBundle("com.google.ads.mediation.admob.AdMobAdapter", a3);
        zzdnn e = a.a(new zzvk(zzdnnVar.d.a, zzdnnVar.d.b, a3, zzdnnVar.d.d, zzdnnVar.d.e, zzdnnVar.d.f, zzdnnVar.d.g, zzdnnVar.d.h, zzdnnVar.d.i, zzdnnVar.d.j, zzdnnVar.d.k, zzdnnVar.d.l, a2, zzdnnVar.d.n, zzdnnVar.d.o, zzdnnVar.d.p, zzdnnVar.d.q, zzdnnVar.d.r, zzdnnVar.d.s, zzdnnVar.d.t, zzdnnVar.d.u, zzdnnVar.d.v, zzdnnVar.d.w)).e();
        Bundle bundle = new Bundle();
        zzdmz zzdmzVar = zzdnjVar.b.b;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzdmzVar.a));
        bundle2.putInt("refresh_interval", zzdmzVar.c);
        bundle2.putString("gws_query_id", zzdmzVar.b);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdnjVar.a.a.f;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzdmuVar.v);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzdmuVar.c));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzdmuVar.d));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzdmuVar.o));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzdmuVar.m));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzdmuVar.g));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzdmuVar.h));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzdmuVar.i));
        bundle3.putString("transaction_id", zzdmuVar.j);
        bundle3.putString("valid_from_timestamp", zzdmuVar.k);
        bundle3.putBoolean("is_closable_area_disabled", zzdmuVar.K);
        if (zzdmuVar.l != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdmuVar.l.b);
            bundle4.putString("rb_type", zzdmuVar.l.a);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return a(e, bundle);
    }

    private static Bundle a(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
