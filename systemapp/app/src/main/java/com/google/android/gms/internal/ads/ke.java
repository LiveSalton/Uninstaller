package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class ke implements zzdii {
    private Context a;
    private String b;
    private final /* synthetic */ zzbhg c;

    /* JADX INFO: Access modifiers changed from: private */
    ke(zzbhg zzbhgVar) {
        this.c = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final zzdij a() {
        zzepl.a(this.a, (Class<Context>) Context.class);
        zzepl.a(this.b, (Class<String>) String.class);
        return new kd(this.c, this.a, this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ zzdii a(String str) {
        this.b = (String) zzepl.a(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final /* synthetic */ zzdii a(Context context) {
        this.a = (Context) zzepl.a(context);
        return this;
    }

    /* synthetic */ ke(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
