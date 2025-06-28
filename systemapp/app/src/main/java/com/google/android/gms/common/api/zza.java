package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new Scope(i, str);
    }
}
