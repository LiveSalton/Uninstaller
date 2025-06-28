package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbml implements zzepf<View> {
    private final zzbmh a;

    public zzbml(zzbmh zzbmhVar) {
        this.a = zzbmhVar;
    }

    public static View a(zzbmh zzbmhVar) {
        return (View) zzepl.a(zzbmhVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
