package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcix implements zzepf<zzts> {
    private final zzeps<Context> a;
    private final zzeps<String> b;
    private final zzeps<zzazh> c;
    private final zzeps<zzue.zza.EnumC0075zza> d;
    private final zzeps<String> e;

    private zzcix(zzeps<Context> zzepsVar, zzeps<String> zzepsVar2, zzeps<zzazh> zzepsVar3, zzeps<zzue.zza.EnumC0075zza> zzepsVar4, zzeps<String> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzcix a(zzeps<Context> zzepsVar, zzeps<String> zzepsVar2, zzeps<zzazh> zzepsVar3, zzeps<zzue.zza.EnumC0075zza> zzepsVar4, zzeps<String> zzepsVar5) {
        return new zzcix(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Context b = this.a.b();
        String b2 = this.b.b();
        zzazh b3 = this.c.b();
        zzue.zza.EnumC0075zza b4 = this.d.b();
        String b5 = this.e.b();
        zzts zztsVar = new zzts(new zztx(b));
        zztsVar.a(new zztv(b4, b2, (zzue.zzu) ((zzekh) zzue.zzu.a().a(b3.b).b(b3.c).c(b3.d ? 0 : 2).g()), b5) { // from class: com.google.android.gms.internal.ads.tz
            private final zzue.zza.EnumC0075zza a;
            private final String b;
            private final zzue.zzu c;
            private final String d;

            {
                this.a = b4;
                this.b = b2;
                this.c = zzuVar;
                this.d = b5;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                zzue.zza.EnumC0075zza enumC0075zza = this.a;
                String str = this.b;
                zzue.zzu zzuVar2 = this.c;
                zzaVar.a(zzaVar.j().p().a(enumC0075zza)).a(zzaVar.i().p().a(str).a(zzuVar2)).a(this.d);
            }
        });
        return (zzts) zzepl.a(zztsVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
