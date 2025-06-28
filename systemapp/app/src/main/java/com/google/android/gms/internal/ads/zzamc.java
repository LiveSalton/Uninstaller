package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzamc {
    private final Object a = new Object();
    private final Object b = new Object();

    @GuardedBy("lockClient")
    private zzaml c;

    @GuardedBy("lockService")
    private zzaml d;

    public final zzaml a(Context context, zzazh zzazhVar) {
        zzaml zzamlVar;
        synchronized (this.b) {
            if (this.d == null) {
                this.d = new zzaml(a(context), zzazhVar, zzadj.a.a());
            }
            zzamlVar = this.d;
        }
        return zzamlVar;
    }

    public final zzaml b(Context context, zzazh zzazhVar) {
        zzaml zzamlVar;
        synchronized (this.a) {
            if (this.c == null) {
                this.c = new zzaml(a(context), zzazhVar, (String) zzwq.e().a(zzabf.a));
            }
            zzamlVar = this.c;
        }
        return zzamlVar;
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
