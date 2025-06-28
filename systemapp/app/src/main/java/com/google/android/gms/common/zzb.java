package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 3:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new Feature(str, i, j);
    }
}
