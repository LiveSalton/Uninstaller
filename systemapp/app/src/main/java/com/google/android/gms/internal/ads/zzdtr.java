package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzdtr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtr> CREATOR = new zzdtu();

    @SafeParcelable.VersionField
    private final int a;

    @SafeParcelable.Field
    private final String b;

    @SafeParcelable.Field
    private final String c;

    @SafeParcelable.Constructor
    zzdtr(@SafeParcelable.Param int i, @SafeParcelable.Param String str, @SafeParcelable.Param String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public zzdtr(String str, String str2) {
        this(1, str, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, a);
    }
}
