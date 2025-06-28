package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztx {

    @VisibleForTesting
    zzgy a;

    @VisibleForTesting
    boolean b;

    public final zzub a(byte[] bArr) {
        return new zzub(this, bArr);
    }

    public zztx(Context context, String str, String str2) {
        zzabf.a(context);
        try {
            this.a = (zzgy) zzazd.a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", bcy.a);
            ObjectWrapper.a(context);
            this.a.a(ObjectWrapper.a(context), str, null);
            this.b = true;
        } catch (RemoteException | zzazf | NullPointerException unused) {
            zzaza.b("Cannot dynamite load clearcut");
        }
    }

    public zztx(Context context) {
        zzabf.a(context);
        if (((Boolean) zzwq.e().a(zzabf.ct)).booleanValue()) {
            try {
                this.a = (zzgy) zzazd.a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", bcx.a);
                ObjectWrapper.a(context);
                this.a.a(ObjectWrapper.a(context), "GMA_SDK");
                this.b = true;
            } catch (RemoteException | zzazf | NullPointerException unused) {
                zzaza.b("Cannot dynamite load clearcut");
            }
        }
    }

    public zztx() {
    }
}
