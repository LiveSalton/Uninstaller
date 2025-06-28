package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcdq {
    private final zzchp a;
    private final zzcgh b;
    private ViewTreeObserver.OnScrollChangedListener c = null;

    public zzcdq(zzchp zzchpVar, zzcgh zzcghVar) {
        this.a = zzchpVar;
        this.b = zzcghVar;
    }

    public final View a(View view, WindowManager windowManager) throws zzbeh {
        zzbdv a = this.a.a(zzvn.a());
        a.getView().setVisibility(4);
        a.getView().setContentDescription("policy_validator");
        a.a("/sendMessageToSdk", new zzahv(this) { // from class: com.google.android.gms.internal.ads.rm
            private final zzcdq a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.a((zzbdv) obj, map);
            }
        });
        a.a("/hideValidatorOverlay", new zzahv(this, windowManager, view) { // from class: com.google.android.gms.internal.ads.ro
            private final zzcdq a;
            private final WindowManager b;
            private final View c;

            {
                this.a = this;
                this.b = windowManager;
                this.c = view;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.a(this.b, this.c, (zzbdv) obj, map);
            }
        });
        a.a("/open", new zzahz(null, null, null, null));
        this.b.a(new WeakReference(a), "/loadNativeAdPolicyViolations", new zzahv(this, view, windowManager) { // from class: com.google.android.gms.internal.ads.rn
            private final zzcdq a;
            private final View b;
            private final WindowManager c;

            {
                this.a = this;
                this.b = view;
                this.c = windowManager;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.a(this.b, this.c, (zzbdv) obj, map);
            }
        });
        this.b.a(new WeakReference(a), "/showValidatorOverlay", rq.a);
        return a.getView();
    }

    private static int a(Context context, String str, int i) {
        int i2;
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i2 = i;
        }
        zzwq.a();
        return zzayr.a(context, i2);
    }

    final /* synthetic */ void a(View view, WindowManager windowManager, zzbdv zzbdvVar, Map map) {
        int i;
        zzbdvVar.z().a(new zzbfj(this, map) { // from class: com.google.android.gms.internal.ads.rr
            private final zzcdq a;
            private final Map b;

            {
                this.a = this;
                this.b = map;
            }

            @Override // com.google.android.gms.internal.ads.zzbfj
            public final void a(boolean z) {
                this.a.a(this.b, z);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int a = a(context, (String) map.get("validator_width"), ((Integer) zzwq.e().a(zzabf.ej)).intValue());
        int a2 = a(context, (String) map.get("validator_height"), ((Integer) zzwq.e().a(zzabf.ek)).intValue());
        int a3 = a(context, (String) map.get("validator_x"), 0);
        int a4 = a(context, (String) map.get("validator_y"), 0);
        zzbdvVar.a(zzbfn.a(a, a2));
        try {
            zzbdvVar.getWebView().getSettings().setUseWideViewPort(((Boolean) zzwq.e().a(zzabf.el)).booleanValue());
            zzbdvVar.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzwq.e().a(zzabf.em)).booleanValue());
        } catch (NullPointerException unused) {
        }
        WindowManager.LayoutParams a5 = com.google.android.gms.ads.internal.util.zzbq.a();
        a5.x = a3;
        a5.y = a4;
        windowManager.updateViewLayout(zzbdvVar.getView(), a5);
        String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            if ("1".equals(str) || "2".equals(str)) {
                i = rect.bottom - a4;
            } else {
                i = rect.top - a4;
            }
            this.c = new ViewTreeObserver.OnScrollChangedListener(view, zzbdvVar, str, a5, i, windowManager) { // from class: com.google.android.gms.internal.ads.rp
                private final View a;
                private final zzbdv b;
                private final String c;
                private final WindowManager.LayoutParams d;
                private final int e;
                private final WindowManager f;

                {
                    this.a = view;
                    this.b = zzbdvVar;
                    this.c = str;
                    this.d = a5;
                    this.e = i;
                    this.f = windowManager;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    View view2 = this.a;
                    zzbdv zzbdvVar2 = this.b;
                    String str2 = this.c;
                    WindowManager.LayoutParams layoutParams = this.d;
                    int i3 = this.e;
                    WindowManager windowManager2 = this.f;
                    Rect rect2 = new Rect();
                    if (!view2.getGlobalVisibleRect(rect2) || zzbdvVar2.getView().getWindowToken() == null) {
                        return;
                    }
                    if ("1".equals(str2) || "2".equals(str2)) {
                        layoutParams.y = rect2.bottom - i3;
                    } else {
                        layoutParams.y = rect2.top - i3;
                    }
                    windowManager2.updateViewLayout(zzbdvVar2.getView(), layoutParams);
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.c);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbdvVar.loadUrl(str2);
    }

    final /* synthetic */ void a(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.b.a("sendMessageToNativeJs", hashMap);
    }

    final /* synthetic */ void a(WindowManager windowManager, View view, zzbdv zzbdvVar, Map map) {
        zzd.b("Hide native ad policy validator overlay.");
        zzbdvVar.getView().setVisibility(8);
        if (zzbdvVar.getView().getWindowToken() != null) {
            windowManager.removeView(zzbdvVar.getView());
        }
        zzbdvVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.c == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.c);
    }

    final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        this.b.a("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
