package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzait implements zzx {
    private volatile zzaii a;
    private final Context b;

    public zzait(Context context) {
        this.b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzx
    public final zzy a(zzaa<?> zzaaVar) throws zzao {
        zzail a = zzail.a(zzaaVar);
        long b = zzp.j().b();
        try {
            zzazq zzazqVar = new zzazq();
            this.a = new zzaii(this.b, zzp.q().a(), new ba(this, zzazqVar), new az(this, zzazqVar));
            this.a.f();
            zzdyz a2 = zzdyr.a(zzdyr.a(zzazqVar, new aw(this, a), zzazj.a), ((Integer) zzwq.e().a(zzabf.cd)).intValue(), TimeUnit.MILLISECONDS, zzazj.d);
            a2.a(new ax(this), zzazj.a);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) a2.get();
            long b2 = zzp.j().b() - b;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(b2);
            sb.append("ms");
            zzd.a(sb.toString());
            zzain zzainVar = (zzain) new zzatg(parcelFileDescriptor).a(zzain.CREATOR);
            if (zzainVar == null) {
                return null;
            }
            if (zzainVar.a) {
                throw new zzao(zzainVar.b);
            }
            if (zzainVar.e.length != zzainVar.f.length) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < zzainVar.e.length; i++) {
                hashMap.put(zzainVar.e[i], zzainVar.f[i]);
            }
            return new zzy(zzainVar.c, zzainVar.d, hashMap, zzainVar.g, zzainVar.h);
        } catch (InterruptedException | ExecutionException unused) {
            long b3 = zzp.j().b() - b;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(b3);
            sb2.append("ms");
            zzd.a(sb2.toString());
            return null;
        } catch (Throwable th) {
            long b4 = zzp.j().b() - b;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(b4);
            sb3.append("ms");
            zzd.a(sb3.toString());
            throw th;
        }
    }

    public final void a() {
        if (this.a == null) {
            return;
        }
        this.a.i();
        Binder.flushPendingCommands();
    }
}
