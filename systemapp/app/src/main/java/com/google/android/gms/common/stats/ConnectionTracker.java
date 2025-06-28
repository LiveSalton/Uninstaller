package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzo;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class ConnectionTracker {
    private static volatile ConnectionTracker b = null;

    @VisibleForTesting
    private static boolean c = false;

    @VisibleForTesting
    private ConcurrentHashMap<ServiceConnection, ServiceConnection> e = new ConcurrentHashMap<>();
    private static final Object a = new Object();
    private static zzo<Boolean> d = zzn.a(a.a);

    @KeepForSdk
    public static ConnectionTracker a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new ConnectionTracker();
                }
            }
        }
        return b;
    }

    static final /* synthetic */ boolean b() {
        return false;
    }

    private ConnectionTracker() {
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, str, intent, serviceConnection, i, true);
    }

    @SuppressLint({"UntrackedBindService"})
    private final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : ClientLibraryUtils.a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        if (a(serviceConnection)) {
            ServiceConnection putIfAbsent = this.e.putIfAbsent(serviceConnection, serviceConnection);
            if (putIfAbsent != null && serviceConnection != putIfAbsent) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                boolean bindService = context.bindService(intent, serviceConnection, i);
                return !bindService ? bindService : bindService;
            } finally {
                this.e.remove(serviceConnection, serviceConnection);
            }
        }
        return context.bindService(intent, serviceConnection, i);
    }

    @KeepForSdk
    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @KeepForSdk
    @SuppressLint({"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        if (a(serviceConnection) && this.e.containsKey(serviceConnection)) {
            try {
                b(context, this.e.get(serviceConnection));
                return;
            } finally {
                this.e.remove(serviceConnection);
            }
        }
        b(context, serviceConnection);
    }

    private static boolean a(ServiceConnection serviceConnection) {
        return d.a().booleanValue() && !(serviceConnection instanceof zzj);
    }

    @SuppressLint({"UntrackedBindService"})
    private static void b(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e);
        }
    }
}
