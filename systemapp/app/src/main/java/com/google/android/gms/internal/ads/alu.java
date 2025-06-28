package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
final class alu implements Iterable<String> {
    private final /* synthetic */ CharSequence a;
    private final /* synthetic */ zzdvx b;

    alu(zzdvx zzdvxVar, CharSequence charSequence) {
        this.b = zzdvxVar;
        this.a = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        Iterator<String> b;
        b = this.b.b(this.a);
        return b;
    }

    public final String toString() {
        StringBuilder a = zzdvl.a(", ").a(new StringBuilder("["), iterator());
        a.append(']');
        return a.toString();
    }
}
