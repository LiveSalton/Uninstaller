package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeju {
    private static volatile boolean a = false;
    private static boolean b = true;
    private static volatile zzeju c;
    private static volatile zzeju d;
    private static final zzeju e = new zzeju(true);
    private final Map<a, zzekh.zzd<?, ?>> f;

    public static zzeju a() {
        zzeju zzejuVar = c;
        if (zzejuVar == null) {
            synchronized (zzeju.class) {
                zzejuVar = c;
                if (zzejuVar == null) {
                    zzejuVar = e;
                    c = zzejuVar;
                }
            }
        }
        return zzejuVar;
    }

    /* compiled from: source */
    static final class a {
        private final Object a;
        private final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }
    }

    public static zzeju b() {
        zzeju zzejuVar = d;
        if (zzejuVar != null) {
            return zzejuVar;
        }
        synchronized (zzeju.class) {
            zzeju zzejuVar2 = d;
            if (zzejuVar2 != null) {
                return zzejuVar2;
            }
            zzeju a2 = ats.a(zzeju.class);
            d = a2;
            return a2;
        }
    }

    public final <ContainingType extends zzels> zzekh.zzd<ContainingType, ?> a(ContainingType containingtype, int i) {
        return (zzekh.zzd) this.f.get(new a(containingtype, i));
    }

    zzeju() {
        this.f = new HashMap();
    }

    private zzeju(boolean z) {
        this.f = Collections.emptyMap();
    }
}
