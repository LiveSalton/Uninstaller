package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();

    @SafeParcelable.Field
    public final boolean a;

    @SafeParcelable.Field
    public final boolean b;

    @SafeParcelable.Field
    public final boolean c;

    @SafeParcelable.Field
    public final float d;

    @SafeParcelable.Field
    public final int e;

    @SafeParcelable.Field
    public final boolean f;

    @SafeParcelable.Field
    public final boolean g;

    @SafeParcelable.Field
    public final boolean h;

    @SafeParcelable.Field
    private final String i;

    public zzi(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    @SafeParcelable.Constructor
    zzi(@SafeParcelable.Param boolean z, @SafeParcelable.Param boolean z2, @SafeParcelable.Param String str, @SafeParcelable.Param boolean z3, @SafeParcelable.Param float f, @SafeParcelable.Param int i, @SafeParcelable.Param boolean z4, @SafeParcelable.Param boolean z5, @SafeParcelable.Param boolean z6) {
        this.a = z;
        this.b = z2;
        this.i = str;
        this.c = z3;
        this.d = f;
        this.e = i;
        this.f = z4;
        this.g = z5;
        this.h = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a);
        SafeParcelWriter.a(parcel, 3, this.b);
        SafeParcelWriter.a(parcel, 4, this.i, false);
        SafeParcelWriter.a(parcel, 5, this.c);
        SafeParcelWriter.a(parcel, 6, this.d);
        SafeParcelWriter.a(parcel, 7, this.e);
        SafeParcelWriter.a(parcel, 8, this.f);
        SafeParcelWriter.a(parcel, 9, this.g);
        SafeParcelWriter.a(parcel, 10, this.h);
        SafeParcelWriter.a(parcel, a);
    }
}
