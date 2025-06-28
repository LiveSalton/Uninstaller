package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbax {
    private final Context a;
    private final zzbbe b;
    private final ViewGroup c;
    private zzbar d;

    public zzbax(Context context, ViewGroup viewGroup, zzbdv zzbdvVar) {
        this(context, viewGroup, zzbdvVar, null);
    }

    @VisibleForTesting
    private zzbax(Context context, ViewGroup viewGroup, zzbbe zzbbeVar, zzbar zzbarVar) {
        this.a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = viewGroup;
        this.b = zzbbeVar;
        this.d = null;
    }

    public final void a(int i, int i2, int i3, int i4) {
        Preconditions.b("The underlay may only be modified from the UI thread.");
        if (this.d != null) {
            this.d.a(i, i2, i3, i4);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, boolean z, zzbbf zzbbfVar) {
        if (this.d != null) {
            return;
        }
        zzabn.a(this.b.l().a(), this.b.f(), "vpr2");
        this.d = new zzbar(this.a, this.b, i5, z, this.b.l().a(), zzbbfVar);
        this.c.addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
        this.d.a(i, i2, i3, i4);
        this.b.a(false);
    }

    public final zzbar a() {
        Preconditions.b("getAdVideoUnderlay must be called from the UI thread.");
        return this.d;
    }

    public final void b() {
        Preconditions.b("onPause must be called from the UI thread.");
        if (this.d != null) {
            this.d.i();
        }
    }

    public final void c() {
        Preconditions.b("onDestroy must be called from the UI thread.");
        if (this.d != null) {
            this.d.n();
            this.c.removeView(this.d);
            this.d = null;
        }
    }
}
