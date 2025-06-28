package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzaiz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiz> CREATOR = new zzaiy();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final boolean b;

    @SafeParcelable.Field
    public final int c;

    @SafeParcelable.Field
    public final String d;

    @SafeParcelable.Constructor
    public zzaiz(@SafeParcelable.Param String str, @SafeParcelable.Param boolean z, @SafeParcelable.Param int i, @SafeParcelable.Param String str2) {
        this.a = str;
        this.b = z;
        this.c = i;
        this.d = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, a);
    }
}
