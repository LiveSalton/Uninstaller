package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzjo;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayw implements Parcelable.Creator<zzjo.zza> {
    ayw() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjo.zza[] newArray(int i) {
        return new zzjo.zza[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjo.zza createFromParcel(Parcel parcel) {
        return new zzjo.zza(parcel);
    }
}
