package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvf extends RemoteCreator<zzxe> {
    public zzvf() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzwz a(Context context, String str, zzani zzaniVar) {
        try {
            IBinder a = a(context).a(ObjectWrapper.a(context), str, zzaniVar, 203404000);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzwz) {
                return (zzwz) queryLocalInterface;
            }
            return new zzxb(a);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.d("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxe a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzxe) {
            return (zzxe) queryLocalInterface;
        }
        return new zzxd(iBinder);
    }
}
