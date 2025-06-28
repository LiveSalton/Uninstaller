package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaof implements MediationAdRequest {
    private final Date a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final boolean g;
    private final int h;
    private final String i;

    public zzaof(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.a = date;
        this.b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = z2;
        this.h = i3;
        this.i = str;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date a() {
        return this.a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> c() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location d() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean f() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int e() {
        return this.f;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean g() {
        return this.g;
    }
}
