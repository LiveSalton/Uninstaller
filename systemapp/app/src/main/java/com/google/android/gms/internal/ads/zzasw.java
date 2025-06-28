package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzasw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasw> CREATOR = new zzasz();

    @SafeParcelable.Field
    public final boolean a;

    @SafeParcelable.Field
    public final List<String> b;

    public zzasw() {
        this(false, Collections.emptyList());
    }

    @SafeParcelable.Constructor
    public zzasw(@SafeParcelable.Param boolean z, @SafeParcelable.Param List<String> list) {
        this.a = z;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a);
        SafeParcelWriter.b(parcel, 3, this.b, false);
        SafeParcelWriter.a(parcel, a);
    }
}
