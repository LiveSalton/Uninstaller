package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdns {
    public static zzdmx a(List<zzdmx> list, zzdmx zzdmxVar) {
        return list.get(0);
    }

    public static zzvn a(Context context, List<zzdmx> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdmx zzdmxVar : list) {
            if (zzdmxVar.c) {
                arrayList.add(AdSize.h);
            } else {
                arrayList.add(new AdSize(zzdmxVar.a, zzdmxVar.b));
            }
        }
        return new zzvn(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdmx a(zzvn zzvnVar) {
        if (zzvnVar.i) {
            return new zzdmx(-3, 0, true);
        }
        return new zzdmx(zzvnVar.e, zzvnVar.b, false);
    }
}
