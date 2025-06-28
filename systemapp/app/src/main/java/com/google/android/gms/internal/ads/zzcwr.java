package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwr implements zzg {

    @GuardedBy("this")
    private zzg a;

    public final synchronized void a(zzg zzgVar) {
        this.a = zzgVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void a(View view) {
        if (this.a != null) {
            this.a.a(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void a() {
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void b() {
        if (this.a != null) {
            this.a.b();
        }
    }
}
