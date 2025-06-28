package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcda {
    private final zzf a;
    private final zzdnn b;
    private final zzcci c;
    private final zzcce d;
    private final zzcdi e;
    private final zzcdq f;
    private final Executor g;
    private final Executor h;
    private final zzadz i;
    private final zzcbz j;

    public zzcda(zzf zzfVar, zzdnn zzdnnVar, zzcci zzcciVar, zzcce zzcceVar, zzcdi zzcdiVar, zzcdq zzcdqVar, Executor executor, Executor executor2, zzcbz zzcbzVar) {
        this.a = zzfVar;
        this.b = zzdnnVar;
        this.i = zzdnnVar.i;
        this.c = zzcciVar;
        this.d = zzcceVar;
        this.e = zzcdiVar;
        this.f = zzcdqVar;
        this.g = executor;
        this.h = executor2;
        this.j = zzcbzVar;
    }

    public final void a(zzcdy zzcdyVar) {
        this.g.execute(new Runnable(this, zzcdyVar) { // from class: com.google.android.gms.internal.ads.rb
            private final zzcda a;
            private final zzcdy b;

            {
                this.a = this;
                this.b = zzcdyVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(this.b);
            }
        });
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            return;
        }
        switch (i) {
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
        }
    }

    public final void b(zzcdy zzcdyVar) {
        if (zzcdyVar == null || this.e == null || zzcdyVar.b() == null || !this.c.b()) {
            return;
        }
        try {
            zzcdyVar.b().addView(this.e.a());
        } catch (zzbeh e) {
            zzd.a("web view can not be obtained", e);
        }
    }

    public final void c(zzcdy zzcdyVar) {
        if (zzcdyVar == null) {
            return;
        }
        Context context = zzcdyVar.c().getContext();
        if (com.google.android.gms.ads.internal.util.zzbq.a(context, this.c.a)) {
            if (!(context instanceof Activity)) {
                zzd.b("Activity context is needed for policy validator.");
                return;
            }
            if (this.f == null || zzcdyVar.b() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(this.f.a(zzcdyVar.b(), windowManager), com.google.android.gms.ads.internal.util.zzbq.a());
            } catch (zzbeh e) {
                zzd.a("web view can not be obtained", e);
            }
        }
    }

    public static boolean a(zzcdy zzcdyVar, String[] strArr) {
        Map<String, WeakReference<View>> f = zzcdyVar.f();
        if (f == null) {
            return false;
        }
        for (String str : strArr) {
            if (f.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View m = this.d.m();
        if (m == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (m.getParent() instanceof ViewGroup) {
            ((ViewGroup) m.getParent()).removeView(m);
        }
        if (((Boolean) zzwq.e().a(zzabf.bI)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(m, layoutParams);
        return true;
    }

    final /* synthetic */ void b(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.d.m() != null) {
            if (2 == this.d.a() || 1 == this.d.a()) {
                this.a.a(this.b.f, String.valueOf(this.d.a()), z);
            } else if (6 == this.d.a()) {
                this.a.a(this.b.f, "2", z);
                this.a.a(this.b.f, "1", z);
            }
        }
    }

    final /* synthetic */ void d(zzcdy zzcdyVar) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        IObjectWrapper a;
        Drawable drawable;
        int i = 0;
        if (this.c.e() || this.c.c()) {
            String[] strArr = {"1098", "3011"};
            for (int i2 = 0; i2 < 2; i2++) {
                View a_ = zzcdyVar.a_(strArr[i2]);
                if (a_ != null && (a_ instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) a_;
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        Context context = zzcdyVar.c().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.d.d() != null) {
            view = this.d.d();
            if (this.i != null && !z) {
                a(layoutParams, this.i.e);
                view.setLayoutParams(layoutParams);
            }
        } else if (this.d.c() instanceof zzadq) {
            zzadq zzadqVar = (zzadq) this.d.c();
            if (!z) {
                a(layoutParams, zzadqVar.h());
            }
            View zzadtVar = new zzadt(context, zzadqVar, layoutParams);
            zzadtVar.setContentDescription((CharSequence) zzwq.e().a(zzabf.bG));
            view = zzadtVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcdyVar.c().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout b = zzcdyVar.b();
                if (b != null) {
                    b.addView(adChoicesView);
                }
            }
            zzcdyVar.a(zzcdyVar.h(), view, true);
        }
        String[] strArr2 = zzccy.a;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View a_2 = zzcdyVar.a_(strArr2[i]);
            if (a_2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) a_2;
                break;
            }
            i++;
        }
        this.h.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.re
            private final zzcda a;
            private final ViewGroup b;

            {
                this.a = this;
                this.b = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(this.b);
            }
        });
        if (viewGroup2 != null) {
            if (a(viewGroup2)) {
                if (this.d.v() != null) {
                    this.d.v().a(new rd(this, zzcdyVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View c = zzcdyVar.c();
            Context context2 = c != null ? c.getContext() : null;
            if (context2 != null) {
                if (((Boolean) zzwq.e().a(zzabf.bF)).booleanValue()) {
                    zzaee a2 = this.j.a();
                    if (a2 == null) {
                        return;
                    }
                    try {
                        a = a2.b();
                    } catch (RemoteException unused) {
                        zzd.e("Could not get main image drawable");
                        return;
                    }
                } else {
                    zzaej g = this.d.g();
                    if (g == null) {
                        return;
                    }
                    try {
                        a = g.a();
                    } catch (RemoteException unused2) {
                        zzd.e("Could not get drawable from image");
                        return;
                    }
                }
                if (a == null || (drawable = (Drawable) ObjectWrapper.a(a)) == null) {
                    return;
                }
                ImageView imageView = new ImageView(context2);
                imageView.setImageDrawable(drawable);
                IObjectWrapper i3 = zzcdyVar != null ? zzcdyVar.i() : null;
                if (i3 != null) {
                    if (((Boolean) zzwq.e().a(zzabf.dr)).booleanValue()) {
                        imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.a(i3));
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        viewGroup2.addView(imageView);
                    }
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                viewGroup2.addView(imageView);
            }
        }
    }
}
