package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdnp {
    private zzvk a;
    private zzvn b;
    private zzxu c;
    private String d;
    private zzaak e;
    private boolean f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private zzadz i;
    private zzvw j;
    private PublisherAdViewOptions k;
    private zzxo l;
    private zzajl n;
    private int m = 1;
    private zzdnc o = new zzdnc();
    private boolean p = false;

    public final zzdnp a(zzvk zzvkVar) {
        this.a = zzvkVar;
        return this;
    }

    public final zzvk a() {
        return this.a;
    }

    public final zzdnp a(zzvn zzvnVar) {
        this.b = zzvnVar;
        return this;
    }

    public final zzdnp a(boolean z) {
        this.p = z;
        return this;
    }

    public final zzvn b() {
        return this.b;
    }

    public final zzdnp a(zzxu zzxuVar) {
        this.c = zzxuVar;
        return this;
    }

    public final zzdnp a(String str) {
        this.d = str;
        return this;
    }

    public final String c() {
        return this.d;
    }

    public final zzdnp a(zzaak zzaakVar) {
        this.e = zzaakVar;
        return this;
    }

    public final zzdnc d() {
        return this.o;
    }

    public final zzdnp b(boolean z) {
        this.f = z;
        return this;
    }

    public final zzdnp a(int i) {
        this.m = i;
        return this;
    }

    public final zzdnp a(ArrayList<String> arrayList) {
        this.g = arrayList;
        return this;
    }

    public final zzdnp b(ArrayList<String> arrayList) {
        this.h = arrayList;
        return this;
    }

    public final zzdnp a(zzadz zzadzVar) {
        this.i = zzadzVar;
        return this;
    }

    public final zzdnp a(zzvw zzvwVar) {
        this.j = zzvwVar;
        return this;
    }

    public final zzdnp a(zzajl zzajlVar) {
        this.n = zzajlVar;
        this.e = new zzaak(false, true, false);
        return this;
    }

    public final zzdnp a(PublisherAdViewOptions publisherAdViewOptions) {
        this.k = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.f = publisherAdViewOptions.a();
            this.l = publisherAdViewOptions.b();
        }
        return this;
    }

    public final zzdnp a(zzdnn zzdnnVar) {
        this.o.a(zzdnnVar.n);
        this.a = zzdnnVar.d;
        this.b = zzdnnVar.e;
        this.c = zzdnnVar.a;
        this.d = zzdnnVar.f;
        this.e = zzdnnVar.b;
        this.g = zzdnnVar.g;
        this.h = zzdnnVar.h;
        this.i = zzdnnVar.i;
        this.j = zzdnnVar.j;
        zzdnp a = a(zzdnnVar.l);
        a.p = zzdnnVar.o;
        return a;
    }

    public final zzdnn e() {
        Preconditions.a(this.d, (Object) "ad unit must not be null");
        Preconditions.a(this.b, "ad size must not be null");
        Preconditions.a(this.a, "ad request must not be null");
        return new zzdnn(this);
    }

    public final boolean f() {
        return this.p;
    }
}
