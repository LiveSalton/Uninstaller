package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaec extends NativeAd.AdChoicesInfo {
    private final zzaeb a;
    private final List<NativeAd.Image> b = new ArrayList();
    private String c;

    public zzaec(zzaeb zzaebVar) {
        zzaej zzaejVar;
        IBinder iBinder;
        this.a = zzaebVar;
        try {
            this.c = this.a.a();
        } catch (RemoteException e) {
            zzaza.c("", e);
            this.c = "";
        }
        try {
            for (zzaej zzaejVar2 : zzaebVar.b()) {
                if (!(zzaejVar2 instanceof IBinder) || (iBinder = (IBinder) zzaejVar2) == null) {
                    zzaejVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaejVar = queryLocalInterface instanceof zzaej ? (zzaej) queryLocalInterface : new zzael(iBinder);
                }
                if (zzaejVar != null) {
                    this.b.add(new zzaek(zzaejVar));
                }
            }
        } catch (RemoteException e2) {
            zzaza.c("", e2);
        }
    }
}
