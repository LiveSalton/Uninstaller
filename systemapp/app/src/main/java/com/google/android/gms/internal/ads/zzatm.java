package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzatm implements Parcelable.Creator<zzatn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatn[] newArray(int i) {
        return new zzatn[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatn createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a) == 2) {
                str = SafeParcelReader.g(parcel, a);
            } else {
                SafeParcelReader.b(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzatn(str);
    }
}
