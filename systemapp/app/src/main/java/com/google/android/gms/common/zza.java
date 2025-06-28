package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<ConnectionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new ConnectionResult(i, i2, pendingIntent, str);
    }
}
