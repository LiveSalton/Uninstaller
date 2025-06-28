package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdpo implements Parcelable.Creator<zzdpk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdpk[] newArray(int i) {
        return new zzdpk[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdpk createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 3:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
                case 5:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    i5 = SafeParcelReader.d(parcel, a);
                    break;
                case 7:
                    i6 = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzdpk(i, i2, i3, i4, str, i5, i6);
    }
}
