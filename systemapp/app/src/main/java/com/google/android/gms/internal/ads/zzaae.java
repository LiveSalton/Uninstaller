package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzaae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaae> CREATOR = new zzaah();

    @SafeParcelable.Field
    private final int a;

    @SafeParcelable.Field
    private final int b;

    @SafeParcelable.Constructor
    public zzaae(@SafeParcelable.Param int i, @SafeParcelable.Param int i2) {
        this.a = i;
        this.b = i2;
    }

    public zzaae(RequestConfiguration requestConfiguration) {
        this.a = requestConfiguration.a();
        this.b = requestConfiguration.b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, a);
    }
}
