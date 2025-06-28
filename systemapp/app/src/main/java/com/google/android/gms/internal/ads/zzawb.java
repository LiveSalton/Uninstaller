package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzawb implements Parcelable.Creator<zzavy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavy[] newArray(int i) {
        return new zzavy[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavy createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzavy(str, str2);
    }
}
