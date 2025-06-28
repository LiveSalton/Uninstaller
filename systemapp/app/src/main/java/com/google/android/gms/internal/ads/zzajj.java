package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzajj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajj> CREATOR = new zzaji();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final Bundle b;

    @SafeParcelable.Constructor
    public zzajj(@SafeParcelable.Param String str, @SafeParcelable.Param Bundle bundle) {
        this.a = str;
        this.b = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, a);
    }
}
