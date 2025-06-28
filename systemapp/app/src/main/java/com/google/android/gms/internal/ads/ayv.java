package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayv implements Parcelable.Creator<zzjo> {
    ayv() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjo[] newArray(int i) {
        return new zzjo[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjo createFromParcel(Parcel parcel) {
        return new zzjo(parcel);
    }
}
