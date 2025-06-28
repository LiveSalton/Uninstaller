package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzad {
    private boolean a = false;
    private float b = 1.0f;

    public final synchronized void a(float f) {
        this.b = f;
    }

    public final synchronized float a() {
        if (!c()) {
            return 1.0f;
        }
        return this.b;
    }

    public final synchronized void a(boolean z) {
        this.a = z;
    }

    public final synchronized boolean b() {
        return this.a;
    }

    private final synchronized boolean c() {
        return this.b >= 0.0f;
    }

    public static float a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }
}
