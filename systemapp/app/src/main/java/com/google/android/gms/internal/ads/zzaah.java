package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaah implements Parcelable.Creator<zzaae> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaae[] newArray(int i) {
        return new zzaae[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaae createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzaae(i, i2);
    }
}
