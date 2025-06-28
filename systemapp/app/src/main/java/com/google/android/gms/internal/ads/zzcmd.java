package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmd {
    private final zzdzc a;
    private final zzdzc b;
    private final zzcns c;
    private final zzeoz<zzcou> d;

    public zzcmd(zzdzc zzdzcVar, zzdzc zzdzcVar2, zzcns zzcnsVar, zzeoz<zzcou> zzeozVar) {
        this.a = zzdzcVar;
        this.b = zzdzcVar2;
        this.c = zzcnsVar;
        this.d = zzeozVar;
    }

    public final zzdyz<InputStream> a(zzatl zzatlVar) {
        zzdyz a;
        String str = zzatlVar.d;
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.e(str)) {
            a = zzdyr.a((Throwable) new zzcoh(zzdok.INTERNAL_ERROR));
        } else {
            a = zzdyr.a(this.a.submit(new Callable(this, zzatlVar) { // from class: com.google.android.gms.internal.ads.ve
                private final zzcmd a;
                private final zzatl b;

                {
                    this.a = this;
                    this.b = zzatlVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.b(this.b);
                }
            }), ExecutionException.class, vd.a, this.b);
        }
        return zzdyr.a(a, zzcoh.class, new zzdyb(this, zzatlVar, Binder.getCallingUid()) { // from class: com.google.android.gms.internal.ads.vf
            private final zzcmd a;
            private final zzatl b;
            private final int c;

            {
                this.a = this;
                this.b = zzatlVar;
                this.c = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, (zzcoh) obj);
            }
        }, this.b);
    }

    final /* synthetic */ zzdyz a(zzatl zzatlVar, int i, zzcoh zzcohVar) throws Exception {
        return this.d.b().a(zzatlVar, i);
    }

    final /* synthetic */ InputStream b(zzatl zzatlVar) throws Exception {
        return this.c.a(zzatlVar).get(((Integer) zzwq.e().a(zzabf.cN)).intValue(), TimeUnit.SECONDS);
    }
}
