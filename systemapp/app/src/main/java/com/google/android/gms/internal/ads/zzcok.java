package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcok {
    private final zzdzc a;
    private final zzcnx b;
    private final zzeoz<zzcou> c;

    public zzcok(zzdzc zzdzcVar, zzcnx zzcnxVar, zzeoz<zzcou> zzeozVar) {
        this.a = zzdzcVar;
        this.b = zzcnxVar;
        this.c = zzeozVar;
    }

    private final <RetT> zzdyz<RetT> a(zzatl zzatlVar, wm<InputStream> wmVar, wm<InputStream> wmVar2, zzdyb<InputStream, RetT> zzdybVar) {
        zzdyz a;
        String str = zzatlVar.d;
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.e(str)) {
            a = zzdyr.a((Throwable) new zzcoh(zzdok.INTERNAL_ERROR));
        } else {
            a = zzdyr.a(wmVar.a(zzatlVar), ExecutionException.class, wf.a, this.a);
        }
        return zzdyi.c(a).a(zzdybVar, this.a).a(zzcoh.class, new zzdyb(this, wmVar2, zzatlVar, zzdybVar) { // from class: com.google.android.gms.internal.ads.wh
            private final zzcok a;
            private final wm b;
            private final zzatl c;
            private final zzdyb d;

            {
                this.a = this;
                this.b = wmVar2;
                this.c = zzatlVar;
                this.d = zzdybVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, this.d, (zzcoh) obj);
            }
        }, this.a);
    }

    public final zzdyz<zzatl> a(zzatl zzatlVar) {
        zzdyb zzdybVar = new zzdyb(zzatlVar) { // from class: com.google.android.gms.internal.ads.wg
            private final zzatl a;

            {
                this.a = zzatlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                zzatl zzatlVar2 = this.a;
                zzatlVar2.k = new String(zzdxj.a((InputStream) obj), zzdvk.a);
                return zzdyr.a(zzatlVar2);
            }
        };
        zzcnx zzcnxVar = this.b;
        zzcnxVar.getClass();
        return a(zzatlVar, wj.a(zzcnxVar), new wm(this) { // from class: com.google.android.gms.internal.ads.wi
            private final zzcok a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.wm
            public final zzdyz a(zzatl zzatlVar2) {
                return this.a.e(zzatlVar2);
            }
        }, zzdybVar);
    }

    public final zzdyz<Void> b(zzatl zzatlVar) {
        if (zzff.b(zzatlVar.k)) {
            return zzdyr.a((Throwable) new zzcme(zzdok.INVALID_REQUEST, "Pool key missing from removeUrl call."));
        }
        return a(zzatlVar, new wm(this) { // from class: com.google.android.gms.internal.ads.wk
            private final zzcok a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.wm
            public final zzdyz a(zzatl zzatlVar2) {
                return this.a.d(zzatlVar2);
            }
        }, new wm(this) { // from class: com.google.android.gms.internal.ads.wn
            private final zzcok a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.wm
            public final zzdyz a(zzatl zzatlVar2) {
                return this.a.c(zzatlVar2);
            }
        }, wl.a);
    }

    final /* synthetic */ zzdyz c(zzatl zzatlVar) {
        return this.c.b().a(zzatlVar.k);
    }

    final /* synthetic */ zzdyz d(zzatl zzatlVar) {
        return this.b.a(zzatlVar.k);
    }

    final /* synthetic */ zzdyz e(zzatl zzatlVar) {
        return this.c.b().b(zzatlVar, Binder.getCallingUid());
    }

    final /* synthetic */ zzdyz a(wm wmVar, zzatl zzatlVar, zzdyb zzdybVar, zzcoh zzcohVar) throws Exception {
        return zzdyr.a(wmVar.a(zzatlVar), zzdybVar, this.a);
    }
}
