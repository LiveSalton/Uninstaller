package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzat {
    private final String[] a;
    private final double[] b;
    private final double[] c;
    private final int[] d;
    private int e;

    /* JADX INFO: Access modifiers changed from: private */
    zzat(zzay zzayVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzayVar.b;
        int size = list.size();
        list2 = zzayVar.a;
        this.a = (String[]) list2.toArray(new String[size]);
        list3 = zzayVar.b;
        this.b = a((List<Double>) list3);
        list4 = zzayVar.c;
        this.c = a((List<Double>) list4);
        this.d = new int[size];
        this.e = 0;
    }

    private static double[] a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void a(double d) {
        this.e++;
        for (int i = 0; i < this.c.length; i++) {
            if (this.c[i] <= d && d < this.b[i]) {
                int[] iArr = this.d;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.c[i]) {
                return;
            }
        }
    }

    public final List<zzav> a() {
        ArrayList arrayList = new ArrayList(this.a.length);
        for (int i = 0; i < this.a.length; i++) {
            arrayList.add(new zzav(this.a[i], this.c[i], this.b[i], this.d[i] / this.e, this.d[i]));
        }
        return arrayList;
    }

    /* synthetic */ zzat(zzay zzayVar, j jVar) {
        this(zzayVar);
    }
}
