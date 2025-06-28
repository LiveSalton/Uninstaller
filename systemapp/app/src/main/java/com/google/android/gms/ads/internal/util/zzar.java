package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzar implements Parcelable.Creator<zzap> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzap[] newArray(int i) {
        return new zzap[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzap createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzap(str, i);
    }
}
