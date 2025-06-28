package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcjx implements zzepf<Set<zzbxy<zzdru>>> {
    private final zzeps<String> a;
    private final zzeps<Context> b;
    private final zzeps<Executor> c;
    private final zzeps<Map<zzdrl, zzckc>> d;

    public zzcjx(zzeps<String> zzepsVar, zzeps<Context> zzepsVar2, zzeps<Executor> zzepsVar3, zzeps<Map<zzdrl, zzckc>> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Set emptySet;
        String b = this.a.b();
        Context b2 = this.b.b();
        Executor b3 = this.c.b();
        Map<zzdrl, zzckc> b4 = this.d.b();
        if (((Boolean) zzwq.e().a(zzabf.ct)).booleanValue()) {
            zzts zztsVar = new zzts(new zztx(b2));
            zztsVar.a(new zztv(b) { // from class: com.google.android.gms.internal.ads.ul
                private final String a;

                {
                    this.a = b;
                }

                @Override // com.google.android.gms.internal.ads.zztv
                public final void a(zzue.zzi.zza zzaVar) {
                    zzaVar.a(this.a);
                }
            });
            emptySet = Collections.singleton(new zzbxy(new zzcka(zztsVar, b4), b3));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzepl.a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
