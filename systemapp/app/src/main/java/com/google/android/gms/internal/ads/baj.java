package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
final class baj implements Parcelable.Creator<zzmh> {
    baj() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmh[] newArray(int i) {
        return new zzmh[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmh createFromParcel(Parcel parcel) {
        return new zzmh(parcel);
    }
}
