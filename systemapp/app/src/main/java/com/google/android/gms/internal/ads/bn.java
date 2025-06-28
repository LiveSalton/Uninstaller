package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bn implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ zzakq b;

    bn(zzakq zzakqVar, String str) {
        this.b = zzakqVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdv zzbdvVar;
        zzbdvVar = this.b.a;
        zzbdvVar.loadUrl(this.a);
    }
}
