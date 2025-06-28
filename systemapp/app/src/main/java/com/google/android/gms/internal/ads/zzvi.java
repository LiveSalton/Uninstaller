package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvi extends RemoteCreator<zzxh> {
    @VisibleForTesting
    public zzvi() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzxg a(Context context, zzvn zzvnVar, String str, zzani zzaniVar, int i) {
        try {
            IBinder a = a(context).a(ObjectWrapper.a(context), zzvnVar, str, zzaniVar, 203404000, i);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxg) {
                return (zzxg) queryLocalInterface;
            }
            return new zzxi(a);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.b("Could not create remote AdManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzxh) {
            return (zzxh) queryLocalInterface;
        }
        return new zzxk(iBinder);
    }
}
