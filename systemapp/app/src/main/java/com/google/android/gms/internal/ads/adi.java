package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class adi implements Callable {
    static final Callable a = new adi();

    private adi() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new zzdcu(zzp.m().a(), zzp.m().b());
    }
}
