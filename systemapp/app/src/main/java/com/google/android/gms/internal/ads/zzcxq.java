package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxq implements AppEventListener, zzbru, zzbrz, zzbsm, zzbtj, zzbub, zzva {
    private final AtomicReference<zzwt> a = new AtomicReference<>();
    private final AtomicReference<zzxo> b = new AtomicReference<>();
    private final AtomicReference<zzym> c = new AtomicReference<>();

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void a(zzauf zzaufVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
    }

    public final synchronized zzwt i() {
        return this.a.get();
    }

    public final synchronized zzxo j() {
        return this.b.get();
    }

    public final void a(zzwt zzwtVar) {
        this.a.set(zzwtVar);
    }

    public final void a(zzxo zzxoVar) {
        this.b.set(zzxoVar);
    }

    public final void a(zzym zzymVar) {
        this.c.set(zzymVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
        zzdkb.a(this.a, aat.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        zzdkb.a(this.a, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.aav
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzwt) obj).a(this.a);
            }
        });
        zzdkb.a(this.a, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.aau
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzwt) obj).a(this.a.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
        zzdkb.a(this.a, aax.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        zzdkb.a(this.a, aaw.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
        zzdkb.a(this.a, aaz.a);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        zzdkb.a(this.a, aay.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        zzdkb.a(this.a, abb.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbub
    public final void a(zzvp zzvpVar) {
        zzdkb.a(this.c, new zzdka(zzvpVar) { // from class: com.google.android.gms.internal.ads.aba
            private final zzvp a;

            {
                this.a = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzym) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void a(String str, String str2) {
        zzdkb.a(this.b, new zzdka(str, str2) { // from class: com.google.android.gms.internal.ads.abc
            private final String a;
            private final String b;

            {
                this.a = str;
                this.b = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzxo) obj).a(this.a, this.b);
            }
        });
    }
}
