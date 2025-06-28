package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class ay extends zzaio {
    private final /* synthetic */ zzazq a;

    ay(aw awVar, zzazq zzazqVar) {
        this.a = zzazqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void a(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.a.b(parcelFileDescriptor);
    }
}
