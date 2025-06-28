package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdch implements zzdfj<Bundle> {

    @Nullable
    private final Location a;

    public zzdch(@Nullable Location location) {
        this.a = location;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.a != null) {
            Bundle bundle3 = new Bundle();
            float accuracy = this.a.getAccuracy() * 1000.0f;
            long time = this.a.getTime() * 1000;
            long latitude = (long) (this.a.getLatitude() * 1.0E7d);
            long longitude = (long) (this.a.getLongitude() * 1.0E7d);
            bundle3.putFloat("radius", accuracy);
            bundle3.putLong("lat", latitude);
            bundle3.putLong("long", longitude);
            bundle3.putLong("time", time);
            bundle2.putBundle("uule", bundle3);
        }
    }
}
