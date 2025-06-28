package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class agq implements zzdyo<Void> {
    agq(zzdju zzdjuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzd.a("Notification of cache hit failed.");
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(@NullableDecl Void r1) {
        zzd.a("Notification of cache hit successful.");
    }
}
