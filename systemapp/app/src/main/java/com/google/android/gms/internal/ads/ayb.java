package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayb implements Parcelable.Creator<zzhp> {
    ayb() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzhp[] newArray(int i) {
        return new zzhp[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzhp createFromParcel(Parcel parcel) {
        return new zzhp(parcel);
    }
}
