package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaon implements NativeMediationAdRequest {
    private final Date a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final zzadz g;
    private final boolean i;
    private final int k;
    private final String l;
    private final List<String> h = new ArrayList();
    private final Map<String, Boolean> j = new HashMap();

    public zzaon(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzadz zzadzVar, List<String> list, boolean z2, int i3, String str) {
        this.a = date;
        this.b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = zzadzVar;
        this.i = z2;
        this.k = i3;
        this.l = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.j.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.j.put(split[1], false);
                        }
                    }
                } else {
                    this.h.add(str2);
                }
            }
        }
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

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions h() {
        if (this.g == null) {
            return null;
        }
        NativeAdOptions.Builder b = new NativeAdOptions.Builder().a(this.g.b).a(this.g.c).b(this.g.d);
        if (this.g.a >= 2) {
            b.b(this.g.e);
        }
        if (this.g.a >= 3 && this.g.f != null) {
            b.a(new VideoOptions(this.g.f));
        }
        return b.a();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean i() {
        if (this.h != null) {
            return this.h.contains("2") || this.h.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean j() {
        return this.h != null && this.h.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean k() {
        if (this.h != null) {
            return this.h.contains("1") || this.h.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean l() {
        return this.h != null && this.h.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> m() {
        return this.j;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean g() {
        return this.i;
    }
}
