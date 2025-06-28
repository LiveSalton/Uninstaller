package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class rw implements zzdvm {
    static final zzdvm a = new rw();

    private rw() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvm
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzadv zzadvVar : (List) obj) {
            if (zzadvVar != null) {
                arrayList.add(zzadvVar);
            }
        }
        return arrayList;
    }
}
