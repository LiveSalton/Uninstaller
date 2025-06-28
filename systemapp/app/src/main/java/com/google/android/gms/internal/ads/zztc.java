package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztc extends zzc<zztg> {
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String c() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    zztc(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzauc.b(context), looper, 123, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] l() {
        return com.google.android.gms.ads.zzc.b;
    }

    public final zztg w() throws DeadObjectException {
        return (zztg) super.p();
    }

    public final boolean x() {
        return ((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() && ArrayUtils.a(e(), com.google.android.gms.ads.zzc.a);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        if (queryLocalInterface instanceof zztg) {
            return (zztg) queryLocalInterface;
        }
        return new zztj(iBinder);
    }
}
