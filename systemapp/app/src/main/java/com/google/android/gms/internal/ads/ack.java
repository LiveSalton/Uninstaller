package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
final class ack implements zzdfi<zzdfj<Bundle>> {
    private final Set<String> a;

    ack(Set<String> set) {
        this.a = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return zzdyr.a(new zzdfj(arrayList) { // from class: com.google.android.gms.internal.ads.acl
            private final ArrayList a;

            {
                this.a = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.a);
            }
        });
    }
}
