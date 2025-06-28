package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class beh<T> {
    private static final zzxp a = c();

    beh() {
    }

    protected abstract T a();

    protected abstract T a(zzxp zzxpVar) throws RemoteException;

    protected abstract T b() throws RemoteException;

    private static zzxp c() {
        try {
            Object newInstance = zzvx.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzaza.e("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return queryLocalInterface instanceof zzxp ? (zzxp) queryLocalInterface : new zzxr(iBinder);
        } catch (Exception unused) {
            zzaza.e("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T d() {
        if (a == null) {
            zzaza.e("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return a(a);
        } catch (RemoteException e) {
            zzaza.d("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final T e() {
        try {
            return b();
        } catch (RemoteException e) {
            zzaza.d("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public final T a(Context context, boolean z) {
        T d;
        boolean z2 = z;
        if (!z2) {
            zzwq.a();
            if (!zzayr.c(context, GooglePlayServicesUtilLight.a)) {
                zzaza.b("Google Play Services is not available.");
                z2 = true;
            }
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.b(context, ModuleDescriptor.MODULE_ID)) {
            z2 = true;
        }
        zzabf.a(context);
        if (zzacx.a.a().booleanValue()) {
            z2 = false;
        }
        if (z2) {
            d = d();
            if (d == null) {
                d = e();
            }
        } else {
            T e = e();
            int i = e == null ? 1 : 0;
            if (i != 0) {
                if (zzwq.h().nextInt(zzadg.a.a().intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzwq.a().a(context, zzwq.g().a, "gmob-apps", bundle, true);
                }
            }
            d = e == null ? d() : e;
        }
        return d == null ? a() : d;
    }
}
