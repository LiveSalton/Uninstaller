package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
final class bai implements Parcelable.Creator<zzmd> {
    bai() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmd[] newArray(int i) {
        return new zzmd[0];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmd createFromParcel(Parcel parcel) {
        return new zzmd(parcel);
    }
}
