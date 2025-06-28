package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzvw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvw> CREATOR = new zzvv();

    @AppOpenAd.AppOpenAdOrientation
    @SafeParcelable.Field
    public final int a;

    @SafeParcelable.Constructor
    public zzvw(@SafeParcelable.Param @AppOpenAd.AppOpenAdOrientation int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a);
        SafeParcelWriter.a(parcel, a);
    }
}
