package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzdoi;
import com.google.android.gms.internal.ads.zzdwc;
import com.google.android.gms.internal.ads.zzve;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzar();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final int b;

    public static zzap a(Throwable th) {
        zzve a = zzdoi.a(th);
        return new zzap(zzdwc.c(th.getMessage()) ? a.b : th.getMessage(), a.a);
    }

    @SafeParcelable.Constructor
    zzap(@SafeParcelable.Param String str, @SafeParcelable.Param int i) {
        this.a = str == null ? "" : str;
        this.b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, a);
    }
}
