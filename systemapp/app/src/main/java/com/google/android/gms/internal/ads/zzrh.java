package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrh {

    @VisibleForTesting
    private int b;
    private final Object a = new Object();
    private List<zzre> c = new LinkedList();

    public final zzre a(boolean z) {
        synchronized (this.a) {
            zzre zzreVar = null;
            if (this.c.size() == 0) {
                zzd.b("Queue empty");
                return null;
            }
            int i = 0;
            if (this.c.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzre zzreVar2 : this.c) {
                    int j = zzreVar2.j();
                    if (j > i2) {
                        i = i3;
                        zzreVar = zzreVar2;
                        i2 = j;
                    }
                    i3++;
                }
                this.c.remove(i);
                return zzreVar;
            }
            zzre zzreVar3 = this.c.get(0);
            if (z) {
                this.c.remove(0);
            } else {
                zzreVar3.e();
            }
            return zzreVar3;
        }
    }

    public final boolean a(zzre zzreVar) {
        synchronized (this.a) {
            return this.c.contains(zzreVar);
        }
    }

    public final boolean b(zzre zzreVar) {
        synchronized (this.a) {
            Iterator<zzre> it = this.c.iterator();
            while (it.hasNext()) {
                zzre next = it.next();
                if (!zzp.g().h().b()) {
                    if (zzreVar != next && next.b().equals(zzreVar.b())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzp.g().h().d() && zzreVar != next && next.d().equals(zzreVar.d())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void c(zzre zzreVar) {
        synchronized (this.a) {
            if (this.c.size() >= 10) {
                int size = this.c.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzd.b(sb.toString());
                this.c.remove(0);
            }
            int i = this.b;
            this.b = i + 1;
            zzreVar.a(i);
            zzreVar.h();
            this.c.add(zzreVar);
        }
    }
}
