package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: source */
/* loaded from: classes.dex */
final class fz implements Runnable {
    private final /* synthetic */ MediaPlayer a;
    private final /* synthetic */ zzbac b;

    fz(zzbac zzbacVar, MediaPlayer mediaPlayer) {
        this.b = zzbacVar;
        this.a = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbam zzbamVar;
        zzbam zzbamVar2;
        this.b.a(this.a);
        zzbamVar = this.b.s;
        if (zzbamVar != null) {
            zzbamVar2 = this.b.s;
            zzbamVar2.b();
        }
    }
}
