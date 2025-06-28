package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzajl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajl> CREATOR = new zzajk();

    @SafeParcelable.VersionField
    public final int a;

    @SafeParcelable.Field
    public final int b;

    @SafeParcelable.Field
    public final String c;

    @SafeParcelable.Field
    public final int d;

    @SafeParcelable.Constructor
    public zzajl(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param String str, @SafeParcelable.Param int i3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.b);
        SafeParcelWriter.a(parcel, 2, this.c, false);
        SafeParcelWriter.a(parcel, 3, this.d);
        SafeParcelWriter.a(parcel, 1000, this.a);
        SafeParcelWriter.a(parcel, a);
    }
}
