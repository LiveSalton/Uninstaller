package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaii extends zzc<zzair> {
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String c() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    zzaii(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzauc.b(context), looper, 166, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public final zzair w() throws DeadObjectException {
        return (zzair) super.p();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        if (queryLocalInterface instanceof zzair) {
            return (zzair) queryLocalInterface;
        }
        return new zzaiq(iBinder);
    }
}
