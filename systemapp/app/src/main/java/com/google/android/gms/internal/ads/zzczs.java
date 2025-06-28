package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczs implements zzdyb<zzatl, zzczx> {
    private Executor a;
    private zzcmx b;

    public zzczs(Executor executor, zzcmx zzcmxVar) {
        this.a = executor;
        this.b = zzcmxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final /* synthetic */ zzdyz<zzczx> a(zzatl zzatlVar) throws Exception {
        zzatl zzatlVar2 = zzatlVar;
        return zzdyr.a(this.b.a(zzatlVar2), new zzdyb(zzatlVar2) { // from class: com.google.android.gms.internal.ads.acc
            private final zzatl a;

            {
                this.a = zzatlVar2;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return zzdyr.a(new zzczx(new JsonReader(new InputStreamReader((InputStream) obj))).a(this.a.a));
            }
        }, this.a);
    }
}
