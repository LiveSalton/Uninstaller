package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvb implements zzcre<zzdoe, zzcsw> {

    @GuardedBy("this")
    private final Map<String, zzcrb<zzdoe, zzcsw>> a = new HashMap();
    private final zzciq b;

    public zzcvb(zzciq zzciqVar) {
        this.b = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzcrb<zzdoe, zzcsw> a(String str, JSONObject jSONObject) throws zzdnr {
        synchronized (this) {
            zzcrb<zzdoe, zzcsw> zzcrbVar = this.a.get(str);
            if (zzcrbVar == null) {
                zzdoe a = this.b.a(str, jSONObject);
                if (a == null) {
                    return null;
                }
                zzcrbVar = new zzcrb<>(a, new zzcsw(), str);
                this.a.put(str, zzcrbVar);
            }
            return zzcrbVar;
        }
    }
}
