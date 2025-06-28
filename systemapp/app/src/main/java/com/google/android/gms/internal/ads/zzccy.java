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
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccy extends zzaem implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdy {
    public static final String[] a = {"2011", "1009", "3010"};
    private final String b;
    private FrameLayout d;
    private FrameLayout e;
    private zzdzc f;
    private View g;

    @GuardedBy("this")
    private zzcbt i;
    private zzqq j;
    private zzaee l;
    private boolean m;

    @GuardedBy("this")
    private Map<String, WeakReference<View>> c = new HashMap();
    private IObjectWrapper k = null;
    private boolean n = false;
    private final int h = 203404000;

    public zzccy(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.d = frameLayout;
        this.e = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.b = str;
        zzp.z();
        zzazy.a((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.z();
        zzazy.a((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.f = zzazj.e;
        this.j = new zzqq(this.d.getContext(), this.d);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void a(String str, IObjectWrapper iObjectWrapper) {
        a(str, (View) ObjectWrapper.a(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized void a(String str, View view, boolean z) {
        if (this.n) {
            return;
        }
        if (view == null) {
            this.c.remove(str);
            return;
        }
        this.c.put(str, new WeakReference<>(view));
        if (!"1098".equals(str) && !"3011".equals(str)) {
            if (com.google.android.gms.ads.internal.util.zzbq.a(this.h)) {
                view.setOnTouchListener(this);
            }
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized IObjectWrapper a(String str) {
        return ObjectWrapper.a(a_(str));
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized View a_(String str) {
        if (this.n) {
            return null;
        }
        WeakReference<View> weakReference = this.c.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void a(IObjectWrapper iObjectWrapper) {
        if (this.n) {
            return;
        }
        Object a2 = ObjectWrapper.a(iObjectWrapper);
        if (!(a2 instanceof zzcbt)) {
            zzd.e("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        if (this.i != null) {
            this.i.b(this);
        }
        l();
        this.i = (zzcbt) a2;
        this.i.a(this);
        this.i.c(this.d);
        this.i.d(this.e);
        if (this.m) {
            this.i.n().a(this.l);
        }
    }

    private final synchronized void l() {
        this.f.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ra
            private final zzccy a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void a() {
        if (this.n) {
            return;
        }
        if (this.i != null) {
            this.i.b(this);
            this.i = null;
        }
        this.c.clear();
        this.d.removeAllViews();
        this.e.removeAllViews();
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.j = null;
        this.n = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void a(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.i != null) {
            this.i.c();
            this.i.a(view, this.d, e(), f(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.i != null) {
            this.i.a(view, motionEvent, this.d);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized JSONObject j() {
        if (this.i == null) {
            return null;
        }
        return this.i.a(this.d, e(), f());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.i != null) {
            this.i.a(this.d, e(), f(), zzcbt.b(this.d));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.i != null) {
            this.i.a(this.d, e(), f(), zzcbt.b(this.d));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized Map<String, WeakReference<View>> e() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized Map<String, WeakReference<View>> f() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized Map<String, WeakReference<View>> g() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final synchronized String h() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final FrameLayout b() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final zzqq d() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void b(IObjectWrapper iObjectWrapper) {
        this.i.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void d(IObjectWrapper iObjectWrapper) {
        if (this.n) {
            return;
        }
        this.k = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final IObjectWrapper i() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void c(IObjectWrapper iObjectWrapper) {
        onTouch(this.d, (MotionEvent) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final synchronized void a(zzaee zzaeeVar) {
        if (this.n) {
            return;
        }
        this.m = true;
        this.l = zzaeeVar;
        if (this.i != null) {
            this.i.n().a(zzaeeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdy
    public final /* synthetic */ View c() {
        return this.d;
    }

    final /* synthetic */ void k() {
        if (this.g == null) {
            this.g = new View(this.d.getContext());
            this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.d != this.g.getParent()) {
            this.d.addView(this.g);
        }
    }
}
