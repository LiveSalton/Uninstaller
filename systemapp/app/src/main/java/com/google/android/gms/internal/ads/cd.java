package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
final class cd implements zzazu<zzalz> {
    private final /* synthetic */ zzalo a;

    cd(zzalo zzaloVar) {
        this.a = zzaloVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazu
    public final /* synthetic */ void a(zzalz zzalzVar) {
        zzals zzalsVar;
        zzd.a("Releasing engine reference.");
        zzalsVar = this.a.b;
        zzalsVar.b();
    }
}
