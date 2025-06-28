package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaaf extends zzyl {
    private final OnPaidEventListener a;

    public zzaaf(OnPaidEventListener onPaidEventListener) {
        this.a = onPaidEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final void a(zzvp zzvpVar) {
        if (this.a != null) {
            this.a.a(AdValue.a(zzvpVar.b, zzvpVar.c, zzvpVar.d));
        }
    }
}
