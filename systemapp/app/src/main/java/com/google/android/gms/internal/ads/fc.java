package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class fc extends zza {
    private final /* synthetic */ zzayg a;

    fc(zzayg zzaygVar) {
        this.a = zzaygVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void a() {
        Context context;
        zzazh zzazhVar;
        Object obj;
        zzabi zzabiVar;
        context = this.a.e;
        zzazhVar = this.a.f;
        zzabj zzabjVar = new zzabj(context, zzazhVar.a);
        obj = this.a.a;
        synchronized (obj) {
            try {
                zzp.l();
                zzabiVar = this.a.g;
                zzabk.a(zzabiVar, zzabjVar);
            } catch (IllegalArgumentException e) {
                zzd.d("Cannot config CSI reporter.", e);
            }
        }
    }
}
