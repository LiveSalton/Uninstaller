package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaik implements Parcelable.Creator<zzail> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzail[] newArray(int i) {
        return new zzail[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzail createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String[] strArr = null;
        String[] strArr2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    strArr = SafeParcelReader.k(parcel, a);
                    break;
                case 3:
                    strArr2 = SafeParcelReader.k(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzail(str, strArr, strArr2);
    }
}
