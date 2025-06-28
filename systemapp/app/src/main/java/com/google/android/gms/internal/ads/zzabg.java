package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzabg {
    static List<String> a() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, zzacn.a("gad:dynamite_module:experiment_id", ""));
        a(arrayList, zzacz.a);
        a(arrayList, zzacz.b);
        a(arrayList, zzacz.c);
        a(arrayList, zzacz.d);
        a(arrayList, zzacz.e);
        a(arrayList, zzacz.k);
        a(arrayList, zzacz.f);
        a(arrayList, zzacz.g);
        a(arrayList, zzacz.h);
        a(arrayList, zzacz.i);
        a(arrayList, zzacz.j);
        return arrayList;
    }

    static List<String> b() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, zzadi.a);
        return arrayList;
    }

    private static void a(List<String> list, zzacn<String> zzacnVar) {
        String a = zzacnVar.a();
        if (TextUtils.isEmpty(a)) {
            return;
        }
        list.add(a);
    }
}
