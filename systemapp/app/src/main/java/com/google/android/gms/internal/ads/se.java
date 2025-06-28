package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class se implements zzdvm {
    static final zzdvm a = new se();

    private se() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvm
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcfd zzcfdVar : (List) obj) {
            if (zzcfdVar != null) {
                arrayList.add(zzcfdVar);
            }
        }
        return arrayList;
    }
}
