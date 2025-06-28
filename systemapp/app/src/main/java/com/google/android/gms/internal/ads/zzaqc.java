package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzaqc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqc> CREATOR = new zzaqf();

    @SafeParcelable.Field
    private final int a;

    @SafeParcelable.Field
    private final int b;

    @SafeParcelable.Field
    private final int c;

    public static zzaqc a(VersionInfo versionInfo) {
        return new zzaqc(versionInfo.a(), versionInfo.b(), versionInfo.c());
    }

    @SafeParcelable.Constructor
    zzaqc(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, a);
    }

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaqc)) {
            return false;
        }
        zzaqc zzaqcVar = (zzaqc) obj;
        return zzaqcVar.c == this.c && zzaqcVar.b == this.b && zzaqcVar.a == this.a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.a, this.b, this.c});
    }
}
