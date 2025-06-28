package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class fg extends Thread {
    private final /* synthetic */ String a;

    fg(fh fhVar, String str) {
        this.a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzaze().a(this.a);
    }
}
