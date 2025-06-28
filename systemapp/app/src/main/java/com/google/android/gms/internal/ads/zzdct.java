package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdct implements zzdfi<zzdcq> {
    private final Context a;
    private final zzdzc b;

    public zzdct(Context context, zzdzc zzdzcVar) {
        this.a = context;
        this.b = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdcq> a() {
        return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.adh
            private final zzdct a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String c;
                String e;
                String str;
                zzp.c();
                zzrk a = zzp.g().h().a();
                Bundle bundle = null;
                if (a != null && a != null && (!zzp.g().h().b() || !zzp.g().h().d())) {
                    if (a.d()) {
                        a.c();
                    }
                    zzre b = a.b();
                    if (b != null) {
                        c = b.b();
                        str = b.c();
                        e = b.d();
                        if (c != null) {
                            zzp.g().h().a(c);
                        }
                        if (e != null) {
                            zzp.g().h().b(e);
                        }
                    } else {
                        c = zzp.g().h().c();
                        e = zzp.g().h().e();
                        str = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!zzp.g().h().d()) {
                        if (e == null || TextUtils.isEmpty(e)) {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        } else {
                            bundle2.putString("v_fp_vertical", e);
                        }
                    }
                    if (c != null && !zzp.g().h().b()) {
                        bundle2.putString("fingerprint", c);
                        if (!c.equals(str)) {
                            bundle2.putString("v_fp", str);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzdcq(bundle);
            }
        });
    }
}
