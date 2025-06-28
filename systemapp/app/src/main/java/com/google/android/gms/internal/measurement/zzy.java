package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzy implements Parcelable.Creator<zzv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv[] newArray(int i) {
        return new zzv[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 2:
                    j2 = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 7:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzv(j, j2, z, str, str2, str3, bundle);
    }
}
