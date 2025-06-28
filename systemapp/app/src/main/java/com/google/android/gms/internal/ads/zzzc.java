package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzzc {
    private final zzanj a;
    private final zzvl b;
    private final AtomicBoolean c;
    private final VideoController d;

    @VisibleForTesting
    private final zzwp e;
    private zzva f;
    private AdListener g;
    private AdSize[] h;
    private AppEventListener i;
    private zzxg j;
    private OnCustomRenderedAdLoadedListener k;
    private VideoOptions l;
    private String m;
    private ViewGroup n;
    private int o;
    private boolean p;
    private OnPaidEventListener q;

    private static boolean a(int i) {
        return i == 1;
    }

    public zzzc(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzvl.a, 0);
    }

    public zzzc(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzvl.a, i);
    }

    public zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvl.a, 0);
    }

    public zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvl.a, i);
    }

    @VisibleForTesting
    private zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvlVar, zzxg zzxgVar, int i) {
        zzvn zzvnVar;
        this.a = new zzanj();
        this.d = new VideoController();
        this.e = new bej(this);
        this.n = viewGroup;
        this.b = zzvlVar;
        this.j = null;
        this.c = new AtomicBoolean(false);
        this.o = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvy zzvyVar = new zzvy(context, attributeSet);
                this.h = zzvyVar.a(z);
                this.m = zzvyVar.a();
                if (viewGroup.isInEditMode()) {
                    zzayr a = zzwq.a();
                    AdSize adSize = this.h[0];
                    int i2 = this.o;
                    if (adSize.equals(AdSize.i)) {
                        zzvnVar = zzvn.d();
                    } else {
                        zzvn zzvnVar2 = new zzvn(context, adSize);
                        zzvnVar2.j = a(i2);
                        zzvnVar = zzvnVar2;
                    }
                    a.a(viewGroup, zzvnVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzwq.a().a(viewGroup, new zzvn(context, AdSize.a), e.getMessage(), e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvlVar, int i) {
        this(viewGroup, attributeSet, z, zzvlVar, null, i);
    }

    public final void a() {
        try {
            if (this.j != null) {
                this.j.b();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final AdListener b() {
        return this.g;
    }

    public final AdSize c() {
        zzvn j;
        try {
            if (this.j != null && (j = this.j.j()) != null) {
                return j.e();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        if (this.h != null) {
            return this.h[0];
        }
        return null;
    }

    public final AdSize[] d() {
        return this.h;
    }

    public final String e() {
        if (this.m == null && this.j != null) {
            try {
                this.m = this.j.n();
            } catch (RemoteException e) {
                zzaza.e("#007 Could not call remote method.", e);
            }
        }
        return this.m;
    }

    public final AppEventListener f() {
        return this.i;
    }

    public final OnCustomRenderedAdLoadedListener g() {
        return this.k;
    }

    public final void a(zzza zzzaVar) {
        zzxg a;
        try {
            if (this.j == null) {
                if ((this.h == null || this.m == null) && this.j == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.n.getContext();
                zzvn a2 = a(context, this.h, this.o);
                if ("search_v2".equals(a2.a)) {
                    a = new bed(zzwq.b(), context, a2, this.m).a(context, false);
                } else {
                    a = new bdx(zzwq.b(), context, a2, this.m, this.a).a(context, false);
                }
                this.j = a;
                this.j.a(new zzvg(this.e));
                if (this.f != null) {
                    this.j.a(new zzuz(this.f));
                }
                if (this.i != null) {
                    this.j.a(new zzvt(this.i));
                }
                if (this.k != null) {
                    this.j.a(new zzacc(this.k));
                }
                if (this.l != null) {
                    this.j.a(new zzaak(this.l));
                }
                this.j.a(new zzaaf(this.q));
                this.j.a(this.p);
                try {
                    IObjectWrapper a3 = this.j.a();
                    if (a3 != null) {
                        this.n.addView((View) ObjectWrapper.a(a3));
                    }
                } catch (RemoteException e) {
                    zzaza.e("#007 Could not call remote method.", e);
                }
            }
            if (this.j.a(zzvl.a(this.n.getContext(), zzzaVar))) {
                this.a.a(zzzaVar.k());
            }
        } catch (RemoteException e2) {
            zzaza.e("#007 Could not call remote method.", e2);
        }
    }

    public final void h() {
        try {
            if (this.j != null) {
                this.j.d();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void i() {
        try {
            if (this.j != null) {
                this.j.e();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(AdListener adListener) {
        this.g = adListener;
        this.e.a(adListener);
    }

    public final void a(zzva zzvaVar) {
        try {
            this.f = zzvaVar;
            if (this.j != null) {
                this.j.a(zzvaVar != null ? new zzuz(zzvaVar) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(AdSize... adSizeArr) {
        if (this.h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(adSizeArr);
    }

    public final void b(AdSize... adSizeArr) {
        this.h = adSizeArr;
        try {
            if (this.j != null) {
                this.j.a(a(this.n.getContext(), this.h, this.o));
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        this.n.requestLayout();
    }

    public final void a(String str) {
        if (this.m != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.m = str;
    }

    public final void a(AppEventListener appEventListener) {
        try {
            this.i = appEventListener;
            if (this.j != null) {
                this.j.a(appEventListener != null ? new zzvt(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.k = onCustomRenderedAdLoadedListener;
        try {
            if (this.j != null) {
                this.j.a(onCustomRenderedAdLoadedListener != null ? new zzacc(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final void a(boolean z) {
        this.p = z;
        try {
            if (this.j != null) {
                this.j.a(this.p);
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final String j() {
        try {
            if (this.j != null) {
                return this.j.l();
            }
            return null;
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final ResponseInfo k() {
        zzyn zzynVar = null;
        try {
            if (this.j != null) {
                zzynVar = this.j.m();
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        return ResponseInfo.a(zzynVar);
    }

    public final void a(OnPaidEventListener onPaidEventListener) {
        try {
            this.q = onPaidEventListener;
            if (this.j != null) {
                this.j.a(new zzaaf(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzaza.e("#008 Must be called on the main UI thread.", e);
        }
    }

    public final VideoController l() {
        return this.d;
    }

    public final zzys m() {
        if (this.j == null) {
            return null;
        }
        try {
            return this.j.r();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void a(VideoOptions videoOptions) {
        this.l = videoOptions;
        try {
            if (this.j != null) {
                this.j.a(videoOptions == null ? null : new zzaak(videoOptions));
            }
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions n() {
        return this.l;
    }

    public final boolean a(zzxg zzxgVar) {
        if (zzxgVar == null) {
            return false;
        }
        try {
            IObjectWrapper a = zzxgVar.a();
            if (a == null || ((View) ObjectWrapper.a(a)).getParent() != null) {
                return false;
            }
            this.n.addView((View) ObjectWrapper.a(a));
            this.j = zzxgVar;
            return true;
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzvn a(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.i)) {
                return zzvn.d();
            }
        }
        zzvn zzvnVar = new zzvn(context, adSizeArr);
        zzvnVar.j = a(i);
        return zzvnVar;
    }
}
