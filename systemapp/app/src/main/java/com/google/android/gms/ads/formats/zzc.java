package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<PublisherAdViewOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PublisherAdViewOptions[] newArray(int i) {
        return new PublisherAdViewOptions[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PublisherAdViewOptions createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        boolean z = false;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 2:
                    iBinder = SafeParcelReader.h(parcel, a);
                    break;
                case 3:
                    iBinder2 = SafeParcelReader.h(parcel, a);
                    break;
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new PublisherAdViewOptions(z, iBinder, iBinder2);
    }
}
