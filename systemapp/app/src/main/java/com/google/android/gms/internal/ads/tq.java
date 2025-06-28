package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class tq implements zzbyo {
    private final zzbdv a;

    private tq(zzbdv zzbdvVar) {
        this.a = zzbdvVar;
    }

    static zzbyo a(zzbdv zzbdvVar) {
        return new tq(zzbdvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void a() {
        this.a.destroy();
    }
}
