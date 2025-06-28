package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class auj implements auh {
    auj() {
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final Map<?, ?> a(Object obj) {
        return (zzelm) obj;
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final aug<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final Map<?, ?> b(Object obj) {
        return (zzelm) obj;
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final boolean c(Object obj) {
        return !((zzelm) obj).d();
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final Object d(Object obj) {
        ((zzelm) obj).c();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final Object e(Object obj) {
        return zzelm.a().b();
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final Object a(Object obj, Object obj2) {
        zzelm zzelmVar = (zzelm) obj;
        zzelm zzelmVar2 = (zzelm) obj2;
        if (!zzelmVar2.isEmpty()) {
            if (!zzelmVar.d()) {
                zzelmVar = zzelmVar.b();
            }
            zzelmVar.a(zzelmVar2);
        }
        return zzelmVar;
    }

    @Override // com.google.android.gms.internal.ads.auh
    public final int a(int i, Object obj, Object obj2) {
        zzelm zzelmVar = (zzelm) obj;
        if (zzelmVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzelmVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
