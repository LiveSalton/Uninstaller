package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class kp implements zzdmp {
    private Context a;
    private String b;
    private final /* synthetic */ zzbhg c;

    /* JADX INFO: Access modifiers changed from: private */
    kp(zzbhg zzbhgVar) {
        this.c = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdmp
    public final zzdmm a() {
        zzepl.a(this.a, (Class<Context>) Context.class);
        return new ko(this.c, this.a, this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzdmp
    public final /* synthetic */ zzdmp a(String str) {
        this.b = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdmp
    public final /* synthetic */ zzdmp a(Context context) {
        this.a = (Context) zzepl.a(context);
        return this;
    }

    /* synthetic */ kp(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
