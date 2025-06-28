package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzady implements Parcelable.Creator<zzadz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadz[] newArray(int i) {
        return new zzadz[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzadz createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        int i4 = 0;
        zzaak zzaakVar = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 6:
                    zzaakVar = (zzaak) SafeParcelReader.a(parcel, a, zzaak.CREATOR);
                    break;
                case 7:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 8:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzadz(i, z, i2, z2, i3, zzaakVar, z3, i4);
    }
}
