package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdet implements zzdfi<zzdeq> {
    private final zzawx a;
    private final zzdzc b;
    private final Context c;

    public zzdet(zzawx zzawxVar, zzdzc zzdzcVar, Context context) {
        this.a = zzawxVar;
        this.b = zzdzcVar;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdeq> a() {
        return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aea
            private final zzdet a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdeq b() throws Exception {
        Long l;
        if (!this.a.a(this.c)) {
            return new zzdeq(null, null, null, null, null);
        }
        String c = this.a.c(this.c);
        if (c == null) {
            c = "";
        }
        String str = c;
        String d = this.a.d(this.c);
        if (d == null) {
            d = "";
        }
        String str2 = d;
        String e = this.a.e(this.c);
        if (e == null) {
            e = "";
        }
        String str3 = e;
        String f = this.a.f(this.c);
        if (f == null) {
            f = "";
        }
        String str4 = f;
        if ("TIME_OUT".equals(str2)) {
            l = (Long) zzwq.e().a(zzabf.W);
        } else {
            l = null;
        }
        return new zzdeq(str, str2, str3, str4, l);
    }
}
