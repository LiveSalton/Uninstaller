package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzazh;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzn implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        boolean z = false;
        int i = 0;
        int i2 = 0;
        zzb zzbVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzazh zzazhVar = null;
        String str4 = null;
        zzi zziVar = null;
        IBinder iBinder6 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 2:
                    zzbVar = (zzb) SafeParcelReader.a(parcel, a, zzb.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.h(parcel, a);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.h(parcel, a);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.h(parcel, a);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.h(parcel, a);
                    break;
                case 7:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 9:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.h(parcel, a);
                    break;
                case 11:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 12:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 13:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 14:
                    zzazhVar = (zzazh) SafeParcelReader.a(parcel, a, zzazh.CREATOR);
                    break;
                case 15:
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
                case 16:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 17:
                    zziVar = (zzi) SafeParcelReader.a(parcel, a, zzi.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.h(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new AdOverlayInfoParcel(zzbVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzazhVar, str4, zziVar, iBinder6);
    }
}
