package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: source */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApiAvailabilityLight {

    @KeepForSdk
    public static final int a = GooglePlayServicesUtilLight.a;
    private static final GoogleApiAvailabilityLight b = new GoogleApiAvailabilityLight();

    @KeepForSdk
    public static GoogleApiAvailabilityLight a() {
        return b;
    }

    @KeepForSdk
    GoogleApiAvailabilityLight() {
    }

    @HideFirstParty
    @KeepForSdk
    public int a(Context context) {
        return a(context, a);
    }

    @KeepForSdk
    public int a(Context context, int i) {
        int a2 = GooglePlayServicesUtilLight.a(context, i);
        if (GooglePlayServicesUtilLight.b(context, a2)) {
            return 18;
        }
        return a2;
    }

    @ShowFirstParty
    @KeepForSdk
    public int b(Context context) {
        return GooglePlayServicesUtilLight.b(context);
    }
}
