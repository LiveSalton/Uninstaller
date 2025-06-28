package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbib {
    private zzbgl a;
    private zzbim b;
    private zzdrv c;
    private zzbiy d;
    private zzdoj e;

    /* JADX INFO: Access modifiers changed from: private */
    zzbib() {
    }

    public final zzbib a(zzbgl zzbglVar) {
        this.a = (zzbgl) zzepl.a(zzbglVar);
        return this;
    }

    public final zzbib a(zzbim zzbimVar) {
        this.b = (zzbim) zzepl.a(zzbimVar);
        return this;
    }

    public final zzbgm a() {
        zzepl.a(this.a, (Class<zzbgl>) zzbgl.class);
        zzepl.a(this.b, (Class<zzbim>) zzbim.class);
        if (this.c == null) {
            this.c = new zzdrv();
        }
        if (this.d == null) {
            this.d = new zzbiy();
        }
        if (this.e == null) {
            this.e = new zzdoj();
        }
        return new zzbhg(this.a, this.b, this.c, this.d, this.e);
    }

    /* synthetic */ zzbib(js jsVar) {
        this();
    }
}
