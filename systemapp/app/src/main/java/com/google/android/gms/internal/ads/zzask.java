package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzask implements Parcelable.Creator<zzasl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasl[] newArray(int i) {
        return new zzasl[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasl createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    iBinder = SafeParcelReader.h(parcel, a);
                    break;
                case 2:
                    iBinder2 = SafeParcelReader.h(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzasl(iBinder, iBinder2);
    }
}
