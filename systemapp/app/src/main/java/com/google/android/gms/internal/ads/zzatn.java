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
public final class zzatn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatn> CREATOR = new zzatm();

    @SafeParcelable.Field
    String a;

    @SafeParcelable.Constructor
    public zzatn(@SafeParcelable.Param String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, a);
    }
}
