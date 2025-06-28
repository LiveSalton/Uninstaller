package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdts extends zzc<zzdtv> {
    private final int e;

    public zzdts(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, int i) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
        this.e = i;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String a() {
        return "com.google.android.gms.gass.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String c() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final int u() {
        return this.e;
    }

    public final zzdtv w() throws DeadObjectException {
        return (zzdtv) super.p();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (queryLocalInterface instanceof zzdtv) {
            return (zzdtv) queryLocalInterface;
        }
        return new zzdty(iBinder);
    }
}
