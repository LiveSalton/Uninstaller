package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class zz implements zzbyl {
    final /* synthetic */ zzcvo a;
    private final /* synthetic */ zzdnj b;
    private final /* synthetic */ zzdmu c;
    private final /* synthetic */ zzcrb d;

    zz(zzcvo zzcvoVar, zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb zzcrbVar) {
        this.a = zzcvoVar;
        this.b = zzdnjVar;
        this.c = zzdmuVar;
        this.d = zzcrbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyl
    public final void a() {
        Executor executor;
        executor = this.a.b;
        executor.execute(new Runnable(this, this.b, this.c, this.d) { // from class: com.google.android.gms.internal.ads.zy
            private final zz a;
            private final zzdnj b;
            private final zzdmu c;
            private final zzcrb d;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
                this.d = zzcrbVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zz zzVar = this.a;
                zzdnj zzdnjVar2 = this.b;
                zzdmu zzdmuVar2 = this.c;
                zzcrb zzcrbVar2 = this.d;
                zzcvo zzcvoVar = zzVar.a;
                zzcvo.c(zzdnjVar2, zzdmuVar2, zzcrbVar2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyl
    public final void a(int i) {
        String valueOf = String.valueOf(this.d.a);
        zzd.e(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
