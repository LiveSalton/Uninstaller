package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzte implements Parcelable.Creator<zztf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zztf[] newArray(int i) {
        return new zztf[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zztf createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        int i = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Bundle bundle = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 4:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 7:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    j2 = SafeParcelReader.e(parcel, a);
                    break;
                case 10:
                    str5 = SafeParcelReader.g(parcel, a);
                    break;
                case 11:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zztf(str, j, str2, str3, str4, bundle, z, j2, str5, i);
    }
}
