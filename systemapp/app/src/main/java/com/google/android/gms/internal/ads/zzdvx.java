package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdvx {
    private final zzdvd a;
    private final boolean b;
    private final alx c;
    private final int d;

    private zzdvx(alx alxVar) {
        this(alxVar, false, all.a, Integer.MAX_VALUE);
    }

    private zzdvx(alx alxVar, boolean z, zzdvd zzdvdVar, int i) {
        this.c = alxVar;
        this.b = false;
        this.a = zzdvdVar;
        this.d = Integer.MAX_VALUE;
    }

    public static zzdvx a(zzdvd zzdvdVar) {
        zzdvv.a(zzdvdVar);
        return new zzdvx(new alt(zzdvdVar));
    }

    public final Iterable<String> a(CharSequence charSequence) {
        zzdvv.a(charSequence);
        return new alu(this, charSequence);
    }

    public final Iterator<String> b(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }
}
