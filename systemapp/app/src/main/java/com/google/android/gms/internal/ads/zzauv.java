package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzauv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauv> CREATOR = new zzauu();

    @SafeParcelable.Field
    public final zzvk a;

    @SafeParcelable.Field
    public final String b;

    @SafeParcelable.Constructor
    public zzauv(@SafeParcelable.Param zzvk zzvkVar, @SafeParcelable.Param String str) {
        this.a = zzvkVar;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.a, i, false);
        SafeParcelWriter.a(parcel, 3, this.b, false);
        SafeParcelWriter.a(parcel, a);
    }
}
