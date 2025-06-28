package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class axh implements zzdum {
    private final zzdsj a;
    private final zzdsv b;
    private final zzfh c;
    private final zzey d;

    axh(zzdsj zzdsjVar, zzdsv zzdsvVar, zzfh zzfhVar, zzey zzeyVar) {
        this.a = zzdsjVar;
        this.b = zzdsvVar;
        this.c = zzfhVar;
        this.d = zzeyVar;
    }

    final void a(View view) {
        this.c.a(view);
    }

    private final Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        zzcf.zza b = this.b.b();
        hashMap.put("v", this.a.a());
        hashMap.put("gms", Boolean.valueOf(this.a.c()));
        hashMap.put("int", b.b());
        hashMap.put("up", Boolean.valueOf(this.d.a()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzdum
    public final Map<String, Object> a() {
        Map<String, Object> d = d();
        zzcf.zza a = this.b.a();
        d.put("gai", Boolean.valueOf(this.a.b()));
        d.put("did", a.c());
        d.put("dst", Integer.valueOf(a.d().a()));
        d.put("doo", Boolean.valueOf(a.e()));
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzdum
    public final Map<String, Object> b() {
        return d();
    }

    @Override // com.google.android.gms.internal.ads.zzdum
    public final Map<String, Object> c() {
        Map<String, Object> d = d();
        d.put("lts", Long.valueOf(this.c.a()));
        return d;
    }
}
