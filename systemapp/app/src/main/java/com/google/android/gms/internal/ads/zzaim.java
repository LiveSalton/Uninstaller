package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaim implements Parcelable.Creator<zzain> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzain[] newArray(int i) {
        return new zzain[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzain createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    bArr = SafeParcelReader.j(parcel, a);
                    break;
                case 5:
                    strArr = SafeParcelReader.k(parcel, a);
                    break;
                case 6:
                    strArr2 = SafeParcelReader.k(parcel, a);
                    break;
                case 7:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 8:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzain(z, str, i, bArr, strArr, strArr2, z2, j);
    }
}
