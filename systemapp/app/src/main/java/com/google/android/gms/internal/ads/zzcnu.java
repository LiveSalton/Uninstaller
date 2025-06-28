package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzcnu implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzazq<InputStream> a = new zzazq<>();
    protected final Object b = new Object();
    protected boolean c = false;
    protected boolean d = false;
    protected zzatl e;
    protected zzast f;

    protected final void a() {
        synchronized (this.b) {
            this.d = true;
            if (this.f.g() || this.f.h()) {
                this.f.i();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void a(int i) {
        zzd.b("Cannot connect to remote service, fallback to local instance.");
    }

    public void a(ConnectionResult connectionResult) {
        zzd.b("Disconnected from remote ad request service.");
        this.a.a(new zzcoh(zzdok.INTERNAL_ERROR));
    }
}
