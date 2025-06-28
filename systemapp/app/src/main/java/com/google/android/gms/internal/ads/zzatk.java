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
public final class zzatk implements Parcelable.Creator<zzatl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatl[] newArray(int i) {
        return new zzatl[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatl createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        zzazh zzazhVar = null;
        ApplicationInfo applicationInfo = null;
        String str = null;
        ArrayList<String> arrayList = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        zzdpk zzdpkVar = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 2:
                    zzazhVar = (zzazh) SafeParcelReader.a(parcel, a, zzazh.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    zzdpkVar = (zzdpk) SafeParcelReader.a(parcel, a, zzdpk.CREATOR);
                    break;
                case 11:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new zzatl(bundle, zzazhVar, applicationInfo, str, arrayList, packageInfo, str2, z, str3, zzdpkVar, str4);
    }
}
