package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzh implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    f = SafeParcelReader.f(parcel, a);
                    break;
                case 7:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 8:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                case 10:
                    z6 = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzi(z, z2, str, z3, f, i, z4, z5, z6);
    }
}
