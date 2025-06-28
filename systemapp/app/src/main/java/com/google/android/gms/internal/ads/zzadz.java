package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzadz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzadz> CREATOR = new zzady();

    @SafeParcelable.Field
    public final int a;

    @SafeParcelable.Field
    public final boolean b;

    @SafeParcelable.Field
    public final int c;

    @SafeParcelable.Field
    public final boolean d;

    @SafeParcelable.Field
    public final int e;

    @SafeParcelable.Field
    public final zzaak f;

    @SafeParcelable.Field
    public final boolean g;

    @SafeParcelable.Field
    public final int h;

    public zzadz(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.a(), nativeAdOptions.b(), nativeAdOptions.d(), nativeAdOptions.e(), nativeAdOptions.f() != null ? new zzaak(nativeAdOptions.f()) : null, nativeAdOptions.g(), nativeAdOptions.c());
    }

    @SafeParcelable.Constructor
    public zzadz(@SafeParcelable.Param int i, @SafeParcelable.Param boolean z, @SafeParcelable.Param int i2, @SafeParcelable.Param boolean z2, @SafeParcelable.Param int i3, @SafeParcelable.Param zzaak zzaakVar, @SafeParcelable.Param boolean z3, @SafeParcelable.Param int i4) {
        this.a = i;
        this.b = z;
        this.c = i2;
        this.d = z2;
        this.e = i3;
        this.f = zzaakVar;
        this.g = z3;
        this.h = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, 4, this.d);
        SafeParcelWriter.a(parcel, 5, this.e);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.f, i, false);
        SafeParcelWriter.a(parcel, 7, this.g);
        SafeParcelWriter.a(parcel, 8, this.h);
        SafeParcelWriter.a(parcel, a);
    }
}
