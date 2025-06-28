package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcft extends zzajm implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzads {
    private View a;
    private zzys b;
    private zzcbt c;
    private boolean d = false;
    private boolean e = false;

    public zzcft(zzcbt zzcbtVar, zzcce zzcceVar) {
        this.a = zzcceVar.m();
        this.b = zzcceVar.b();
        this.c = zzcbtVar;
        if (zzcceVar.v() != null) {
            zzcceVar.v().a(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final void a(IObjectWrapper iObjectWrapper, zzajo zzajoVar) throws RemoteException {
        Preconditions.b("#008 Must be called on the main UI thread.");
        if (this.d) {
            zzd.c("Instream ad can not be shown after destroy().");
            a(zzajoVar, 2);
            return;
        }
        if (this.a == null || this.b == null) {
            String valueOf = String.valueOf(this.a == null ? "can not get video view." : "can not get video controller.");
            zzd.c(valueOf.length() != 0 ? "Instream internal error: ".concat(valueOf) : new String("Instream internal error: "));
            a(zzajoVar, 0);
            return;
        }
        if (this.e) {
            zzd.c("Instream ad should not be used again.");
            a(zzajoVar, 1);
            return;
        }
        this.e = true;
        f();
        ((ViewGroup) ObjectWrapper.a(iObjectWrapper)).addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        zzp.z();
        zzazy.a(this.a, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.z();
        zzazy.a(this.a, (ViewTreeObserver.OnScrollChangedListener) this);
        g();
        try {
            zzajoVar.a();
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.b("#008 Must be called on the main UI thread.");
        a(iObjectWrapper, new sq(this));
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final zzys b() throws RemoteException {
        Preconditions.b("#008 Must be called on the main UI thread.");
        if (this.d) {
            zzd.c("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final zzaee d() {
        Preconditions.b("#008 Must be called on the main UI thread.");
        if (this.d) {
            zzd.c("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        if (this.c == null || this.c.n() == null) {
            return null;
        }
        return this.c.n().a();
    }

    @Override // com.google.android.gms.internal.ads.zzajn
    public final void c() throws RemoteException {
        Preconditions.b("#008 Must be called on the main UI thread.");
        f();
        if (this.c != null) {
            this.c.b();
        }
        this.c = null;
        this.a = null;
        this.b = null;
        this.d = true;
    }

    private final void f() {
        if (this.a == null) {
            return;
        }
        ViewParent parent = this.a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.a);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        g();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        g();
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final void a() {
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.sr
            private final zzcft a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }

    private final void g() {
        if (this.c == null || this.a == null) {
            return;
        }
        this.c.a(this.a, Collections.emptyMap(), Collections.emptyMap(), zzcbt.b(this.a));
    }

    private static void a(zzajo zzajoVar, int i) {
        try {
            zzajoVar.a(i);
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    final /* synthetic */ void e() {
        try {
            c();
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }
}
