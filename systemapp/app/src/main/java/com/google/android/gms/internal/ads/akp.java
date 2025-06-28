package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
final class akp implements akr {
    private static final zzcf.zza a = zzcf.zza.i();

    akp() {
    }

    @Override // com.google.android.gms.internal.ads.akr
    public final zzcf.zza a(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzcf.zza.C0060zza h = zzcf.zza.h();
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context);
        advertisingIdClient.start();
        AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
        String id = info.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            h.i(id);
            h.a(info.isLimitAdTrackingEnabled());
            h.a(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
        }
        return (zzcf.zza) ((zzekh) h.g());
    }

    @Override // com.google.android.gms.internal.ads.akr
    public final zzcf.zza a() {
        return a;
    }
}
