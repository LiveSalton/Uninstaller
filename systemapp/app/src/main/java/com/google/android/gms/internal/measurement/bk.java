package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class bk implements bi {
    bk() {
    }

    @Override // com.google.android.gms.internal.measurement.bi
    public final bh<?, ?> c(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.bi
    public final Map<?, ?> a(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.bi
    public final Object b(Object obj) {
        ((zzgi) obj).b();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.bi
    public final Object a(Object obj, Object obj2) {
        zzgi zzgiVar = (zzgi) obj;
        zzgi zzgiVar2 = (zzgi) obj2;
        if (!zzgiVar2.isEmpty()) {
            if (!zzgiVar.c()) {
                zzgiVar = zzgiVar.a();
            }
            zzgiVar.a(zzgiVar2);
        }
        return zzgiVar;
    }
}
