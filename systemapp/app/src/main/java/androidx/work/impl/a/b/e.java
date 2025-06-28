package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.h;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends d<androidx.work.impl.a.b> {
    static final String d = h.a("NetworkStateTracker");
    private final ConnectivityManager e;
    private b f;
    private a g;

    public e(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
        this.e = (ConnectivityManager) this.b.getSystemService("connectivity");
        if (f()) {
            this.f = new b();
        } else {
            this.g = new a();
        }
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public androidx.work.impl.a.b c() {
        return b();
    }

    @Override // androidx.work.impl.a.b.d
    public void d() {
        if (f()) {
            h.a().b(d, "Registering network callback", new Throwable[0]);
            this.e.registerDefaultNetworkCallback(this.f);
        } else {
            h.a().b(d, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // androidx.work.impl.a.b.d
    public void e() {
        if (f()) {
            try {
                h.a().b(d, "Unregistering network callback", new Throwable[0]);
                this.e.unregisterNetworkCallback(this.f);
                return;
            } catch (IllegalArgumentException e) {
                h.a().e(d, "Received exception while unregistering network callback", e);
                return;
            }
        }
        h.a().b(d, "Unregistering broadcast receiver", new Throwable[0]);
        this.b.unregisterReceiver(this.g);
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    androidx.work.impl.a.b b() {
        NetworkInfo activeNetworkInfo = this.e.getActiveNetworkInfo();
        boolean z = false;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean g = g();
        boolean a2 = androidx.core.c.a.a(this.e);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z = true;
        }
        return new androidx.work.impl.a.b(z2, g, a2, z);
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        NetworkCapabilities networkCapabilities = this.e.getNetworkCapabilities(this.e.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(16);
    }

    /* compiled from: source */
    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            h.a().b(e.d, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e.this.a((e) e.this.b());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            h.a().b(e.d, "Network connection lost", new Throwable[0]);
            e.this.a((e) e.this.b());
        }
    }

    /* compiled from: source */
    private class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            h.a().b(e.d, "Network broadcast received", new Throwable[0]);
            e.this.a((e) e.this.b());
        }
    }
}
