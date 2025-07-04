package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class BlockingServiceConnection implements ServiceConnection {
    private boolean a = false;
    private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add(iBinder);
    }

    @KeepForSdk
    public IBinder a(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.a = true;
        IBinder poll = this.b.poll(j, timeUnit);
        if (poll == null) {
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        return poll;
    }
}
