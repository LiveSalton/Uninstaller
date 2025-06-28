package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgz implements zzdfi<zzdgw> {
    private zzaxy a;
    private zzdzc b;
    private String c;

    public zzdgz(zzaxy zzaxyVar, zzdzc zzdzcVar, String str) {
        this.a = zzaxyVar;
        this.b = zzdzcVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdgw> a() {
        new zzazq();
        zzdyz<String> a = zzdyr.a((Object) null);
        if (((Boolean) zzwq.e().a(zzabf.cZ)).booleanValue()) {
            a = this.a.a(this.c);
        }
        zzdyz<String> b = this.a.b(this.c);
        return zzdyr.b(a, b).a(new Callable(a, b) { // from class: com.google.android.gms.internal.ads.aez
            private final zzdyz a;
            private final zzdyz b;

            {
                this.a = a;
                this.b = b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzdgw((String) this.a.get(), (String) this.b.get());
            }
        }, zzazj.a);
    }
}
