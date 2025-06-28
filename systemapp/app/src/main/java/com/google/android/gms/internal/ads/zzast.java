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
public final class zzast extends zzc<zzasy> {
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String a() {
        return "com.google.android.gms.ads.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final String c() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public zzast(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzauc.b(context), looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public final zzasy w() throws DeadObjectException {
        return (zzasy) super.p();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @VisibleForTesting
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface instanceof zzasy) {
            return (zzasy) queryLocalInterface;
        }
        return new zzata(iBinder);
    }
}
