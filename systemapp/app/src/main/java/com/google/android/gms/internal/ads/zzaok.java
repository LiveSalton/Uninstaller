package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaok extends zzanz {
    private final NativeContentAdMapper a;

    public zzaok(NativeContentAdMapper nativeContentAdMapper) {
        this.a = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final zzaeb m() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final IObjectWrapper o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String a() {
        return this.a.i();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
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

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String c() {
        return this.a.k();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final zzaej d() {
        NativeAd.Image l = this.a.l();
        if (l != null) {
            return new zzadv(l.a(), l.b(), l.c(), l.d(), l.e());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String e() {
        return this.a.m();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final String f() {
        return this.a.n();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void g() {
        this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void a(IObjectWrapper iObjectWrapper) {
        this.a.c((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void b(IObjectWrapper iObjectWrapper) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.a.a((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final void c(IObjectWrapper iObjectWrapper) {
        this.a.b((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final boolean h() {
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final boolean i() {
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final Bundle j() {
        return this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final IObjectWrapper k() {
        View d = this.a.d();
        if (d == null) {
            return null;
        }
        return ObjectWrapper.a(d);
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final zzys l() {
        if (this.a.g() != null) {
            return this.a.g().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanw
    public final IObjectWrapper n() {
        View f = this.a.f();
        if (f == null) {
            return null;
        }
        return ObjectWrapper.a(f);
    }
}
