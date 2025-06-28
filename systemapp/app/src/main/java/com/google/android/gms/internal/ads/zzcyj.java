package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcyj {
    private final zzccl a;
    private final zzcxq b = new zzcxq();
    private final zzbrz c;

    public zzcyj(zzccl zzcclVar) {
        this.a = zzcclVar;
        this.c = new zzbrz(this.b, this.a.e()) { // from class: com.google.android.gms.internal.ads.abh
            private final zzcxq a;
            private final zzajt b;

            {
                this.a = zzcxqVar;
                this.b = e;
            }

            @Override // com.google.android.gms.internal.ads.zzbrz
            public final void a_(zzve zzveVar) {
                zzcxq zzcxqVar2 = this.a;
                zzajt zzajtVar = this.b;
                zzcxqVar2.a_(zzveVar);
                if (zzajtVar != null) {
                    try {
                        zzajtVar.a(zzveVar);
                    } catch (RemoteException e2) {
                        zzaza.e("#007 Could not call remote method.", e2);
                    }
                }
                if (zzajtVar != null) {
                    try {
                        zzajtVar.a(zzveVar.a);
                    } catch (RemoteException e3) {
                        zzaza.e("#007 Could not call remote method.", e3);
                    }
                }
            }
        };
    }

    public final void a(zzwt zzwtVar) {
        this.b.a(zzwtVar);
    }

    public final zzcap a() {
        return new zzcap(this.a, this.b.i());
    }

    public final zzcxq b() {
        return this.b;
    }

    public final zzbru c() {
        return this.b;
    }

    public final zzbtj d() {
        return this.b;
    }

    public final zzbrz e() {
        return this.c;
    }

    public final zzbsm f() {
        return this.b;
    }

    public final zzva g() {
        return this.b;
    }
}
