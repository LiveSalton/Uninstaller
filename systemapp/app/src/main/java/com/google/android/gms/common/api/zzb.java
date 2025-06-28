package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            int a2 = SafeParcelReader.a(a);
            if (a2 != 1000) {
                switch (a2) {
                    case 1:
                        i2 = SafeParcelReader.d(parcel, a);
                        break;
                    case 2:
                        str = SafeParcelReader.g(parcel, a);
                        break;
                    case 3:
                        pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, a, PendingIntent.CREATOR);
                        break;
                    default:
                        SafeParcelReader.b(parcel, a);
                        break;
                }
            } else {
                i = SafeParcelReader.d(parcel, a);
            }
        }
        SafeParcelReader.n(parcel, b);
        return new Status(i, i2, str, pendingIntent);
    }
}
