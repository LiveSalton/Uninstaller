package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaiy implements Parcelable.Creator<zzaiz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiz[] newArray(int i) {
        return new zzaiz[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiz createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 3:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzaiz(str, z, i, str2);
    }
}
