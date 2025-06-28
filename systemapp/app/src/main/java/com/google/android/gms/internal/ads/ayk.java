package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayk extends Thread {
    private final /* synthetic */ AudioTrack a;
    private final /* synthetic */ zzip b;

    ayk(zzip zzipVar, AudioTrack audioTrack) {
        this.b = zzipVar;
        this.a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.a.flush();
            this.a.release();
        } finally {
            conditionVariable = this.b.h;
            conditionVariable.open();
        }
    }
}
