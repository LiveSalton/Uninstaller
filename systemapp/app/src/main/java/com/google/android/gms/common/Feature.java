package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();

    @SafeParcelable.Field
    private final String a;

    @SafeParcelable.Field
    @Deprecated
    private final int b;

    @SafeParcelable.Field
    private final long c;

    @KeepForSdk
    public Feature(String str, long j) {
        this.a = str;
        this.c = j;
        this.b = -1;
    }

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param String str, @SafeParcelable.Param int i, @SafeParcelable.Param long j) {
        this.a = str;
        this.b = i;
        this.c = j;
    }

    @KeepForSdk
    public String a() {
        return this.a;
    }

    @KeepForSdk
    public long b() {
        return this.c == -1 ? this.b : this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, a(), false);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, b());
        SafeParcelWriter.a(parcel, a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        return ((a() != null && a().equals(feature.a())) || (a() == null && feature.a() == null)) && b() == feature.b();
    }

    public int hashCode() {
        return Objects.a(a(), Long.valueOf(b()));
    }

    public String toString() {
        return Objects.a(this).a("name", a()).a("version", Long.valueOf(b())).toString();
    }
}
