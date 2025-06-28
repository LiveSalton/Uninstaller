package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztd implements Parcelable.Creator<zzta> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzta[] newArray(int i) {
        return new zzta[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzta createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        ParcelFileDescriptor parcelFileDescriptor = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 6:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzta(parcelFileDescriptor, z, z2, j, z3);
    }
}
