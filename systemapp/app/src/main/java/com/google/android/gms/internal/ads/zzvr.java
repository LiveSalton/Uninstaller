package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzvr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvr> CREATOR = new zzvu();

    @SafeParcelable.Field
    public String a;

    @SafeParcelable.Field
    public long b;

    @SafeParcelable.Field
    public zzve c;

    @SafeParcelable.Field
    public Bundle d;

    @SafeParcelable.Constructor
    public zzvr(@SafeParcelable.Param String str, @SafeParcelable.Param long j, @SafeParcelable.Param zzve zzveVar, @SafeParcelable.Param Bundle bundle) {
        this.a = str;
        this.b = j;
        this.c = zzveVar;
        this.d = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.c, i, false);
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, a);
    }
}
