package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bl implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ zzakq b;

    bl(zzakq zzakqVar, String str) {
        this.b = zzakqVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdv zzbdvVar;
        zzbdvVar = this.b.a;
        zzbdvVar.loadData(this.a, "text/html", "UTF-8");
    }
}
