package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmo implements zzepf<zzdyz<String>> {
    private final zzeps<zzef> a;
    private final zzeps<Context> b;
    private final zzeps<zzdzc> c;

    private zzcmo(zzeps<zzef> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzdzc> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzcmo a(zzeps<zzef> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzdzc> zzepsVar3) {
        return new zzcmo(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdyz) zzepl.a(this.c.b().submit(new Callable(this.a.b(), this.b.b()) { // from class: com.google.android.gms.internal.ads.vh
            private final zzef a;
            private final Context b;

            {
                this.a = b;
                this.b = b2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzef zzefVar = this.a;
                return zzefVar.a().a(this.b);
            }
        }), "Cannot return null from a non-@Nullable @Provides method");
    }
}
