package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzasv implements Parcelable.Creator<zzass> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzass[] newArray(int i) {
        return new zzass[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzass createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        Bundle bundle = null;
        zzvk zzvkVar = null;
        zzvn zzvnVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzazh zzazhVar = null;
        Bundle bundle2 = null;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzadz zzadzVar = null;
        ArrayList<String> arrayList3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzyy zzyyVar = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        ArrayList<String> arrayList6 = null;
        String str16 = null;
        zzajl zzajlVar = null;
        String str17 = null;
        Bundle bundle6 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 3:
                    zzvkVar = (zzvk) SafeParcelReader.a(parcel, a, zzvk.CREATOR);
                    break;
                case 4:
                    zzvnVar = (zzvn) SafeParcelReader.a(parcel, a, zzvn.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 9:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 11:
                    zzazhVar = (zzazh) SafeParcelReader.a(parcel, a, zzazh.CREATOR);
                    break;
                case 12:
                    bundle2 = SafeParcelReader.i(parcel, a);
                    break;
                case 13:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 14:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                case 15:
                    bundle3 = SafeParcelReader.i(parcel, a);
                    break;
                case 16:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 62:
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
                case 18:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 19:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
                case 20:
                    f = SafeParcelReader.f(parcel, a);
                    break;
                case 21:
                    str5 = SafeParcelReader.g(parcel, a);
                    break;
                case 25:
                    j = SafeParcelReader.e(parcel, a);
                    break;
                case 26:
                    str6 = SafeParcelReader.g(parcel, a);
                    break;
                case 27:
                    arrayList2 = SafeParcelReader.m(parcel, a);
                    break;
                case 28:
                    str7 = SafeParcelReader.g(parcel, a);
                    break;
                case 29:
                    zzadzVar = (zzadz) SafeParcelReader.a(parcel, a, zzadz.CREATOR);
                    break;
                case 30:
                    arrayList3 = SafeParcelReader.m(parcel, a);
                    break;
                case 31:
                    j2 = SafeParcelReader.e(parcel, a);
                    break;
                case 33:
                    str8 = SafeParcelReader.g(parcel, a);
                    break;
                case 34:
                    f2 = SafeParcelReader.f(parcel, a);
                    break;
                case 35:
                    i5 = SafeParcelReader.d(parcel, a);
                    break;
                case 36:
                    i6 = SafeParcelReader.d(parcel, a);
                    break;
                case 37:
                    z3 = SafeParcelReader.c(parcel, a);
                    break;
                case 38:
                    z4 = SafeParcelReader.c(parcel, a);
                    break;
                case 39:
                    str9 = SafeParcelReader.g(parcel, a);
                    break;
                case 40:
                    z2 = SafeParcelReader.c(parcel, a);
                    break;
                case 41:
                    str10 = SafeParcelReader.g(parcel, a);
                    break;
                case 42:
                    z5 = SafeParcelReader.c(parcel, a);
                    break;
                case 43:
                    i7 = SafeParcelReader.d(parcel, a);
                    break;
                case 44:
                    bundle4 = SafeParcelReader.i(parcel, a);
                    break;
                case 45:
                    str11 = SafeParcelReader.g(parcel, a);
                    break;
                case 46:
                    zzyyVar = (zzyy) SafeParcelReader.a(parcel, a, zzyy.CREATOR);
                    break;
                case 47:
                    z6 = SafeParcelReader.c(parcel, a);
                    break;
                case 48:
                    bundle5 = SafeParcelReader.i(parcel, a);
                    break;
                case 49:
                    str12 = SafeParcelReader.g(parcel, a);
                    break;
                case 50:
                    str13 = SafeParcelReader.g(parcel, a);
                    break;
                case 51:
                    str14 = SafeParcelReader.g(parcel, a);
                    break;
                case 52:
                    z7 = SafeParcelReader.c(parcel, a);
                    break;
                case 53:
                    arrayList4 = SafeParcelReader.l(parcel, a);
                    break;
                case 54:
                    str15 = SafeParcelReader.g(parcel, a);
                    break;
                case 55:
                    arrayList5 = SafeParcelReader.m(parcel, a);
                    break;
                case 56:
                    i8 = SafeParcelReader.d(parcel, a);
                    break;
                case 57:
                    z8 = SafeParcelReader.c(parcel, a);
                    break;
                case 58:
                    z9 = SafeParcelReader.c(parcel, a);
                    break;
                case 59:
                    z10 = SafeParcelReader.c(parcel, a);
                    break;
                case 60:
                    arrayList6 = SafeParcelReader.m(parcel, a);
                    break;
                case 61:
                    str16 = SafeParcelReader.g(parcel, a);
                    break;
                case 63:
                    zzajlVar = (zzajl) SafeParcelReader.a(parcel, a, zzajl.CREATOR);
                    break;
                case 64:
                    str17 = SafeParcelReader.g(parcel, a);
                    break;
                case 65:
                    bundle6 = SafeParcelReader.i(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzass(i, bundle, zzvkVar, zzvnVar, str, applicationInfo, packageInfo, str2, str3, str4, zzazhVar, bundle2, i2, arrayList, bundle3, z, i3, i4, f, str5, j, str6, arrayList2, str7, zzadzVar, arrayList3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, zzyyVar, z6, bundle5, str12, str13, str14, z7, arrayList4, str15, arrayList5, i8, z8, z9, z10, arrayList6, str16, zzajlVar, str17, bundle6);
    }
}
