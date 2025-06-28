package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzre {
    private final int a;
    private final int b;
    private final int c;
    private final boolean d;
    private final zzrt e;
    private final zzsa f;
    private int n;
    private final Object g = new Object();
    private ArrayList<String> h = new ArrayList<>();
    private ArrayList<String> i = new ArrayList<>();
    private ArrayList<zzrr> j = new ArrayList<>();
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private String o = "";
    private String p = "";
    private String q = "";

    public zzre(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = new zzrt(i4);
        this.f = new zzsa(i5, i6, i7);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.g) {
            z = this.m == 0;
        }
        return z;
    }

    public final String b() {
        return this.o;
    }

    public final String c() {
        return this.p;
    }

    public final String d() {
        return this.q;
    }

    public final void e() {
        synchronized (this.g) {
            this.n -= 100;
        }
    }

    public final void f() {
        synchronized (this.g) {
            this.m--;
        }
    }

    public final void g() {
        synchronized (this.g) {
            this.m++;
        }
    }

    public final void a(String str, boolean z, float f, float f2, float f3, float f4) {
        c(str, z, f, f2, f3, f4);
        synchronized (this.g) {
            if (this.m < 0) {
                zzd.b("ActivityContent: negative number of WebViews.");
            }
            i();
        }
    }

    public final void b(String str, boolean z, float f, float f2, float f3, float f4) {
        c(str, z, f, f2, f3, f4);
    }

    private final void c(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str == null || str.length() < this.c) {
            return;
        }
        synchronized (this.g) {
            this.h.add(str);
            this.k += str.length();
            if (z) {
                this.i.add(str);
                this.j.add(new zzrr(f, f2, f3, f4, this.i.size() - 1));
            }
        }
    }

    public final void h() {
        synchronized (this.g) {
            int a = a(this.k, this.l);
            if (a > this.n) {
                this.n = a;
            }
        }
    }

    public final void i() {
        synchronized (this.g) {
            int a = a(this.k, this.l);
            if (a > this.n) {
                this.n = a;
                if (!zzp.g().h().b()) {
                    this.o = this.e.a(this.h);
                    this.p = this.e.a(this.i);
                }
                if (!zzp.g().h().d()) {
                    this.q = this.f.a(this.i, this.j);
                }
            }
        }
    }

    @VisibleForTesting
    private final int a(int i, int i2) {
        if (this.d) {
            return this.b;
        }
        return (i * this.a) + (i2 * this.b);
    }

    public final int j() {
        return this.n;
    }

    public final void a(int i) {
        this.l = i;
    }

    private static String a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList2.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        return sb2.length() < 100 ? sb2 : sb2.substring(0, 100);
    }

    public final String toString() {
        int i = this.l;
        int i2 = this.n;
        int i3 = this.k;
        String a = a(this.h, 100);
        String a2 = a(this.i, 100);
        String str = this.o;
        String str2 = this.p;
        String str3 = this.q;
        StringBuilder sb = new StringBuilder(165 + String.valueOf(a).length() + String.valueOf(a2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(a);
        sb.append("\n viewableText");
        sb.append(a2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    @VisibleForTesting
    final int k() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzre)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzre zzreVar = (zzre) obj;
        return zzreVar.o != null && zzreVar.o.equals(this.o);
    }

    public final int hashCode() {
        return this.o.hashCode();
    }
}
