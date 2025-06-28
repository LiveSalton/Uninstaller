package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdau implements zzdfj<Bundle> {
    private final zzvw a;
    private final zzazh b;

    public zzdau(zzvw zzvwVar, zzazh zzazhVar) {
        this.a = zzvwVar;
        this.b = zzazhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        int intValue = ((Integer) zzwq.e().a(zzabf.cF)).intValue();
        if (this.b != null && this.b.c >= intValue) {
            bundle2.putString("app_open_version", "2");
        }
        if (this.a != null) {
            if (this.a.a == 1) {
                bundle2.putString("avo", "p");
            } else if (this.a.a == 2) {
                bundle2.putString("avo", "l");
            }
        }
    }
}
