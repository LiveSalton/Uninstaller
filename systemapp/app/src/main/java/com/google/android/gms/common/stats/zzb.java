package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        float f = 0.0f;
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
                case 7:
                case 9:
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 6:
                    arrayList = SafeParcelReader.m(parcel, a);
                    break;
                case 8:
                    j2 = SafeParcelReader.e(parcel, a);
                    break;
                case 10:
                    str3 = SafeParcelReader.g(parcel, a);
                    break;
                case 11:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 12:
                    str2 = SafeParcelReader.g(parcel, a);
                    break;
                case 13:
                    str4 = SafeParcelReader.g(parcel, a);
                    break;
                case 14:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
                case 15:
                    f = SafeParcelReader.f(parcel, a);
                    break;
                case 16:
                    j3 = SafeParcelReader.e(parcel, a);
                    break;
                case 17:
                    str5 = SafeParcelReader.g(parcel, a);
                    break;
                case 18:
                    z = SafeParcelReader.c(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5, z);
    }
}
