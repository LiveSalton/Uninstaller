package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();

    @SafeParcelable.Field
    Bundle a;

    @SafeParcelable.Field
    Feature[] b;

    @SafeParcelable.Field
    private int c;

    @SafeParcelable.Constructor
    zzc(@SafeParcelable.Param Bundle bundle, @SafeParcelable.Param Feature[] featureArr, @SafeParcelable.Param int i) {
        this.a = bundle;
        this.b = featureArr;
        this.c = i;
    }

    public zzc() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable[]) this.b, i, false);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, a);
    }
}
