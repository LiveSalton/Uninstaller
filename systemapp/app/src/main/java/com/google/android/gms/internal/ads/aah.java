package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

/* compiled from: source */
/* loaded from: classes.dex */
final class aah implements zzg {
    private final /* synthetic */ zzazq a;
    private final /* synthetic */ zzdnj b;
    private final /* synthetic */ zzdmu c;
    private final /* synthetic */ zzcwr d;
    private final /* synthetic */ zzcwj e;

    aah(zzcwj zzcwjVar, zzazq zzazqVar, zzdnj zzdnjVar, zzdmu zzdmuVar, zzcwr zzcwrVar) {
        this.e = zzcwjVar;
        this.a = zzazqVar;
        this.b = zzdnjVar;
        this.c = zzdmuVar;
        this.d = zzcwrVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void a() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void b() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void a(View view) {
        zzcwo zzcwoVar;
        zzazq zzazqVar = this.a;
        zzcwoVar = this.e.d;
        zzazqVar.b(zzcwoVar.a(this.b, this.c, view, this.d));
    }
}
