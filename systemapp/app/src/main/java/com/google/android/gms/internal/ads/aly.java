package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class aly extends alg<String> {
    final CharSequence a;
    private final zzdvd b;
    private final boolean c;
    private int d = 0;
    private int e;

    protected aly(zzdvx zzdvxVar, CharSequence charSequence) {
        zzdvd zzdvdVar;
        int i;
        zzdvdVar = zzdvxVar.a;
        this.b = zzdvdVar;
        this.c = false;
        i = zzdvxVar.d;
        this.e = i;
        this.a = charSequence;
    }

    abstract int a(int i);

    abstract int b(int i);

    @Override // com.google.android.gms.internal.ads.alg
    protected final /* synthetic */ String a() {
        int i = this.d;
        while (this.d != -1) {
            int a = a(this.d);
            if (a == -1) {
                a = this.a.length();
                this.d = -1;
            } else {
                this.d = b(a);
            }
            if (this.d == i) {
                this.d++;
                if (this.d > this.a.length()) {
                    this.d = -1;
                }
            } else {
                while (i < a && this.b.b(this.a.charAt(i))) {
                    i++;
                }
                while (a > i && this.b.b(this.a.charAt(a - 1))) {
                    a--;
                }
                if (this.e == 1) {
                    a = this.a.length();
                    this.d = -1;
                    while (a > i && this.b.b(this.a.charAt(a - 1))) {
                        a--;
                    }
                } else {
                    this.e--;
                }
                return this.a.subSequence(i, a).toString();
            }
        }
        b();
        return null;
    }
}
