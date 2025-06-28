package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzatl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatl> CREATOR = new zzatk();

    @SafeParcelable.Field
    public final Bundle a;

    @SafeParcelable.Field
    public final zzazh b;

    @SafeParcelable.Field
    public final ApplicationInfo c;

    @SafeParcelable.Field
    public final String d;

    @SafeParcelable.Field
    public final List<String> e;

    @SafeParcelable.Field
    public final PackageInfo f;

    @SafeParcelable.Field
    public final String g;

    @SafeParcelable.Field
    public final boolean h;

    @SafeParcelable.Field
    public final String i;

    @SafeParcelable.Field
    public zzdpk j;

    @SafeParcelable.Field
    public String k;

    @SafeParcelable.Constructor
    public zzatl(@SafeParcelable.Param Bundle bundle, @SafeParcelable.Param zzazh zzazhVar, @SafeParcelable.Param ApplicationInfo applicationInfo, @SafeParcelable.Param String str, @SafeParcelable.Param List<String> list, @SafeParcelable.Param PackageInfo packageInfo, @SafeParcelable.Param String str2, @SafeParcelable.Param boolean z, @SafeParcelable.Param String str3, @SafeParcelable.Param zzdpk zzdpkVar, @SafeParcelable.Param String str4) {
        this.a = bundle;
        this.b = zzazhVar;
        this.d = str;
        this.c = applicationInfo;
        this.e = list;
        this.f = packageInfo;
        this.g = str2;
        this.h = z;
        this.i = str3;
        this.j = zzdpkVar;
        this.k = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.b, i, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.c, i, false);
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.b(parcel, 5, this.e, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.f, i, false);
        SafeParcelWriter.a(parcel, 7, this.g, false);
        SafeParcelWriter.a(parcel, 8, this.h);
        SafeParcelWriter.a(parcel, 9, this.i, false);
        SafeParcelWriter.a(parcel, 10, (Parcelable) this.j, i, false);
        SafeParcelWriter.a(parcel, 11, this.k, false);
        SafeParcelWriter.a(parcel, a);
    }
}
