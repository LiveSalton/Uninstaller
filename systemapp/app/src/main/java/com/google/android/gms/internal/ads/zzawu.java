package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzawu implements zzqu {
    private final Context a;
    private final Object b;
    private String c;
    private boolean d;

    public zzawu(Context context, String str) {
        this.a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = str;
        this.d = false;
        this.b = new Object();
    }

    public final void a(boolean z) {
        if (zzp.A().a(this.a)) {
            synchronized (this.b) {
                if (this.d == z) {
                    return;
                }
                this.d = z;
                if (TextUtils.isEmpty(this.c)) {
                    return;
                }
                if (this.d) {
                    zzp.A().a(this.a, this.c);
                } else {
                    zzp.A().b(this.a, this.c);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void a(zzqv zzqvVar) {
        a(zzqvVar.j);
    }

    public final String a() {
        return this.c;
    }
}
