package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpb;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: source */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
final class bbc<T extends zzpb> extends Handler implements Runnable {
    public final int a;
    private final T b;
    private final zzoz<T> c;
    private final long d;
    private IOException e;
    private int f;
    private volatile Thread g;
    private volatile boolean h;
    private final /* synthetic */ zzow i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbc(zzow zzowVar, Looper looper, T t, zzoz<T> zzozVar, int i, long j) {
        super(looper);
        this.i = zzowVar;
        this.b = t;
        this.c = zzozVar;
        this.a = i;
        this.d = j;
    }

    public final void a(int i) throws IOException {
        if (this.e != null && this.f > i) {
            throw this.e;
        }
    }

    public final void a(long j) {
        bbc bbcVar;
        bbcVar = this.i.b;
        zzpc.b(bbcVar == null);
        this.i.b = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            a();
        }
    }

    public final void a(boolean z) {
        this.h = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.b.a();
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.c.a((zzoz<T>) this.b, elapsedRealtime, elapsedRealtime - this.d, true);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.b.b()) {
                String valueOf = String.valueOf(this.b.getClass().getSimpleName());
                zzpq.a(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.b.c();
                    zzpq.a();
                } catch (Throwable th) {
                    zzpq.a();
                    throw th;
                }
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.h) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (InterruptedException unused) {
            zzpc.b(this.b.b());
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (this.h) {
                return;
            }
            obtainMessage(3, new zzpa(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (this.h) {
                return;
            }
            obtainMessage(3, new zzpa(e3)).sendToTarget();
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.h) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.h) {
            return;
        }
        if (message.what == 0) {
            a();
            return;
        }
        if (message.what == 4) {
            throw ((Error) message.obj);
        }
        b();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.d;
        if (this.b.b()) {
            this.c.a((zzoz<T>) this.b, elapsedRealtime, j, false);
            return;
        }
        switch (message.what) {
            case 1:
                this.c.a((zzoz<T>) this.b, elapsedRealtime, j, false);
                return;
            case 2:
                this.c.a(this.b, elapsedRealtime, j);
                return;
            case 3:
                this.e = (IOException) message.obj;
                int a = this.c.a((zzoz<T>) this.b, elapsedRealtime, j, this.e);
                if (a == 3) {
                    this.i.c = this.e;
                    return;
                } else {
                    if (a != 2) {
                        this.f = a == 1 ? 1 : this.f + 1;
                        a(Math.min((this.f - 1) * 1000, 5000));
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private final void a() {
        ExecutorService executorService;
        bbc bbcVar;
        this.e = null;
        executorService = this.i.a;
        bbcVar = this.i.b;
        executorService.execute(bbcVar);
    }

    private final void b() {
        this.i.b = null;
    }
}
