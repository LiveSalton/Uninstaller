package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.util.zzm;

/* compiled from: source */
/* loaded from: classes.dex */
final class f extends com.google.android.gms.ads.internal.util.zza {
    final /* synthetic */ zze a;

    /* JADX INFO: Access modifiers changed from: private */
    f(zze zzeVar) {
        this.a = zzeVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void a() {
        Bitmap a = com.google.android.gms.ads.internal.zzp.v().a(Integer.valueOf(this.a.b.o.e));
        if (a != null) {
            zzm.a.post(new Runnable(this, com.google.android.gms.ads.internal.zzp.e().a(this.a.a, a, this.a.b.o.c, this.a.b.o.d)) { // from class: com.google.android.gms.ads.internal.overlay.g
                private final f a;
                private final Drawable b;

                {
                    this.a = this;
                    this.b = a2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    f fVar = this.a;
                    fVar.a.a.getWindow().setBackgroundDrawable(this.b);
                }
            });
        }
    }

    /* synthetic */ f(zze zzeVar, b bVar) {
        this(zzeVar);
    }
}
