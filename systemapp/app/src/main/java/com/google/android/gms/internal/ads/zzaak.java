package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzaak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaak> CREATOR = new zzaan();

    @SafeParcelable.Field
    public final boolean a;

    @SafeParcelable.Field
    public final boolean b;

    @SafeParcelable.Field
    public final boolean c;

    public zzaak(VideoOptions videoOptions) {
        this(videoOptions.a(), videoOptions.b(), videoOptions.c());
    }

    @SafeParcelable.Constructor
    public zzaak(@SafeParcelable.Param boolean z, @SafeParcelable.Param boolean z2, @SafeParcelable.Param boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a);
        SafeParcelWriter.a(parcel, 3, this.b);
        SafeParcelWriter.a(parcel, 4, this.c);
        SafeParcelWriter.a(parcel, a);
    }
}
