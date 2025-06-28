package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaxz implements Parcelable.Creator<zzaxw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaxw[] newArray(int i) {
        return new zzaxw[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaxw createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        zzvn zzvnVar = null;
        zzvk zzvkVar = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 2:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    zzvnVar = (zzvn) SafeParcelReader.a(parcel, a, zzvn.CREATOR);
                    break;
                case 4:
                    zzvkVar = (zzvk) SafeParcelReader.a(parcel, a, zzvk.CREATOR);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzaxw(str, str2, zzvnVar, zzvkVar);
    }
}
