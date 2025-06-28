package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzain extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzain> CREATOR = new zzaim();

    @SafeParcelable.Field
    public final boolean a;

    @SafeParcelable.Field
    public final String b;

    @SafeParcelable.Field
    public final int c;

    @SafeParcelable.Field
    public final byte[] d;

    @SafeParcelable.Field
    public final String[] e;

    @SafeParcelable.Field
    public final String[] f;

    @SafeParcelable.Field
    public final boolean g;

    @SafeParcelable.Field
    public final long h;

    @SafeParcelable.Constructor
    zzain(@SafeParcelable.Param boolean z, @SafeParcelable.Param String str, @SafeParcelable.Param int i, @SafeParcelable.Param byte[] bArr, @SafeParcelable.Param String[] strArr, @SafeParcelable.Param String[] strArr2, @SafeParcelable.Param boolean z2, @SafeParcelable.Param long j) {
        this.a = z;
        this.b = str;
        this.c = i;
        this.d = bArr;
        this.e = strArr;
        this.f = strArr2;
        this.g = z2;
        this.h = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, 5, this.e, false);
        SafeParcelWriter.a(parcel, 6, this.f, false);
        SafeParcelWriter.a(parcel, 7, this.g);
        SafeParcelWriter.a(parcel, 8, this.h);
        SafeParcelWriter.a(parcel, a);
    }
}
