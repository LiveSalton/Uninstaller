package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* compiled from: source */
/* loaded from: classes.dex */
final class aby implements zzdyo<ArrayList<Uri>> {
    private final /* synthetic */ zzasa a;

    aby(zzcyx zzcyxVar, zzasa zzasaVar) {
        this.a = zzasaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        try {
            zzasa zzasaVar = this.a;
            String valueOf = String.valueOf(th.getMessage());
            zzasaVar.a(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(@Nonnull ArrayList<Uri> arrayList) {
        try {
            this.a.a(arrayList);
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }
}
