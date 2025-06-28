package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class hz {
    private final ArrayList<zzoq> a = new ArrayList<>();
    private long b;

    hz() {
    }

    final long a() {
        Iterator<zzoq> it = this.a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> b = it.next().b();
            if (b != null) {
                for (Map.Entry<String, List<String>> entry : b.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.b = Math.max(this.b, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.b;
    }

    final void a(zzoq zzoqVar) {
        this.a.add(zzoqVar);
    }
}
