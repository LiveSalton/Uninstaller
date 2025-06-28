package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbcu implements Iterable<zzbcs> {
    private final List<zzbcs> a = new ArrayList();

    public static boolean a(zzbbe zzbbeVar) {
        zzbcs b = b(zzbbeVar);
        if (b == null) {
            return false;
        }
        b.b.a();
        return true;
    }

    static zzbcs b(zzbbe zzbbeVar) {
        Iterator<zzbcs> it = zzp.y().iterator();
        while (it.hasNext()) {
            zzbcs next = it.next();
            if (next.a == zzbbeVar) {
                return next;
            }
        }
        return null;
    }

    public final void a(zzbcs zzbcsVar) {
        this.a.add(zzbcsVar);
    }

    public final void b(zzbcs zzbcsVar) {
        this.a.remove(zzbcsVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbcs> iterator() {
        return this.a.iterator();
    }
}
