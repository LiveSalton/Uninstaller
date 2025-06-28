package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: source */
/* loaded from: classes.dex */
final class ae implements Comparator<zzdu> {
    ae() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdu zzduVar, zzdu zzduVar2) {
        int b;
        int b2;
        zzdu zzduVar3 = zzduVar;
        zzdu zzduVar4 = zzduVar2;
        zzed zzedVar = (zzed) zzduVar3.iterator();
        zzed zzedVar2 = (zzed) zzduVar4.iterator();
        while (zzedVar.hasNext() && zzedVar2.hasNext()) {
            b = zzdu.b(zzedVar.a());
            b2 = zzdu.b(zzedVar2.a());
            int compare = Integer.compare(b, b2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzduVar3.a(), zzduVar4.a());
    }
}
