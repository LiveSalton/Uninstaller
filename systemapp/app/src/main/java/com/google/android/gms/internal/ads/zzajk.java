package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzajk implements Parcelable.Creator<zzajl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajl[] newArray(int i) {
        return new zzajl[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajl createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            int a2 = SafeParcelReader.a(a);
            if (a2 != 1000) {
                switch (a2) {
                    case 1:
                        i3 = SafeParcelReader.d(parcel, a);
                        break;
                    case 2:
                        str = SafeParcelReader.g(parcel, a);
                        break;
                    case 3:
                        i2 = SafeParcelReader.d(parcel, a);
                        break;
                    default:
                        SafeParcelReader.b(parcel, a);
                        break;
                }
            } else {
                i = SafeParcelReader.d(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzajl(i, i3, str, i2);
    }
}
