package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzy();

    @SafeParcelable.Field
    public final long a;

    @SafeParcelable.Field
    public final long b;

    @SafeParcelable.Field
    public final boolean c;

    @SafeParcelable.Field
    public final String d;

    @SafeParcelable.Field
    public final String e;

    @SafeParcelable.Field
    public final String f;

    @SafeParcelable.Field
    public final Bundle g;

    @SafeParcelable.Constructor
    public zzv(@SafeParcelable.Param long j, @SafeParcelable.Param long j2, @SafeParcelable.Param boolean z, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param Bundle bundle) {
        this.a = j;
        this.b = j2;
        this.c = z;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, 5, this.e, false);
        SafeParcelWriter.a(parcel, 6, this.f, false);
        SafeParcelWriter.a(parcel, 7, this.g, false);
        SafeParcelWriter.a(parcel, a);
    }
}
