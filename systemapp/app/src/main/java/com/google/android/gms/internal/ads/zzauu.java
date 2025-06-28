package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzauu implements Parcelable.Creator<zzauv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzauv[] newArray(int i) {
        return new zzauv[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzauv createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        zzvk zzvkVar = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    zzvkVar = (zzvk) SafeParcelReader.a(parcel, a, zzvk.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzauv(zzvkVar, str);
    }
}
