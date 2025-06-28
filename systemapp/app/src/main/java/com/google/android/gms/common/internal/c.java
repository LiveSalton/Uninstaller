package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class c extends GmsClientSupervisor {
    private final Context b;
    private final Handler c;

    @GuardedBy("connectionStatus")
    private final HashMap<GmsClientSupervisor.zza, e> a = new HashMap<>();
    private final ConnectionTracker d = ConnectionTracker.a();
    private final long e = 5000;
    private final long f = 300000;

    c(Context context) {
        this.b = context.getApplicationContext();
        this.c = new com.google.android.gms.internal.common.zzi(context.getMainLooper(), new d(this));
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final boolean a(GmsClientSupervisor.zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        Preconditions.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            e eVar = this.a.get(zzaVar);
            if (eVar == null) {
                eVar = new e(this, zzaVar);
                eVar.a(serviceConnection, serviceConnection, str);
                eVar.a(str);
                this.a.put(zzaVar, eVar);
            } else {
                this.c.removeMessages(0, zzaVar);
                if (eVar.a(serviceConnection)) {
                    String valueOf = String.valueOf(zzaVar);
                    StringBuilder sb = new StringBuilder(81 + String.valueOf(valueOf).length());
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                eVar.a(serviceConnection, serviceConnection, str);
                switch (eVar.b()) {
                    case 1:
                        serviceConnection.onServiceConnected(eVar.e(), eVar.d());
                        break;
                    case 2:
                        eVar.a(str);
                        break;
                }
            }
            a = eVar.a();
        }
        return a;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void b(GmsClientSupervisor.zza zzaVar, ServiceConnection serviceConnection, String str) {
        Preconditions.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            e eVar = this.a.get(zzaVar);
            if (eVar == null) {
                String valueOf = String.valueOf(zzaVar);
                StringBuilder sb = new StringBuilder(50 + String.valueOf(valueOf).length());
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!eVar.a(serviceConnection)) {
                String valueOf2 = String.valueOf(zzaVar);
                StringBuilder sb2 = new StringBuilder(76 + String.valueOf(valueOf2).length());
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            eVar.a(serviceConnection, str);
            if (eVar.c()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(0, zzaVar), this.e);
            }
        }
    }
}
