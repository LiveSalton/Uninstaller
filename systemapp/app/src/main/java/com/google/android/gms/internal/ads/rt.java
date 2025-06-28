package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: source */
/* loaded from: classes.dex */
final class rt implements zzdvm<zzy, Bitmap> {
    private final /* synthetic */ double a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzcej c;

    rt(zzcej zzcejVar, double d, boolean z) {
        this.c = zzcejVar;
        this.a = d;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdvm
    public final /* synthetic */ Bitmap a(zzy zzyVar) {
        Bitmap a;
        a = this.c.a(zzyVar.b, this.a, this.b);
        return a;
    }
}
