package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvm implements Parcelable.Creator<zzvk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvk[] newArray(int i) {
        return new zzvk[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvk createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        int i5 = 0;
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzaag zzaagVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzvc zzvcVar = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 3:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 5:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                case 6:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 7:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 8:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    zzaagVar = (zzaag) SafeParcelReader.a(parcel, a, zzaag.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.a(parcel, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.i(parcel, a);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.i(parcel, a);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.m(parcel, a);
                    break;
                case 16:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 17:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 18:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 19:
                    zzvcVar = (zzvc) SafeParcelReader.a(parcel, a, zzvc.CREATOR);
                    break;
                case 20:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
                case 21:
                    str5 = SafeParcelReader.g(parcel, a);
                    break;
                case 22:
                    arrayList3 = SafeParcelReader.m(parcel, a);
                    break;
                case 23:
                    i5 = SafeParcelReader.d(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzvk(i, j, bundle, i2, arrayList, z, i3, z2, str, zzaagVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3, zzvcVar, i4, str5, arrayList3, i5);
    }
}
