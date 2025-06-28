package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class acr implements zzdvm {
    static final zzdvm a = new acr();

    private acr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvm
    public final Object a(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdfj(arrayList) { // from class: com.google.android.gms.internal.ads.acq
            private final ArrayList a;

            {
                this.a = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.a);
            }
        };
    }
}
