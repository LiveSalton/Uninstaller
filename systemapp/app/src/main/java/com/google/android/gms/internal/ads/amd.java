package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class amd<E> extends ama<E> {
    private final zzdwm<E> a;

    amd(zzdwm<E> zzdwmVar, int i) {
        super(zzdwmVar.size(), i);
        this.a = zzdwmVar;
    }

    @Override // com.google.android.gms.internal.ads.ama
    protected final E a(int i) {
        return this.a.get(i);
    }
}
