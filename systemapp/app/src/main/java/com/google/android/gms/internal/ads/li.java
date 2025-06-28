package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class li implements zzahv<Object> {
    final /* synthetic */ zzbjz a;

    li(zzbjz zzbjzVar) {
        this.a = zzbjzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        boolean a;
        Executor executor;
        a = this.a.a((Map<String, String>) map);
        if (a) {
            executor = this.a.c;
            executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.lh
                private final li a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbki zzbkiVar;
                    zzbkiVar = this.a.a.d;
                    zzbkiVar.e();
                }
            });
        }
    }
}
