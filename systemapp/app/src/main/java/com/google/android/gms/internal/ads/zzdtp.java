package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdtp implements Parcelable.Creator<zzdtq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdtq[] newArray(int i) {
        return new zzdtq[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdtq createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    bArr = SafeParcelReader.j(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzdtq(i, bArr);
    }
}
