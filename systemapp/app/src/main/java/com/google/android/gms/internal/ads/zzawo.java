package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzawo implements Parcelable.Creator<zzawp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawp[] newArray(int i) {
        return new zzawp[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawp createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 5:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 6:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                case 7:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 8:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.m(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzawp(str, str2, z, z2, arrayList, z3, z4, arrayList2);
    }
}
