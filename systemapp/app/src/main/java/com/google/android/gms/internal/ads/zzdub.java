package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzdub extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdub> CREATOR = new zzdue();

    @SafeParcelable.VersionField
    private final int a;

    @SafeParcelable.Field
    private final int b;

    @SafeParcelable.Field
    private final String c;

    @SafeParcelable.Field
    private final String d;

    @SafeParcelable.Field
    private final int e;

    @SafeParcelable.Constructor
    zzdub(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param int i3, @SafeParcelable.Param String str, @SafeParcelable.Param String str2) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = i3;
    }

    public zzdub(int i, zzgn zzgnVar, String str, String str2) {
        this(1, i, zzgnVar.a(), str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, 5, this.e);
        SafeParcelWriter.a(parcel, a);
    }
}
