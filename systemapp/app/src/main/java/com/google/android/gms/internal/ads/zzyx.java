package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyx implements Parcelable.Creator<zzyy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzyy[] newArray(int i) {
        return new zzyy[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzyy createFromParcel(Parcel parcel) {
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
        return new zzyy(i);
    }
}
