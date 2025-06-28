package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzadq extends zzaea {
    private static final int a = Color.rgb(12, 174, 206);
    private static final int b;
    private static final int c;
    private static final int d;
    private final String e;
    private final List<zzadv> f = new ArrayList();
    private final List<zzaej> g = new ArrayList();
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;

    public zzadq(String str, List<zzadv> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.e = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadv zzadvVar = list.get(i3);
                this.f.add(zzadvVar);
                this.g.add(zzadvVar);
            }
        }
        this.h = num != null ? num.intValue() : c;
        this.i = num2 != null ? num2.intValue() : d;
        this.j = num3 != null ? num3.intValue() : 12;
        this.k = i;
        this.l = i2;
        this.m = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final String a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final List<zzaej> b() {
        return this.g;
    }

    public final List<zzadv> c() {
        return this.f;
    }

    public final int d() {
        return this.h;
    }

    public final int e() {
        return this.i;
    }

    public final int f() {
        return this.j;
    }

    public final int g() {
        return this.k;
    }

    public final int h() {
        return this.l;
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        b = rgb;
        c = rgb;
        d = a;
    }
}
