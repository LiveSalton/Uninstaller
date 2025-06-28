package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class ath implements awo {
    private final zzejo a;

    public static ath a(zzejo zzejoVar) {
        return zzejoVar.a != null ? zzejoVar.a : new ath(zzejoVar);
    }

    private ath(zzejo zzejoVar) {
        this.a = (zzejo) zzekk.a(zzejoVar, "output");
        this.a.a = this;
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final int a() {
        return zzeob.a;
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, int i2) throws IOException {
        this.a.e(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, long j) throws IOException {
        this.a.a(i, j);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i, long j) throws IOException {
        this.a.c(i, j);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, float f) throws IOException {
        this.a.a(i, f);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, double d) throws IOException {
        this.a.a(i, d);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i, int i2) throws IOException {
        this.a.b(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void c(int i, long j) throws IOException {
        this.a.a(i, j);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void c(int i, int i2) throws IOException {
        this.a.b(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void d(int i, long j) throws IOException {
        this.a.c(i, j);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void d(int i, int i2) throws IOException {
        this.a.e(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, boolean z) throws IOException {
        this.a.a(i, z);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, String str) throws IOException {
        this.a.a(i, str);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, zzeiu zzeiuVar) throws IOException {
        this.a.a(i, zzeiuVar);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void e(int i, int i2) throws IOException {
        this.a.c(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void f(int i, int i2) throws IOException {
        this.a.d(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void e(int i, long j) throws IOException {
        this.a.b(i, j);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, Object obj, avd avdVar) throws IOException {
        this.a.a(i, (zzels) obj, avdVar);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i, Object obj, avd avdVar) throws IOException {
        zzejo zzejoVar = this.a;
        zzejoVar.a(i, 3);
        avdVar.a((avd) obj, (awo) zzejoVar.a);
        zzejoVar.a(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i) throws IOException {
        this.a.a(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i) throws IOException {
        this.a.a(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof zzeiu) {
            this.a.b(i, (zzeiu) obj);
        } else {
            this.a.a(i, (zzels) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.f(list.get(i4).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.i(list.get(i4).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.d(list.get(i4).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.e(list.get(i4).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.g(list.get(i4).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.b(list.get(i4).floatValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.b(list.get(i4).doubleValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.k(list.get(i4).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.b(list.get(i4).booleanValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzekz) {
            zzekz zzekzVar = (zzekz) list;
            while (i2 < list.size()) {
                Object b = zzekzVar.b(i2);
                if (b instanceof String) {
                    this.a.a(i, (String) b);
                } else {
                    this.a.a(i, (zzeiu) b);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i, List<zzeiu> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.a(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.g(list.get(i4).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.b(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.c(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.j(list.get(i4).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.h(list.get(i4).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.h(list.get(i4).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.c(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.d(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.f(list.get(i4).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.b(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.b(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void a(int i, List<?> list, avd avdVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), avdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final void b(int i, List<?> list, avd avdVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), avdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.awo
    public final <K, V> void a(int i, aug<K, V> augVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.a(i, 2);
            this.a.b(zzelk.a(augVar, entry.getKey(), entry.getValue()));
            zzelk.a(this.a, augVar, entry.getKey(), entry.getValue());
        }
    }
}
