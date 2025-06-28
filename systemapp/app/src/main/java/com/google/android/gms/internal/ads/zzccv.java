package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzccv extends zzaet implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdy {
    private final WeakReference<View> a;
    private final Map<String, WeakReference<View>> b = new HashMap();
    private final Map<String, WeakReference<View>> c = new HashMap();
    private final Map<String, WeakReference<View>> d = new HashMap();

    @GuardedBy("this")
    private zzcbt e;
    private zzqq f;

    public zzccv(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzp.z();
        zzazy.a(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.z();
        zzazy.a(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.a = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.b.put(key, new WeakReference<>(value));
                if (!"1098".equals(key) && !"3011".equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.d.putAll(this.b);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.c.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.d.putAll(this.c);
        this.f = new zzqq(view.getContext(), view);
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final FrameLayout b() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final synchronized void a() {
        if (this.e != null) {
            this.e.b(this);
            this.e = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final synchronized void a(IObjectWrapper iObjectWrapper) {
        Object a = ObjectWrapper.a(iObjectWrapper);
        if (!(a instanceof zzcbt)) {
            zzd.e("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.e != null) {
            this.e.b(this);
        }
        if (((zzcbt) a).g()) {
            this.e = (zzcbt) a;
            this.e.a(this);
            this.e.c(c());
            return;
        }
        zzd.c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final View c() {
        return this.a.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final zzqq d() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized void a(String str, View view, boolean z) {
        if (view == null) {
            this.d.remove(str);
            this.b.remove(str);
            this.c.remove(str);
            return;
        }
        this.d.put(str, new WeakReference<>(view));
        if (!"1098".equals(str) && !"3011".equals(str)) {
            this.b.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized Map<String, WeakReference<View>> e() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized Map<String, WeakReference<View>> f() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized Map<String, WeakReference<View>> g() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized View a_(String str) {
        WeakReference<View> weakReference = this.d.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized String h() {
        return "1007";
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized IObjectWrapper i() {
        return null;
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.e != null) {
            this.e.a(view, motionEvent, c());
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.e != null) {
            this.e.a(view, c(), e(), f(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.e != null) {
            this.e.a(c(), e(), f(), zzcbt.b(c()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.e != null) {
            this.e.a(c(), e(), f(), zzcbt.b(c()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final synchronized void b(IObjectWrapper iObjectWrapper) {
        if (this.e != null) {
            Object a = ObjectWrapper.a(iObjectWrapper);
            if (!(a instanceof View)) {
                zzd.e("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.e.a((View) a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized JSONObject j() {
        return null;
    }
}
