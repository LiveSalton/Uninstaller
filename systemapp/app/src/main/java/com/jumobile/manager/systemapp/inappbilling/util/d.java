package com.jumobile.manager.systemapp.inappbilling.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    Map<String, g> a = new HashMap();
    Map<String, e> b = new HashMap();

    d() {
    }

    public g a(String str) {
        return this.a.get(str);
    }

    public boolean b(String str) {
        return this.b.containsKey(str);
    }

    List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        for (e eVar : this.b.values()) {
            if (eVar.a().equals(str)) {
                arrayList.add(eVar.b());
            }
        }
        return arrayList;
    }

    void a(g gVar) {
        this.a.put(gVar.a(), gVar);
    }

    void a(e eVar) {
        this.b.put(eVar.b(), eVar);
    }
}
