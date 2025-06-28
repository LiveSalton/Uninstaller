package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzay {
    private final List<String> a = new ArrayList();
    private final List<Double> b = new ArrayList();
    private final List<Double> c = new ArrayList();

    public final zzay a(String str, double d, double d2) {
        int i = 0;
        while (i < this.a.size()) {
            double doubleValue = this.c.get(i).doubleValue();
            double doubleValue2 = this.b.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.a.add(i, str);
        this.c.add(i, Double.valueOf(d));
        this.b.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzat a() {
        return new zzat(this);
    }
}
