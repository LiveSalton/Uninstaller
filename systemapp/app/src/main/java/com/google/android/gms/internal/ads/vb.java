package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
final class vb implements zzdyo<String> {
    final /* synthetic */ zzclp a;

    vb(zzclp zzclpVar) {
        this.a = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        long j;
        zzazq zzazqVar;
        synchronized (this) {
            zzclp.a(this.a, true);
            zzclp zzclpVar = this.a;
            long b = zzp.j().b();
            j = this.a.c;
            zzclpVar.a("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (b - j));
            zzazqVar = this.a.d;
            zzazqVar.a(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(@Nullable String str) {
        long j;
        Executor executor;
        String str2 = str;
        synchronized (this) {
            zzclp.a(this.a, true);
            zzclp zzclpVar = this.a;
            long b = zzp.j().b();
            j = this.a.c;
            zzclpVar.a("com.google.android.gms.ads.MobileAds", true, "", (int) (b - j));
            executor = this.a.h;
            executor.execute(new Runnable(this, str2) { // from class: com.google.android.gms.internal.ads.va
                private final vb a;
                private final String b;

                {
                    this.a = this;
                    this.b = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    vb vbVar = this.a;
                    vbVar.a.a(this.b);
                }
            });
        }
    }
}
