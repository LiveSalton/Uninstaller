package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavd implements Parcelable.Creator<zzava> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzava[] newArray(int i) {
        return new zzava[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzava createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzava(str, i);
    }
}
