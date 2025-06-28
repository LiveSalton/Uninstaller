package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class avc {
    private final ArrayDeque<zzeiu> a;

    private avc() {
        this.a = new ArrayDeque<>();
    }

    public final zzeiu a(zzeiu zzeiuVar, zzeiu zzeiuVar2) {
        a(zzeiuVar);
        a(zzeiuVar2);
        zzeiu pop = this.a.pop();
        while (!this.a.isEmpty()) {
            pop = new ava(this.a.pop(), pop, null);
        }
        return pop;
    }

    private final void a(zzeiu zzeiuVar) {
        auz auzVar;
        while (!zzeiuVar.j()) {
            if (zzeiuVar instanceof ava) {
                ava avaVar = (ava) zzeiuVar;
                a(avaVar.d);
                zzeiuVar = avaVar.e;
            } else {
                String valueOf = String.valueOf(zzeiuVar.getClass());
                StringBuilder sb = new StringBuilder(49 + String.valueOf(valueOf).length());
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int a = a(zzeiuVar.b());
        int d = ava.d(a + 1);
        if (this.a.isEmpty() || this.a.peek().b() >= d) {
            this.a.push(zzeiuVar);
            return;
        }
        int d2 = ava.d(a);
        zzeiu pop = this.a.pop();
        while (true) {
            auzVar = null;
            if (this.a.isEmpty() || this.a.peek().b() >= d2) {
                break;
            } else {
                pop = new ava(this.a.pop(), pop, auzVar);
            }
        }
        ava avaVar2 = new ava(pop, zzeiuVar, auzVar);
        while (!this.a.isEmpty()) {
            if (this.a.peek().b() >= ava.d(a(avaVar2.b()) + 1)) {
                break;
            } else {
                avaVar2 = new ava(this.a.pop(), avaVar2, auzVar);
            }
        }
        this.a.push(avaVar2);
    }

    private static int a(int i) {
        int binarySearch = Arrays.binarySearch(ava.b, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ avc(auz auzVar) {
        this();
    }
}
