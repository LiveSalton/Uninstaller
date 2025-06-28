package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvv implements Parcelable.Creator<zzvw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvw[] newArray(int i) {
        return new zzvw[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvw createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a) == 2) {
                i = SafeParcelReader.d(parcel, a);
            } else {
                SafeParcelReader.b(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzvw(i);
    }
}
