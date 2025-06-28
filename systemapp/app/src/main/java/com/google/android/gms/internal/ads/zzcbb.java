package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcbb implements zzccm {
    private final Context a;
    private final zzccl b;
    private final JSONObject c;
    private final zzcgh d;
    private final zzcce e;
    private final zzef f;
    private final zzbsl g;
    private final zzbrt h;
    private final zzdmu i;
    private final zzazh j;
    private final zzdnn k;
    private final zzbki l;
    private final zzcdd m;
    private final Clock n;
    private final zzbxx o;
    private final zzdrz p;
    private boolean r;
    private zzxz y;
    private boolean q = false;
    private boolean s = false;
    private boolean t = false;
    private Point u = new Point();
    private Point v = new Point();
    private long w = 0;
    private long x = 0;

    public zzcbb(Context context, zzccl zzcclVar, JSONObject jSONObject, zzcgh zzcghVar, zzcce zzcceVar, zzef zzefVar, zzbsl zzbslVar, zzbrt zzbrtVar, zzdmu zzdmuVar, zzazh zzazhVar, zzdnn zzdnnVar, zzbki zzbkiVar, zzcdd zzcddVar, Clock clock, zzbxx zzbxxVar, zzdrz zzdrzVar) {
        this.a = context;
        this.b = zzcclVar;
        this.c = jSONObject;
        this.d = zzcghVar;
        this.e = zzcceVar;
        this.f = zzefVar;
        this.g = zzbslVar;
        this.h = zzbrtVar;
        this.i = zzdmuVar;
        this.j = zzazhVar;
        this.k = zzdnnVar;
        this.l = zzbkiVar;
        this.m = zzcddVar;
        this.n = clock;
        this.o = zzbxxVar;
        this.p = zzdrzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.u = new Point();
        this.v = new Point();
        if (!this.r) {
            this.o.a(view);
            this.r = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.l.a(this);
        boolean a = com.google.android.gms.ads.internal.util.zzbq.a(this.j.c);
        if (map != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = it.next().getValue().get();
                if (view2 != null) {
                    if (a) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = it2.next().getValue().get();
                if (view3 != null) {
                    if (a) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, Map<String, WeakReference<View>> map) {
        this.u = new Point();
        this.v = new Point();
        this.o.b(view);
        this.r = false;
    }

    private final boolean b(String str) {
        JSONObject optJSONObject = this.c.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject a = com.google.android.gms.ads.internal.util.zzbq.a(this.a, map, map2, view2);
        JSONObject a2 = com.google.android.gms.ads.internal.util.zzbq.a(this.a, view2);
        JSONObject a3 = com.google.android.gms.ads.internal.util.zzbq.a(view2);
        JSONObject b = com.google.android.gms.ads.internal.util.zzbq.b(this.a, view2);
        String b2 = b(view, map);
        a(((Boolean) zzwq.e().a(zzabf.bw)).booleanValue() ? view2 : view, a2, a, a3, b, b2, com.google.android.gms.ads.internal.util.zzbq.a(b2, this.a, this.v, this.u), null, z, false);
    }

    private final String b(View view, Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int a = this.e.a();
        if (a == 6) {
            return "3099";
        }
        switch (a) {
            case 1:
                return "1099";
            case 2:
                return "2099";
            case 3:
                return null;
            default:
                return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(String str) {
        a(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(Bundle bundle) {
        if (bundle == null) {
            zzd.b("Click data is null. No click is reported.");
        } else if (!b("click_reporting")) {
            zzd.c("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            a(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, zzp.c().a(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.t) {
            zzd.b("Custom click reporting failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!h()) {
            zzd.b("Custom click reporting failed. Ad unit id not whitelisted.");
            return;
        }
        JSONObject a = com.google.android.gms.ads.internal.util.zzbq.a(this.a, map, map2, view);
        JSONObject a2 = com.google.android.gms.ads.internal.util.zzbq.a(this.a, view);
        JSONObject a3 = com.google.android.gms.ads.internal.util.zzbq.a(view);
        JSONObject b = com.google.android.gms.ads.internal.util.zzbq.b(this.a, view);
        String b2 = b(null, map);
        a(view, a2, a, a3, b, b2, com.google.android.gms.ads.internal.util.zzbq.a(b2, this.a, this.v, this.u), null, z, true);
    }

    private final boolean h() {
        return this.c.optBoolean("allow_custom_click_gesture", false);
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a() {
        this.t = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final boolean b() {
        return h();
    }

    @VisibleForTesting
    private final void a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.b("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.c);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.b.b(this.e.u()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.e.a());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.k.i != null && this.k.i.g);
            jSONObject8.put("custom_mute_enabled", (this.e.h().isEmpty() || this.e.i() == null) ? false : true);
            if (this.m.a() != null && this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.n.a());
            if (this.t && h()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.b.b(this.e.u()) != null);
            jSONObject8.put("click_signals", b(view));
            if (((Boolean) zzwq.e().a(zzabf.ch)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long a = this.n.a();
            jSONObject9.put("time_from_last_touch_down", a - this.w);
            jSONObject9.put("time_from_last_touch", a - this.x);
            jSONObject7.put("touch_signal", jSONObject9);
            zzazm.a(this.d.a("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzd.c("Unable to create click JSON.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view, MotionEvent motionEvent, View view2) {
        this.u = com.google.android.gms.ads.internal.util.zzbq.a(motionEvent, view2);
        long a = this.n.a();
        this.x = a;
        if (motionEvent.getAction() == 0) {
            this.w = a;
            this.v = this.u;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(this.u.x, this.u.y);
        this.f.a(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void b(Bundle bundle) {
        if (bundle == null) {
            zzd.b("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!b("touch_reporting")) {
            zzd.c("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.f.a().a((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final JSONObject a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        JSONObject a = com.google.android.gms.ads.internal.util.zzbq.a(this.a, map, map2, view);
        JSONObject a2 = com.google.android.gms.ads.internal.util.zzbq.a(this.a, view);
        JSONObject a3 = com.google.android.gms.ads.internal.util.zzbq.a(view);
        JSONObject b = com.google.android.gms.ads.internal.util.zzbq.b(this.a, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", a);
            jSONObject.put("ad_view_signal", a2);
            jSONObject.put("scroll_view_signal", a3);
            jSONObject.put("lock_screen_signal", b);
            return jSONObject;
        } catch (JSONException e) {
            zzd.c("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void c() {
        a(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(View view) {
        if (!this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzd.e("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcdd zzcddVar = this.m;
        if (view != null) {
            view.setOnClickListener(zzcddVar);
            view.setClickable(true);
            zzcddVar.c = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(zzage zzageVar) {
        if (!this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzd.e("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.m.a(zzageVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void d() {
        if (this.c.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.m.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(zzyd zzydVar) {
        try {
            if (this.s) {
                return;
            }
            if (zzydVar == null && this.e.i() != null) {
                this.s = true;
                this.p.a(this.e.i().b());
                e();
            } else {
                this.s = true;
                this.p.a(zzydVar.b());
                e();
            }
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void a(zzxz zzxzVar) {
        this.y = zzxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void e() {
        try {
            if (this.y != null) {
                this.y.a();
            }
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void b(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        a(com.google.android.gms.ads.internal.util.zzbq.a(this.a, view), com.google.android.gms.ads.internal.util.zzbq.a(this.a, map, map2, view), com.google.android.gms.ads.internal.util.zzbq.a(view), com.google.android.gms.ads.internal.util.zzbq.b(this.a, view), c(view), null, com.google.android.gms.ads.internal.util.zzbq.a(this.a, this.i));
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void f() {
        Preconditions.b("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.c);
            zzazm.a(this.d.a("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzaza.c("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final boolean c(Bundle bundle) {
        if (!b("impression_reporting")) {
            zzd.c("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return a(null, null, null, null, null, zzp.c().a(bundle, (JSONObject) null), false);
    }

    private final boolean a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        Preconditions.b("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.c);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzwq.e().a(zzabf.bv)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", com.google.android.gms.ads.internal.util.zzbq.a(this.a));
            if (((Boolean) zzwq.e().a(zzabf.eD)).booleanValue()) {
                this.d.a("/clickRecorded", new qs(this));
            } else {
                this.d.a("/logScionEvent", new qp(this));
            }
            this.d.a("/nativeImpression", new qr(this));
            zzazm.a(this.d.a("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.q || this.i.B == null) {
                return true;
            }
            this.q |= zzp.m().b(this.a, this.j.a, this.i.B.toString(), this.k.f);
            return true;
        } catch (JSONException e) {
            zzd.c("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final String b(View view) {
        try {
            JSONObject optJSONObject = this.c.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.f.a().a(this.a, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzd.c("Exception obtaining click signals", e);
            return null;
        }
    }

    private final String c(View view) {
        if (!((Boolean) zzwq.e().a(zzabf.bv)).booleanValue()) {
            return null;
        }
        try {
            return this.f.a().a(this.a, view, (Activity) null);
        } catch (Exception unused) {
            zzd.c("Exception getting data.");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void g() {
        this.d.b();
    }
}
