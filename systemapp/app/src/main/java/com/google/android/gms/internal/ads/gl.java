package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class gl implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ zzbar b;

    gl(zzbar zzbarVar, boolean z) {
        this.b = zzbarVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b("windowVisibilityChanged", "isVisible", String.valueOf(this.a));
    }
}
