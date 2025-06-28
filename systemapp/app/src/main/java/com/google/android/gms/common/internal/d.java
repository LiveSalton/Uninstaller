package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
final class d implements Handler.Callback {
    private final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: private */
    d(c cVar) {
        this.a = cVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        switch (message.what) {
            case 0:
                hashMap = this.a.a;
                synchronized (hashMap) {
                    GmsClientSupervisor.zza zzaVar = (GmsClientSupervisor.zza) message.obj;
                    hashMap2 = this.a.a;
                    e eVar = (e) hashMap2.get(zzaVar);
                    if (eVar != null && eVar.c()) {
                        if (eVar.a()) {
                            eVar.b("GmsClientSupervisor");
                        }
                        hashMap3 = this.a.a;
                        hashMap3.remove(zzaVar);
                    }
                }
                return true;
            case 1:
                hashMap4 = this.a.a;
                synchronized (hashMap4) {
                    GmsClientSupervisor.zza zzaVar2 = (GmsClientSupervisor.zza) message.obj;
                    hashMap5 = this.a.a;
                    e eVar2 = (e) hashMap5.get(zzaVar2);
                    if (eVar2 != null && eVar2.b() == 3) {
                        String valueOf = String.valueOf(zzaVar2);
                        StringBuilder sb = new StringBuilder(47 + String.valueOf(valueOf).length());
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(valueOf);
                        Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName e = eVar2.e();
                        if (e == null) {
                            e = zzaVar2.b();
                        }
                        if (e == null) {
                            e = new ComponentName((String) Preconditions.a(zzaVar2.a()), "unknown");
                        }
                        eVar2.onServiceDisconnected(e);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    /* synthetic */ d(c cVar, b bVar) {
        this(cVar);
    }
}
