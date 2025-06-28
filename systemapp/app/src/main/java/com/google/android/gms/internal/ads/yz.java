package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class yz implements zzcaf {
    private final zzdmu a;
    private final zzapo b;
    private final boolean c;
    private zzbsl d = null;

    yz(zzdmu zzdmuVar, zzapo zzapoVar, boolean z) {
        this.a = zzdmuVar;
        this.b = zzapoVar;
        this.c = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void a(boolean z, Context context) throws zzcai {
        boolean b;
        try {
            if (this.c) {
                b = this.b.c(ObjectWrapper.a(context));
            } else {
                b = this.b.b(ObjectWrapper.a(context));
            }
            if (!b) {
                throw new zzcai("Adapter failed to show.");
            }
            if (this.d == null) {
                return;
            }
            if (((Boolean) zzwq.e().a(zzabf.aQ)).booleanValue() || this.a.S != 2) {
                return;
            }
            this.d.a();
        } catch (Throwable th) {
            throw new zzcai(th);
        }
    }

    public final void a(zzbsl zzbslVar) {
        this.d = zzbslVar;
    }
}
