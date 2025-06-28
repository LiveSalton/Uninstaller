package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdue implements Parcelable.Creator<zzdub> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdub[] newArray(int i) {
        return new zzdub[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdub createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzdub(i, i2, i3, str, str2);
    }
}
