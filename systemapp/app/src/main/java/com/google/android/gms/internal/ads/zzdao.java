package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdao implements zzepf<ack> {
    private final zzeps<Set<String>> a;

    private zzdao(zzeps<Set<String>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdao a(zzeps<Set<String>> zzepsVar) {
        return new zzdao(zzepsVar);
    }

    public static ack a(Set<String> set) {
        return new ack(set);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
