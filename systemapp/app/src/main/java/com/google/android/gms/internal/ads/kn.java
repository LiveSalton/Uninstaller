package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class kn implements zzdlc {
    private Context a;
    private String b;
    private zzvn c;
    private final /* synthetic */ zzbhg d;

    /* JADX INFO: Access modifiers changed from: private */
    kn(zzbhg zzbhgVar) {
        this.d = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdlc
    public final zzdld a() {
        zzepl.a(this.a, (Class<Context>) Context.class);
        zzepl.a(this.b, (Class<String>) String.class);
        zzepl.a(this.c, (Class<zzvn>) zzvn.class);
        return new km(this.d, this.a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzdlc
    public final /* synthetic */ zzdlc a(zzvn zzvnVar) {
        this.c = (zzvn) zzepl.a(zzvnVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlc
    public final /* synthetic */ zzdlc a(String str) {
        this.b = (String) zzepl.a(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlc
    public final /* synthetic */ zzdlc a(Context context) {
        this.a = (Context) zzepl.a(context);
        return this;
    }

    /* synthetic */ kn(zzbhg zzbhgVar, js jsVar) {
        this(zzbhgVar);
    }
}
