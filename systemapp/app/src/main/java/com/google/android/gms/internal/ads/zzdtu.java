package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdtu implements Parcelable.Creator<zzdtr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdtr[] newArray(int i) {
        return new zzdtr[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdtr createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzdtr(i, str, str2);
    }
}
