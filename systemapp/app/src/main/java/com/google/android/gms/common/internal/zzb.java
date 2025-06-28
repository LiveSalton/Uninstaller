package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        int i = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 2:
                    featureArr = (Feature[]) SafeParcelReader.b(parcel, a, Feature.CREATOR);
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
        return new zzc(bundle, featureArr, i);
    }
}
