package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
final class bak implements Parcelable.Creator<zzmj> {
    bak() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmj[] newArray(int i) {
        return new zzmj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmj createFromParcel(Parcel parcel) {
        return new zzmj(parcel);
    }
}
