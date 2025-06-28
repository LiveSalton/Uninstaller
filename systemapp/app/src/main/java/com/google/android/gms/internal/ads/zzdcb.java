package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcb implements zzdfi<zzdby> {
    private final zzdzc a;
    private final zzcis b;
    private final String c;
    private final zzdnn d;

    public zzdcb(zzdzc zzdzcVar, zzcis zzcisVar, zzdnn zzdnnVar, String str) {
        this.a = zzdzcVar;
        this.b = zzcisVar;
        this.d = zzdnnVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdby> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ada
            private final zzdcb a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdby b() throws Exception {
        JSONObject a;
        if (((Boolean) zzwq.e().a(zzabf.bN)).booleanValue() && (a = this.b.a(this.d.f, this.c)) != null) {
            return new zzdby(a.toString());
        }
        return null;
    }
}
