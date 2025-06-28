package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    @SafeParcelable.VersionField
    private final int h;

    @SafeParcelable.Field
    private final int i;

    @SafeParcelable.Field
    private final String j;

    @SafeParcelable.Field
    private final PendingIntent k;

    @ShowFirstParty
    @VisibleForTesting
    @KeepForSdk
    public static final Status a = new Status(0);

    @ShowFirstParty
    @KeepForSdk
    public static final Status b = new Status(14);

    @ShowFirstParty
    @KeepForSdk
    public static final Status c = new Status(8);

    @ShowFirstParty
    @KeepForSdk
    public static final Status d = new Status(15);

    @ShowFirstParty
    @KeepForSdk
    public static final Status e = new Status(16);

    @ShowFirstParty
    private static final Status g = new Status(17);

    @KeepForSdk
    public static final Status f = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    @SafeParcelable.Constructor
    @KeepForSdk
    Status(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param String str, @SafeParcelable.Param PendingIntent pendingIntent) {
        this.h = i;
        this.i = i2;
        this.j = str;
        this.k = pendingIntent;
    }

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    @KeepForSdk
    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public final String a() {
        return this.j;
    }

    public final int b() {
        return this.i;
    }

    public final int hashCode() {
        return Objects.a(Integer.valueOf(this.h), Integer.valueOf(this.i), this.j, this.k);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.h == status.h && this.i == status.i && Objects.a(this.j, status.j) && Objects.a(this.k, status.k);
    }

    public final String c() {
        if (this.j != null) {
            return this.j;
        }
        return CommonStatusCodes.a(this.i);
    }

    public final String toString() {
        return Objects.a(this).a("statusCode", c()).a("resolution", this.k).toString();
    }

    @Override // android.os.Parcelable
    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, b());
        SafeParcelWriter.a(parcel, 2, a(), false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.k, i, false);
        SafeParcelWriter.a(parcel, 1000, this.h);
        SafeParcelWriter.a(parcel, a2);
    }
}
