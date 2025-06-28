package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfu extends zzgl {
    public zzfu(zzfa zzfaVar, String str, String str2, zzcf.zza.C0060zza c0060zza, int i, int i2) {
        super(zzfaVar, str, str2, c0060zza, i, 24);
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    /* renamed from: b */
    public final Void call() throws Exception {
        if (this.a.b()) {
            return super.call();
        }
        if (!this.a.g()) {
            return null;
        }
        c();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgl
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.a.g()) {
            c();
            return;
        }
        synchronized (this.b) {
            this.b.i((String) this.c.invoke(null, this.a.a()));
        }
    }

    private final void c() {
        AdvertisingIdClient n = this.a.n();
        if (n == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = n.getInfo();
            String a = zzff.a(info.getId());
            if (a != null) {
                synchronized (this.b) {
                    this.b.i(a);
                    this.b.a(info.isLimitAdTrackingEnabled());
                    this.b.a(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgl, java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return call();
    }
}
