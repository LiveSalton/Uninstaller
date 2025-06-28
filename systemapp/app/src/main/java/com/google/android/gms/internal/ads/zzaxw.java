package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzaxw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaxw> CREATOR = new zzaxz();

    @SafeParcelable.Field
    @Deprecated
    public final String a;

    @SafeParcelable.Field
    public final String b;

    @SafeParcelable.Field
    @Deprecated
    public final zzvn c;

    @SafeParcelable.Field
    public final zzvk d;

    @SafeParcelable.Constructor
    public zzaxw(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param zzvn zzvnVar, @SafeParcelable.Param zzvk zzvkVar) {
        this.a = str;
        this.b = str2;
        this.c = zzvnVar;
        this.d = zzvkVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.c, i, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.d, i, false);
        SafeParcelWriter.a(parcel, a);
    }
}
