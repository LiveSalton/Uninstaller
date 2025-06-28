package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaaj implements Parcelable.Creator<zzaag> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaag[] newArray(int i) {
        return new zzaag[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaag createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a) == 15) {
                str = SafeParcelReader.g(parcel, a);
            } else {
                SafeParcelReader.b(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzaag(str);
    }
}
