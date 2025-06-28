package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aiz {
    private final zzdph a = new zzdph();
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    aiz() {
    }

    public final void a() {
        this.d++;
    }

    public final void b() {
        this.e++;
    }

    public final void c() {
        this.b++;
        this.a.a = true;
    }

    public final void d() {
        this.c++;
        this.a.b = true;
    }

    public final void e() {
        this.f++;
    }

    public final zzdph f() {
        zzdph zzdphVar = (zzdph) this.a.clone();
        zzdph zzdphVar2 = this.a;
        zzdphVar2.a = false;
        zzdphVar2.b = false;
        return zzdphVar;
    }

    public final String g() {
        return "\n\tPool does not exist: " + this.d + "\n\tNew pools created: " + this.b + "\n\tPools removed: " + this.c + "\n\tEntries added: " + this.f + "\n\tNo entries retrieved: " + this.e + "\n";
    }
}
