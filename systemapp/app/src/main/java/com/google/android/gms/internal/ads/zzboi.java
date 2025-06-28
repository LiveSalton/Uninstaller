package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzboi {
    public final List<? extends zzdyz<? extends zzboc>> a;

    public zzboi(List<? extends zzdyz<? extends zzboc>> list) {
        this.a = list;
    }

    public zzboi(zzboc zzbocVar) {
        this.a = Collections.singletonList(zzdyr.a(zzbocVar));
    }

    public static zzcqz<zzboi> a(zzcto<? extends zzboc> zzctoVar) {
        return new zzcrc(zzctoVar, lz.a);
    }

    public static zzcqz<zzboi> a(zzcqz<? extends zzboc> zzcqzVar) {
        return new zzcrc(zzcqzVar, ma.a);
    }
}
