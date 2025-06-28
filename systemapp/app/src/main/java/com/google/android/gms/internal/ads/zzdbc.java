package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbc implements zzdfi<Object> {
    private static final Object f = new Object();
    private final String a;
    private final String b;
    private final zzbpo c;
    private final zzdon d;
    private final zzdnn e;

    public zzdbc(String str, String str2, zzbpo zzbpoVar, zzdon zzdonVar, zzdnn zzdnnVar) {
        this.a = str;
        this.b = str2;
        this.c = zzbpoVar;
        this.d = zzdonVar;
        this.e = zzdnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<Object> a() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzwq.e().a(zzabf.cQ)).booleanValue()) {
            this.c.a(this.e.d);
            bundle.putAll(this.d.a());
        }
        return zzdyr.a(new zzdfj(this, bundle) { // from class: com.google.android.gms.internal.ads.acs
            private final zzdbc a;
            private final Bundle b;

            {
                this.a = this;
                this.b = bundle;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Object obj) {
                this.a.a(this.b, (Bundle) obj);
            }
        });
    }

    final /* synthetic */ void a(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzwq.e().a(zzabf.cQ)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzwq.e().a(zzabf.cP)).booleanValue()) {
                synchronized (f) {
                    this.c.a(this.e.d);
                    bundle2.putBundle("quality_signals", this.d.a());
                }
            } else {
                this.c.a(this.e.d);
                bundle2.putBundle("quality_signals", this.d.a());
            }
        }
        bundle2.putString("seq_num", this.a);
        bundle2.putString("session_id", this.b);
    }
}
