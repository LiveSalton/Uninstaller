package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzasz implements Parcelable.Creator<zzasw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasw[] newArray(int i) {
        return new zzasw[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasw createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzasw(z, arrayList);
    }
}
