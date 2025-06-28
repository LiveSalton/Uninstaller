package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaan implements Parcelable.Creator<zzaak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaak[] newArray(int i) {
        return new zzaak[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaak createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
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
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzaak(z, z2, z3);
    }
}
