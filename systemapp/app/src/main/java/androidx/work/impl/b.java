package androidx.work.impl;

import androidx.lifecycle.o;
import androidx.work.k;

/* compiled from: source */
/* loaded from: classes.dex */
public class b implements k {
    private final o<k.a> c = new o<>();
    private final androidx.work.impl.utils.a.c<k.a.c> d = androidx.work.impl.utils.a.c.d();

    public b() {
        a(k.b);
    }

    public void a(k.a aVar) {
        this.c.a((o<k.a>) aVar);
        if (aVar instanceof k.a.c) {
            this.d.a((androidx.work.impl.utils.a.c<k.a.c>) aVar);
        } else if (aVar instanceof k.a.C0053a) {
            this.d.a(((k.a.C0053a) aVar).a());
        }
    }
}
