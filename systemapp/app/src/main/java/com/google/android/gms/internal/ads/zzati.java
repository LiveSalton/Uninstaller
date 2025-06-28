package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzati implements Parcelable.Creator<zzatg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatg[] newArray(int i) {
        return new zzatg[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatg createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a) == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.a(parcel, a, ParcelFileDescriptor.CREATOR);
            } else {
                SafeParcelReader.b(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzatg(parcelFileDescriptor);
    }
}
