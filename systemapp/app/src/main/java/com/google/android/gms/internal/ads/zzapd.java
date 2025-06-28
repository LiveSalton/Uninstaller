package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapd extends zzaoa {
    private final UnifiedNativeAdMapper a;

    public zzapd(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.a = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaeb k() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String a() {
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final List b() {
        List<NativeAd.Image> b = this.a.b();
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            for (NativeAd.Image image : b) {
                arrayList.add(new zzadv(image.a(), image.b(), image.c(), image.d(), image.e()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String c() {
        return this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaej d() {
        NativeAd.Image d = this.a.d();
        if (d != null) {
            return new zzadv(d.a(), d.b(), d.c(), d.d(), d.e());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String e() {
        return this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String f() {
        return this.a.f();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final double g() {
        if (this.a.g() != null) {
            return this.a.g().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String h() {
        return this.a.h();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String i() {
        return this.a.i();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzys j() {
        if (this.a.j() != null) {
            return this.a.j().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper l() {
        View l = this.a.l();
        if (l == null) {
            return null;
        }
        return ObjectWrapper.a(l);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper m() {
        View m = this.a.m();
        if (m == null) {
            return null;
        }
        return ObjectWrapper.a(m);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final float s() {
        return this.a.n();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final float t() {
        return this.a.o();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final float u() {
        return this.a.p();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper n() {
        Object q = this.a.q();
        if (q == null) {
            return null;
        }
        return ObjectWrapper.a(q);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final Bundle o() {
        return this.a.r();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean p() {
        return this.a.s();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean q() {
        return this.a.t();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void r() {
        this.a.u();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void a(IObjectWrapper iObjectWrapper) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void b(IObjectWrapper iObjectWrapper) {
        this.a.b((View) ObjectWrapper.a(iObjectWrapper));
    }
}
