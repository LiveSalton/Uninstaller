package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzasx implements Parcelable.Creator<zzasu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasu[] newArray(int i) {
        return new zzasu[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasu createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i4 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        zzatg zzatgVar = null;
        String str7 = null;
        String str8 = null;
        zzava zzavaVar = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        zzasw zzaswVar = null;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        String str10 = null;
        zzawp zzawpVar = null;
        String str11 = null;
        Bundle bundle = null;
        ArrayList<String> arrayList7 = null;
        String str12 = null;
        String str13 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 4:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                case 5:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.m(parcel, a);
                    break;
                case 7:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    j2 = SafeParcelReader.e(parcel, a);
                    break;
                case 10:
                    arrayList3 = SafeParcelReader.m(parcel, a);
                    break;
                case 11:
                    j3 = SafeParcelReader.e(parcel, a);
                    break;
                case 12:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 13:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 14:
                    j4 = SafeParcelReader.e(parcel, a);
                    break;
                case 15:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
                case 18:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 19:
                    str5 = SafeParcelReader.g(parcel, a);
                    break;
                case 21:
                    str6 = SafeParcelReader.g(parcel, a);
                    break;
                case 22:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 23:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 24:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                case 25:
                    z6 = SafeParcelReader.c(parcel, a);
                    break;
                case 26:
                    z7 = SafeParcelReader.c(parcel, a);
                    break;
                case 28:
                    zzatgVar = (zzatg) SafeParcelReader.a(parcel, a, zzatg.CREATOR);
                    break;
                case 29:
                    str7 = SafeParcelReader.g(parcel, a);
                    break;
                case 30:
                    str8 = SafeParcelReader.g(parcel, a);
                    break;
                case 31:
                    z8 = SafeParcelReader.c(parcel, a);
                    break;
                case 32:
                    z9 = SafeParcelReader.c(parcel, a);
                    break;
                case 33:
                    zzavaVar = (zzava) SafeParcelReader.a(parcel, a, zzava.CREATOR);
                    break;
                case 34:
                    arrayList4 = SafeParcelReader.m(parcel, a);
                    break;
                case 35:
                    arrayList5 = SafeParcelReader.m(parcel, a);
                    break;
                case 36:
                    z10 = SafeParcelReader.c(parcel, a);
                    break;
                case 37:
                    zzaswVar = (zzasw) SafeParcelReader.a(parcel, a, zzasw.CREATOR);
                    break;
                case 38:
                    z11 = SafeParcelReader.c(parcel, a);
                    break;
                case 39:
                    str9 = SafeParcelReader.g(parcel, a);
                    break;
                case 40:
                    arrayList6 = SafeParcelReader.m(parcel, a);
                    break;
                case 42:
                    z12 = SafeParcelReader.c(parcel, a);
                    break;
                case 43:
                    str10 = SafeParcelReader.g(parcel, a);
                    break;
                case 44:
                    zzawpVar = (zzawp) SafeParcelReader.a(parcel, a, zzawp.CREATOR);
                    break;
                case 45:
                    str11 = SafeParcelReader.g(parcel, a);
                    break;
                case 46:
                    z13 = SafeParcelReader.c(parcel, a);
                    break;
                case 47:
                    z14 = SafeParcelReader.c(parcel, a);
                    break;
                case 48:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 49:
                    z15 = SafeParcelReader.c(parcel, a);
                    break;
                case 50:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
                case 51:
                    z16 = SafeParcelReader.c(parcel, a);
                    break;
                case 52:
                    arrayList7 = SafeParcelReader.m(parcel, a);
                    break;
                case 53:
                    z17 = SafeParcelReader.c(parcel, a);
                    break;
                case 54:
                    str12 = SafeParcelReader.g(parcel, a);
                    break;
                case 55:
                    str13 = SafeParcelReader.g(parcel, a);
                    break;
                case 56:
                    z18 = SafeParcelReader.c(parcel, a);
                    break;
                case 57:
                    z19 = SafeParcelReader.c(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzasu(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzatgVar, str7, str8, z8, z9, zzavaVar, arrayList4, arrayList5, z10, zzaswVar, z11, str9, arrayList6, z12, str10, zzawpVar, str11, z13, z14, bundle, z15, i4, z16, arrayList7, z17, str12, str13, z18, z19);
    }
}
