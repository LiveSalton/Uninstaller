package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzazg implements Parcelable.Creator<zzazh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazh[] newArray(int i) {
        return new zzazh[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazh createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 5:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzazh(str, i, i2, z, z2);
    }
}
