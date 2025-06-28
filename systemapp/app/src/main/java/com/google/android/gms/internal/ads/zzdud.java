package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzdud extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdud> CREATOR = new zzdug();

    @SafeParcelable.Field
    public final byte[] a;

    @SafeParcelable.Field
    public final int b;

    @SafeParcelable.VersionField
    private final int c;

    @SafeParcelable.Constructor
    zzdud(@SafeParcelable.Param int i, @SafeParcelable.Param byte[] bArr, @SafeParcelable.Param int i2) {
        this.c = i;
        this.a = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.b = i2;
    }

    public zzdud(byte[] bArr, int i) {
        this(1, null, 1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.c);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, 3, this.b);
        SafeParcelWriter.a(parcel, a);
    }
}
