package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbmh {
    private final zzbnz a;
    private final View b;
    private final zzdmx c;
    private final zzbdv d;

    public zzbmh(View view, zzbdv zzbdvVar, zzbnz zzbnzVar, zzdmx zzdmxVar) {
        this.b = view;
        this.d = zzbdvVar;
        this.a = zzbnzVar;
        this.c = zzdmxVar;
    }

    public final zzbdv a() {
        return this.d;
    }

    public final View b() {
        return this.b;
    }

    public final zzbnz c() {
        return this.a;
    }

    public final zzdmx d() {
        return this.c;
    }

    public zzbte a(Set<zzbxy<zzbtj>> set) {
        return new zzbte(set);
    }
}
