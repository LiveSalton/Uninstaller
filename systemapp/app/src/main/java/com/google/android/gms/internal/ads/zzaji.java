package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaji implements Parcelable.Creator<zzajj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajj[] newArray(int i) {
        return new zzajj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajj createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzajj(str, bundle);
    }
}
