package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaol extends zzanu {
    private final NativeAppInstallAdMapper a;

    public zzaol(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.a = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final zzaeb o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final IObjectWrapper q() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String a() {
        return this.a.i();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final List b() {
        List<NativeAd.Image> j = this.a.j();
        if (j == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : j) {
            arrayList.add(new zzadv(image.a(), image.b(), image.c(), image.d(), image.e()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String c() {
        return this.a.k();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final zzaej d() {
        NativeAd.Image l = this.a.l();
        if (l != null) {
            return new zzadv(l.a(), l.b(), l.c(), l.d(), l.e());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String e() {
        return this.a.m();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final double f() {
        return this.a.n();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String g() {
        return this.a.o();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final String h() {
        return this.a.p();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void i() {
        this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void a(IObjectWrapper iObjectWrapper) {
        this.a.c((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void b(IObjectWrapper iObjectWrapper) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final void c(IObjectWrapper iObjectWrapper) {
        this.a.b((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final boolean j() {
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final boolean k() {
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final Bundle l() {
        return this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final zzys m() {
        if (this.a.g() != null) {
            return this.a.g().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final IObjectWrapper n() {
        View d = this.a.d();
        if (d == null) {
            return null;
        }
        return ObjectWrapper.a(d);
    }

    @Override // com.google.android.gms.internal.ads.zzanv
    public final IObjectWrapper p() {
        View f = this.a.f();
        if (f == null) {
            return null;
        }
        return ObjectWrapper.a(f);
    }
}
