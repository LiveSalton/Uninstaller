package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class fa implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzazq b;

    fa(zzaya zzayaVar, Context context, zzazq zzazqVar) {
        this.a = context;
        this.b = zzazqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.b(AdvertisingIdClient.getAdvertisingIdInfo(this.a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.b.a(e);
            zzaza.c("Exception while getting advertising Id info", e);
        }
    }
}
