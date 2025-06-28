package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdex implements zzdfi<zzdeu> {
    private final zzdzc a;
    private final Context b;
    private final zzazh c;

    public zzdex(zzdzc zzdzcVar, Context context, zzazh zzazhVar) {
        this.a = zzdzcVar;
        this.b = context;
        this.c = zzazhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdeu> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aeb
            private final zzdex a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdeu b() throws Exception {
        boolean a = Wrappers.a(this.b).a();
        zzp.c();
        boolean j = com.google.android.gms.ads.internal.util.zzm.j(this.b);
        String str = this.c.a;
        zzp.e();
        boolean d = com.google.android.gms.ads.internal.util.zzu.d();
        zzp.c();
        return new zzdeu(a, j, str, d, com.google.android.gms.ads.internal.util.zzm.h(this.b), DynamiteModule.b(this.b, ModuleDescriptor.MODULE_ID), DynamiteModule.a(this.b, ModuleDescriptor.MODULE_ID));
    }
}
