package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class e implements ServiceConnection, zzj {
    private final Map<ServiceConnection, ServiceConnection> a = new HashMap();
    private int b = 2;
    private boolean c;
    private IBinder d;
    private final GmsClientSupervisor.zza e;
    private ComponentName f;
    private final /* synthetic */ c g;

    public e(c cVar, GmsClientSupervisor.zza zzaVar) {
        this.g = cVar;
        this.e = zzaVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.g.a;
        synchronized (hashMap) {
            handler = this.g.c;
            handler.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            Iterator<ServiceConnection> it = this.a.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.g.a;
        synchronized (hashMap) {
            handler = this.g.c;
            handler.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            Iterator<ServiceConnection> it = this.a.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }

    public final void a(String str) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.b = 3;
        connectionTracker = this.g.d;
        context = this.g.b;
        GmsClientSupervisor.zza zzaVar = this.e;
        context2 = this.g.b;
        this.c = connectionTracker.a(context, str, zzaVar.a(context2), this, this.e.c());
        if (!this.c) {
            this.b = 2;
            try {
                connectionTracker2 = this.g.d;
                context3 = this.g.b;
                connectionTracker2.a(context3, this);
                return;
            } catch (IllegalArgumentException unused) {
                return;
            }
        }
        handler = this.g.c;
        Message obtainMessage = handler.obtainMessage(1, this.e);
        handler2 = this.g.c;
        j = this.g.f;
        handler2.sendMessageDelayed(obtainMessage, j);
    }

    public final void b(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.g.c;
        handler.removeMessages(1, this.e);
        connectionTracker = this.g.d;
        context = this.g.b;
        connectionTracker.a(context, this);
        this.c = false;
        this.b = 2;
    }

    public final void a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.a.put(serviceConnection, serviceConnection2);
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        this.a.remove(serviceConnection);
    }

    public final boolean a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    public final boolean c() {
        return this.a.isEmpty();
    }

    public final IBinder d() {
        return this.d;
    }

    public final ComponentName e() {
        return this.f;
    }
}
