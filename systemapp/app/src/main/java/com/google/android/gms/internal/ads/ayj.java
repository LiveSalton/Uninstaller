package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* compiled from: source */
/* loaded from: classes.dex */
class ayj {
    protected AudioTrack a;
    private boolean b;
    private int c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;

    private ayj() {
    }

    public boolean d() {
        return false;
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.a = audioTrack;
        this.b = z;
        this.g = -9223372036854775807L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        if (audioTrack != null) {
            this.c = audioTrack.getSampleRate();
        }
    }

    public final void a(long j) {
        this.h = b();
        this.g = SystemClock.elapsedRealtime() * 1000;
        this.i = j;
        this.a.stop();
    }

    public final void a() {
        if (this.g != -9223372036854775807L) {
            return;
        }
        this.a.pause();
    }

    public final long b() {
        if (this.g != -9223372036854775807L) {
            return Math.min(this.i, this.h + ((((SystemClock.elapsedRealtime() * 1000) - this.g) * this.c) / 1000000));
        }
        int playState = this.a.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.a.getPlaybackHeadPosition();
        if (this.b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f = this.d;
            }
            playbackHeadPosition += this.f;
        }
        if (this.d > playbackHeadPosition) {
            this.e++;
        }
        this.d = playbackHeadPosition;
        return playbackHeadPosition + (this.e << 32);
    }

    public final long c() {
        return (b() * 1000000) / this.c;
    }

    public long e() {
        throw new UnsupportedOperationException();
    }

    public long f() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ ayj(ayk aykVar) {
        this();
    }
}
