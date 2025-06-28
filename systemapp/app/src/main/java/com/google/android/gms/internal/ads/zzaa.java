package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzaq;
import java.util.Collections;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaa<T> implements Comparable<zzaa<T>> {
    private final zzaq.a a;
    private final int b;
    private final String c;
    private final int d;
    private final Object e;
    private zzai f;
    private Integer g;
    private zzae h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private zzan m;
    private zzn n;
    private s o;

    public zzaa(int i, String str, zzai zzaiVar) {
        Uri parse;
        String host;
        this.a = zzaq.a.a ? new zzaq.a() : null;
        this.e = new Object();
        this.i = true;
        int i2 = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.b = i;
        this.c = str;
        this.f = zzaiVar;
        this.m = new zzq();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.d = i2;
    }

    protected abstract zzaj<T> a(zzy zzyVar);

    protected abstract void a(T t);

    public byte[] a() throws zzl {
        return null;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.d;
    }

    public final void b(String str) {
        if (zzaq.a.a) {
            this.a.a(str, Thread.currentThread().getId());
        }
    }

    final void c(String str) {
        if (this.h != null) {
            this.h.b(this);
        }
        if (zzaq.a.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new w(this, str, id));
            } else {
                this.a.a(str, id);
                this.a.a(toString());
            }
        }
    }

    final void a(int i) {
        if (this.h != null) {
            this.h.a(this, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> a(zzae zzaeVar) {
        this.h = zzaeVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> b(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    public final String e() {
        return this.c;
    }

    public final String f() {
        String str = this.c;
        int i = this.b;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(1 + String.valueOf(num).length() + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaa<?> a(zzn zznVar) {
        this.n = zznVar;
        return this;
    }

    public final zzn g() {
        return this.n;
    }

    public final boolean h() {
        synchronized (this.e) {
        }
        return false;
    }

    public Map<String, String> b() throws zzl {
        return Collections.emptyMap();
    }

    public final boolean i() {
        return this.i;
    }

    public final int j() {
        return this.m.a();
    }

    public final zzan k() {
        return this.m;
    }

    public final void l() {
        synchronized (this.e) {
            this.k = true;
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.e) {
            z = this.k;
        }
        return z;
    }

    public final void a(zzao zzaoVar) {
        zzai zzaiVar;
        synchronized (this.e) {
            zzaiVar = this.f;
        }
        if (zzaiVar != null) {
            zzaiVar.a(zzaoVar);
        }
    }

    final void a(s sVar) {
        synchronized (this.e) {
            this.o = sVar;
        }
    }

    final void a(zzaj<?> zzajVar) {
        s sVar;
        synchronized (this.e) {
            sVar = this.o;
        }
        if (sVar != null) {
            sVar.a(this, zzajVar);
        }
    }

    final void n() {
        s sVar;
        synchronized (this.e) {
            sVar = this.o;
        }
        if (sVar != null) {
            sVar.a(this);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.d));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        h();
        String str = this.c;
        String valueOf2 = String.valueOf(zzaf.NORMAL);
        String valueOf3 = String.valueOf(this.g);
        StringBuilder sb = new StringBuilder(3 + String.valueOf("[ ] ").length() + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(valueOf3);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzaa zzaaVar = (zzaa) obj;
        zzaf zzafVar = zzaf.NORMAL;
        zzaf zzafVar2 = zzaf.NORMAL;
        return zzafVar == zzafVar2 ? this.g.intValue() - zzaaVar.g.intValue() : zzafVar2.ordinal() - zzafVar.ordinal();
    }
}
