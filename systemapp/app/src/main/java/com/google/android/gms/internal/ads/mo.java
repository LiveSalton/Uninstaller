package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
final class mo implements zzbsp, zzbtj {
    private final Context a;
    private final zzdmu b;
    private final zzarq c;

    public mo(Context context, zzdmu zzdmuVar, zzarq zzarqVar) {
        this.a = context;
        this.b = zzdmuVar;
        this.c = zzarqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void a(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void b(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        if (this.b.Y == null || !this.b.Y.a) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.b.Y.b.isEmpty()) {
            arrayList.add(this.b.Y.b);
        }
        this.c.a(this.a, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void c(Context context) {
        this.c.a();
    }
}
