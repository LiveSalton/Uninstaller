package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepo<T> implements zzepf<Set<T>> {
    private static final zzepf<Set<Object>> a = zzepi.a(Collections.emptySet());
    private final List<zzeps<T>> b;
    private final List<zzeps<Collection<T>>> c;

    public static <T> zzepq<T> a(int i, int i2) {
        return new zzepq<>(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzepo(List<zzeps<T>> list, List<zzeps<Collection<T>>> list2) {
        this.b = list;
        this.c = list2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        int size = this.b.size();
        ArrayList arrayList = new ArrayList(this.c.size());
        int size2 = this.c.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection<T> b = this.c.get(i2).b();
            i += b.size();
            arrayList.add(b);
        }
        HashSet b2 = zzepe.b(i);
        int size3 = this.b.size();
        for (int i3 = 0; i3 < size3; i3++) {
            b2.add(zzepl.a(this.b.get(i3).b()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            Iterator it = ((Collection) arrayList.get(i4)).iterator();
            while (it.hasNext()) {
                b2.add(zzepl.a(it.next()));
            }
        }
        return Collections.unmodifiableSet(b2);
    }

    /* synthetic */ zzepo(List list, List list2, axd axdVar) {
        this(list, list2);
    }
}
