package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaaw {
    private final Collection<zzaaq<?>> a = new ArrayList();
    private final Collection<zzaaq<String>> b = new ArrayList();
    private final Collection<zzaaq<String>> c = new ArrayList();

    public final void a(zzaaq zzaaqVar) {
        this.a.add(zzaaqVar);
    }

    public final void b(zzaaq<String> zzaaqVar) {
        this.b.add(zzaaqVar);
    }

    public final void c(zzaaq<String> zzaaqVar) {
        this.c.add(zzaaqVar);
    }

    public final void a(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaaq<?> zzaaqVar : this.a) {
            if (zzaaqVar.c() == 1) {
                zzaaqVar.a(editor, (SharedPreferences.Editor) zzaaqVar.a(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzaza.c("Flag Json is null.");
        }
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzaaq<String>> it = this.b.iterator();
        while (it.hasNext()) {
            String str = (String) zzwq.e().a(it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzabg.a());
        return arrayList;
    }

    public final List<String> b() {
        List<String> a = a();
        Iterator<zzaaq<String>> it = this.c.iterator();
        while (it.hasNext()) {
            String str = (String) zzwq.e().a(it.next());
            if (!TextUtils.isEmpty(str)) {
                a.add(str);
            }
        }
        a.addAll(zzabg.b());
        return a;
    }
}
