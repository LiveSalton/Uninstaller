package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzt implements zzak {
    private final Executor a;

    public zzt(Handler handler) {
        this.a = new bck(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void a(zzaa<?> zzaaVar, zzaj<?> zzajVar) {
        a(zzaaVar, zzajVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void a(zzaa<?> zzaaVar, zzaj<?> zzajVar, Runnable runnable) {
        zzaaVar.l();
        zzaaVar.b("post-response");
        this.a.execute(new bdu(zzaaVar, zzajVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void a(zzaa<?> zzaaVar, zzao zzaoVar) {
        zzaaVar.b("post-error");
        this.a.execute(new bdu(zzaaVar, zzaj.a(zzaoVar), null));
    }
}
