package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<zzb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb[] newArray(int i) {
        return new zzb[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Intent intent = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    str5 = SafeParcelReader.g(parcel, a);
                    break;
                case 7:
                    str6 = SafeParcelReader.g(parcel, a);
                    break;
                case 8:
                    str7 = SafeParcelReader.g(parcel, a);
                    break;
                case 9:
                    intent = (Intent) SafeParcelReader.a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzb(str, str2, str3, str4, str5, str6, str7, intent);
    }
}
