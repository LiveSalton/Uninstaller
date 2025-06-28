package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrg {
    private zzdmu c = null;
    private final Map<String, zzvr> b = Collections.synchronizedMap(new HashMap());
    private final List<zzvr> a = Collections.synchronizedList(new ArrayList());

    public final void a(zzdmu zzdmuVar) {
        String str = zzdmuVar.v;
        if (this.b.containsKey(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = zzdmuVar.u.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                bundle.putString(next, zzdmuVar.u.getString(next));
            } catch (JSONException unused) {
            }
        }
        zzvr zzvrVar = new zzvr(zzdmuVar.D, 0L, null, bundle);
        this.a.add(zzvrVar);
        this.b.put(str, zzvrVar);
    }

    public final void a(zzdmu zzdmuVar, long j, zzve zzveVar) {
        String str = zzdmuVar.v;
        if (this.b.containsKey(str)) {
            if (this.c == null) {
                this.c = zzdmuVar;
            }
            zzvr zzvrVar = this.b.get(str);
            zzvrVar.b = j;
            zzvrVar.c = zzveVar;
        }
    }

    public final zzbrp a() {
        return new zzbrp(this.c, "", this);
    }

    public final List<zzvr> b() {
        return this.a;
    }
}
