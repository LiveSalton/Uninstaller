package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvu implements Parcelable.Creator<zzvr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvr[] newArray(int i) {
        return new zzvr[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvr createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        zzve zzveVar = null;
        Bundle bundle = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    zzveVar = (zzve) SafeParcelReader.a(parcel, a, zzve.CREATOR);
                    break;
                case 4:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzvr(str, j, zzveVar, bundle);
    }
}
