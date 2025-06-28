package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwu implements zzcwo<zzbyx> {
    private final Context a;
    private final zzbzx b;

    public zzcwu(Context context, zzbzx zzbzxVar) {
        this.a = context;
        this.b = zzbzxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwo
    public final /* synthetic */ zzbyx a(zzdnj zzdnjVar, zzdmu zzdmuVar, View view, zzcwr zzcwrVar) {
        zzbyz a = this.b.a(new zzbos(zzdnjVar, zzdmuVar, null), new aal(this, aaj.a));
        zzcwrVar.a(new aak(this, a));
        return a.h();
    }
}
