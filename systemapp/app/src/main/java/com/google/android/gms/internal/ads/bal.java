package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
final class bal implements Parcelable.Creator<zzmn> {
    bal() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmn[] newArray(int i) {
        return new zzmn[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmn createFromParcel(Parcel parcel) {
        return new zzmn(parcel);
    }
}
