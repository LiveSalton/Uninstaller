package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkb {
    public static <T> void a(AtomicReference<T> atomicReference, zzdka<T> zzdkaVar) {
        T t = atomicReference.get();
        if (t == null) {
            return;
        }
        try {
            zzdkaVar.a(t);
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }
}
