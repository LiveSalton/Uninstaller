package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class fr implements zzdyo<Object> {
    private final /* synthetic */ String a;

    fr(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzp.g().b(th, this.a);
    }
}
