package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzu implements Parcelable.Creator<zzv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv[] newArray(int i) {
        return new zzv[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a) == 1) {
                i = SafeParcelReader.d(parcel, a);
            } else {
                SafeParcelReader.b(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzv(i);
    }
}
