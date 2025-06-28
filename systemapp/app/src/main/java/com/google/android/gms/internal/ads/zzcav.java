package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcav implements zzepf<Set<String>> {
    private final zzeps<zzccl> a;

    public zzcav(zzeps<zzccl> zzepsVar) {
        this.a = zzepsVar;
    }

    public static Set<String> a(zzccl zzcclVar) {
        Set emptySet;
        if (zzcclVar.d() != null) {
            emptySet = Collections.singleton("banner");
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzepl.a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
