package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabt {
    private final Map<String, zzabq> a = new HashMap();
    private final zzabs b;

    public zzabt(zzabs zzabsVar) {
        this.b = zzabsVar;
    }

    public final void a(String str, zzabq zzabqVar) {
        this.a.put(str, zzabqVar);
    }

    public final void a(String str, String str2, long j) {
        zzabs zzabsVar = this.b;
        zzabq zzabqVar = this.a.get(str2);
        String[] strArr = {str};
        if (zzabsVar != null && zzabqVar != null) {
            zzabsVar.a(zzabqVar, j, strArr);
        }
        Map<String, zzabq> map = this.a;
        zzabs zzabsVar2 = this.b;
        map.put(str, zzabsVar2 == null ? null : zzabsVar2.a(j));
    }

    public final zzabs a() {
        return this.b;
    }
}
