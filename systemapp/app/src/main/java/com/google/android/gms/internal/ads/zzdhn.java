package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhn {
    private final zzatl a;
    private final int b;

    public zzdhn(zzatl zzatlVar, int i) {
        this.a = zzatlVar;
        this.b = i;
    }

    public final String a() {
        return this.a.d;
    }

    public final String b() {
        return this.a.a.getString("ms");
    }

    public final PackageInfo c() {
        return this.a.f;
    }

    public final boolean d() {
        return this.a.h;
    }

    public final List<String> e() {
        return this.a.e;
    }

    public final ApplicationInfo f() {
        return this.a.c;
    }

    public final String g() {
        return this.a.i;
    }

    public final int h() {
        return this.b;
    }
}
