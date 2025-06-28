package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgb extends zzafe {
    private final Context a;
    private final zzcce b;
    private zzcda c;
    private zzcbt d;

    public zzcgb(Context context, zzcce zzcceVar, zzcda zzcdaVar, zzcbt zzcbtVar) {
        this.a = context;
        this.b = zzcceVar;
        this.c = zzcdaVar;
        this.d = zzcbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final IObjectWrapper g() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String a(String str) {
        return this.b.B().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzaej b(String str) {
        return this.b.y().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final List<String> a() {
        androidx.b.g<String, zzadv> y = this.b.y();
        androidx.b.g<String, String> B = this.b.B();
        String[] strArr = new String[y.size() + B.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < y.size()) {
            strArr[i3] = y.b(i2);
            i2++;
            i3++;
        }
        while (i < B.size()) {
            strArr[i3] = B.b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String b() {
        return this.b.u();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void c(String str) {
        if (this.d != null) {
            this.d.a(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void c() {
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzys d() {
        return this.b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void e() {
        if (this.d != null) {
            this.d.b();
        }
        this.d = null;
        this.c = null;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final IObjectWrapper f() {
        return ObjectWrapper.a(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean a(IObjectWrapper iObjectWrapper) {
        Object a = ObjectWrapper.a(iObjectWrapper);
        if (!(a instanceof ViewGroup)) {
            return false;
        }
        if (!(this.c != null && this.c.a((ViewGroup) a))) {
            return false;
        }
        this.b.v().a(new st(this));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean h() {
        return (this.d == null || this.d.i()) && this.b.w() != null && this.b.v() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean i() {
        IObjectWrapper x = this.b.x();
        if (x != null) {
            zzp.r().a(x);
            if (!((Boolean) zzwq.e().a(zzabf.cD)).booleanValue() || this.b.w() == null) {
                return true;
            }
            this.b.w().a("onSdkLoaded", new androidx.b.a());
            return true;
        }
        zzd.e("Trying to start OMID session before creation.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void b(IObjectWrapper iObjectWrapper) {
        Object a = ObjectWrapper.a(iObjectWrapper);
        if (!(a instanceof View) || this.b.x() == null || this.d == null) {
            return;
        }
        this.d.c((View) a);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void j() {
        String A = this.b.A();
        if ("Google".equals(A)) {
            zzd.e("Illegal argument specified for omid partner name.");
        } else if (this.d != null) {
            this.d.a(A, false);
        }
    }
}
