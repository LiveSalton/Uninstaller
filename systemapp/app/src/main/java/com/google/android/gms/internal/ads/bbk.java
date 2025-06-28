package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbk implements Handler.Callback, Choreographer.FrameCallback {
    private static final bbk b = new bbk();
    public volatile long a;
    private final Handler c;
    private final HandlerThread d = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer e;
    private int f;

    public static bbk a() {
        return b;
    }

    private bbk() {
        this.d.start();
        this.c = new Handler(this.d.getLooper(), this);
        this.c.sendEmptyMessage(0);
    }

    public final void b() {
        this.c.sendEmptyMessage(1);
    }

    public final void c() {
        this.c.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.a = j;
        this.e.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.e = Choreographer.getInstance();
                break;
            case 1:
                this.f++;
                if (this.f == 1) {
                    this.e.postFrameCallback(this);
                    break;
                }
                break;
            case 2:
                this.f--;
                if (this.f == 0) {
                    this.e.removeFrameCallback(this);
                    this.a = 0L;
                    break;
                }
                break;
        }
        return true;
    }
}
