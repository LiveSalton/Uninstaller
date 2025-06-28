package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvd implements Parcelable.Creator<zzve> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzve[] newArray(int i) {
        return new zzve[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzve createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        zzve zzveVar = null;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    zzveVar = (zzve) SafeParcelReader.a(parcel, a, zzve.CREATOR);
                    break;
                case 5:
                    iBinder = SafeParcelReader.h(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzve(i, str, str2, zzveVar, iBinder);
    }
}
