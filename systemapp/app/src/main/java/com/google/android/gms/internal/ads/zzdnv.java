package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdnv {
    private final zzdmu a;
    private final zzdmz b;
    private final zzcqo c;
    private final zzdrz d;

    @VisibleForTesting
    public zzdnv(zzcqo zzcqoVar, zzdrz zzdrzVar, zzdmu zzdmuVar, zzdmz zzdmzVar) {
        this.a = zzdmuVar;
        this.b = zzdmzVar;
        this.c = zzcqoVar;
        this.d = zzdrzVar;
    }

    public final void a(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), zzcql.b);
        }
    }

    public final void a(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a((String) it.next(), i);
        }
    }

    private final void a(String str, int i) {
        if (!this.a.ae) {
            this.d.a(str);
        } else {
            this.c.a(new zzcqv(zzp.j().a(), this.b.b, str, i));
        }
    }
}
