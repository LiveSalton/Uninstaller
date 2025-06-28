package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzas;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcnt extends zzate {
    private final /* synthetic */ zzcnu a;

    protected zzcnt(zzcnu zzcnuVar) {
        this.a = zzcnuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatf
    public final void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.a.a.b(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    @Override // com.google.android.gms.internal.ads.zzatf
    public final void a(com.google.android.gms.ads.internal.util.zzap zzapVar) {
        this.a.a.a(new zzas(zzapVar.a, zzapVar.b));
    }
}
