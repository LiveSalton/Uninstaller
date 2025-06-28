package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyg implements zzbyd {
    private final List<String> a;
    private final zzdrz b;
    private boolean c;

    public zzbyg(zzdmu zzdmuVar, zzdrz zzdrzVar) {
        this.a = zzdmuVar.o;
        this.b = zzdrzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyd
    public final void a() {
        if (this.c) {
            return;
        }
        this.b.a(this.a);
        this.c = true;
    }
}
