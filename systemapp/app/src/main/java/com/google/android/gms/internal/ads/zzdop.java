package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.internal.util.zzj;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdop {
    private final Map<String, zzdor> a = new HashMap();
    private final Context b;
    private final zzayg c;
    private final zzazh d;

    public zzdop(Context context, zzazh zzazhVar, zzayg zzaygVar) {
        this.b = context;
        this.d = zzazhVar;
        this.c = zzaygVar;
    }

    public final zzdor a(String str) {
        if (str == null) {
            return a();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        zzdor b = b(str);
        this.a.put(str, b);
        return b;
    }

    private final zzdor a() {
        return new zzdor(this.b, this.c.h(), this.c.k());
    }

    private final zzdor b(String str) {
        zzauc a = zzauc.a(this.b);
        try {
            a.a(str);
            com.google.android.gms.ads.internal.util.zzi zziVar = new com.google.android.gms.ads.internal.util.zzi();
            zziVar.a(this.b, str, false);
            zzj zzjVar = new zzj(this.c.h(), zziVar);
            return new zzdor(a, zzjVar, new zzayq(zzayr.c(), zzjVar));
        } catch (PackageManager.NameNotFoundException unused) {
            return a();
        }
    }
}
