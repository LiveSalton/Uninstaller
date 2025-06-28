package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbks implements zzepf<Set<zzbxy<zzp>>> {
    private final zzeps<zzbki> a;
    private final zzeps<Executor> b;
    private final zzeps<JSONObject> c;

    private zzbks(zzeps<zzbki> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<JSONObject> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbks a(zzeps<zzbki> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<JSONObject> zzepsVar3) {
        return new zzbks(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Set singleton;
        zzbki b = this.a.b();
        Executor b2 = this.b.b();
        if (this.c.b() == null) {
            singleton = Collections.emptySet();
        } else {
            singleton = Collections.singleton(new zzbxy(b, b2));
        }
        return (Set) zzepl.a(singleton, "Cannot return null from a non-@Nullable @Provides method");
    }
}
