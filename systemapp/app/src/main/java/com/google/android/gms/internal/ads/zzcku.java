package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcku implements zzdru {
    private final zzcko b;
    private final Clock c;
    private final Map<zzdrl, Long> a = new HashMap();
    private final Map<zzdrl, up> d = new HashMap();

    public zzcku(zzcko zzckoVar, Set<up> set, Clock clock) {
        zzdrl zzdrlVar;
        this.b = zzckoVar;
        for (up upVar : set) {
            Map<zzdrl, up> map = this.d;
            zzdrlVar = upVar.c;
            map.put(zzdrlVar, upVar);
        }
        this.c = clock;
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void b(zzdrl zzdrlVar, String str) {
        this.a.put(zzdrlVar, Long.valueOf(this.c.b()));
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str, Throwable th) {
        if (this.a.containsKey(zzdrlVar)) {
            long b = this.c.b() - this.a.get(zzdrlVar).longValue();
            Map<String, String> a = this.b.a();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(b));
            a.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.d.containsKey(zzdrlVar)) {
            a(zzdrlVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void c(zzdrl zzdrlVar, String str) {
        if (this.a.containsKey(zzdrlVar)) {
            long b = this.c.b() - this.a.get(zzdrlVar).longValue();
            Map<String, String> a = this.b.a();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(b));
            a.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.d.containsKey(zzdrlVar)) {
            a(zzdrlVar, true);
        }
    }

    private final void a(zzdrl zzdrlVar, boolean z) {
        zzdrl zzdrlVar2;
        String str;
        zzdrlVar2 = this.d.get(zzdrlVar).b;
        String str2 = z ? "s." : "f.";
        if (this.a.containsKey(zzdrlVar2)) {
            long b = this.c.b() - this.a.get(zzdrlVar2).longValue();
            Map<String, String> a = this.b.a();
            str = this.d.get(zzdrlVar).a;
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(str2);
            String valueOf3 = String.valueOf(Long.toString(b));
            a.put(concat, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
        }
    }
}
