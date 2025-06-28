package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzdtq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtq> CREATOR = new zzdtp();

    @SafeParcelable.VersionField
    private final int a;

    @SafeParcelable.Field
    private final byte[] b;

    @SafeParcelable.Constructor
    zzdtq(@SafeParcelable.Param int i, @SafeParcelable.Param byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public zzdtq(byte[] bArr) {
        this(1, bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, a);
    }
}
