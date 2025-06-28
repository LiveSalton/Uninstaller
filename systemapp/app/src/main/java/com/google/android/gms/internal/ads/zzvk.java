package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzvk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvk> CREATOR = new zzvm();

    @SafeParcelable.Field
    public final int a;

    @SafeParcelable.Field
    @Deprecated
    public final long b;

    @SafeParcelable.Field
    public final Bundle c;

    @SafeParcelable.Field
    @Deprecated
    public final int d;

    @SafeParcelable.Field
    public final List<String> e;

    @SafeParcelable.Field
    public final boolean f;

    @SafeParcelable.Field
    public final int g;

    @SafeParcelable.Field
    public final boolean h;

    @SafeParcelable.Field
    public final String i;

    @SafeParcelable.Field
    public final zzaag j;

    @SafeParcelable.Field
    public final Location k;

    @SafeParcelable.Field
    public final String l;

    @SafeParcelable.Field
    public final Bundle m;

    @SafeParcelable.Field
    public final Bundle n;

    @SafeParcelable.Field
    public final List<String> o;

    @SafeParcelable.Field
    public final String p;

    @SafeParcelable.Field
    public final String q;

    @SafeParcelable.Field
    @Deprecated
    public final boolean r;

    @SafeParcelable.Field
    public final zzvc s;

    @SafeParcelable.Field
    public final int t;

    @SafeParcelable.Field
    public final String u;

    @SafeParcelable.Field
    public final List<String> v;

    @SafeParcelable.Field
    public final int w;

    @SafeParcelable.Constructor
    public zzvk(@SafeParcelable.Param int i, @SafeParcelable.Param long j, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param int i2, @SafeParcelable.Param List<String> list, @SafeParcelable.Param boolean z, @SafeParcelable.Param int i3, @SafeParcelable.Param boolean z2, @SafeParcelable.Param String str, @SafeParcelable.Param zzaag zzaagVar, @SafeParcelable.Param Location location, @SafeParcelable.Param String str2, @SafeParcelable.Param Bundle bundle2, @SafeParcelable.Param Bundle bundle3, @SafeParcelable.Param List<String> list2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param boolean z3, @SafeParcelable.Param zzvc zzvcVar, @SafeParcelable.Param int i4, @SafeParcelable.Param String str5, @SafeParcelable.Param List<String> list3, @SafeParcelable.Param int i5) {
        this.a = i;
        this.b = j;
        this.c = bundle == null ? new Bundle() : bundle;
        this.d = i2;
        this.e = list;
        this.f = z;
        this.g = i3;
        this.h = z2;
        this.i = str;
        this.j = zzaagVar;
        this.k = location;
        this.l = str2;
        this.m = bundle2 == null ? new Bundle() : bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = str3;
        this.q = str4;
        this.r = z3;
        this.s = zzvcVar;
        this.t = i4;
        this.u = str5;
        this.v = list3 == null ? new ArrayList<>() : list3;
        this.w = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, 4, this.d);
        SafeParcelWriter.b(parcel, 5, this.e, false);
        SafeParcelWriter.a(parcel, 6, this.f);
        SafeParcelWriter.a(parcel, 7, this.g);
        SafeParcelWriter.a(parcel, 8, this.h);
        SafeParcelWriter.a(parcel, 9, this.i, false);
        SafeParcelWriter.a(parcel, 10, (Parcelable) this.j, i, false);
        SafeParcelWriter.a(parcel, 11, (Parcelable) this.k, i, false);
        SafeParcelWriter.a(parcel, 12, this.l, false);
        SafeParcelWriter.a(parcel, 13, this.m, false);
        SafeParcelWriter.a(parcel, 14, this.n, false);
        SafeParcelWriter.b(parcel, 15, this.o, false);
        SafeParcelWriter.a(parcel, 16, this.p, false);
        SafeParcelWriter.a(parcel, 17, this.q, false);
        SafeParcelWriter.a(parcel, 18, this.r);
        SafeParcelWriter.a(parcel, 19, (Parcelable) this.s, i, false);
        SafeParcelWriter.a(parcel, 20, this.t);
        SafeParcelWriter.a(parcel, 21, this.u, false);
        SafeParcelWriter.b(parcel, 22, this.v, false);
        SafeParcelWriter.a(parcel, 23, this.w);
        SafeParcelWriter.a(parcel, a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzvk)) {
            return false;
        }
        zzvk zzvkVar = (zzvk) obj;
        return this.a == zzvkVar.a && this.b == zzvkVar.b && Objects.a(this.c, zzvkVar.c) && this.d == zzvkVar.d && Objects.a(this.e, zzvkVar.e) && this.f == zzvkVar.f && this.g == zzvkVar.g && this.h == zzvkVar.h && Objects.a(this.i, zzvkVar.i) && Objects.a(this.j, zzvkVar.j) && Objects.a(this.k, zzvkVar.k) && Objects.a(this.l, zzvkVar.l) && Objects.a(this.m, zzvkVar.m) && Objects.a(this.n, zzvkVar.n) && Objects.a(this.o, zzvkVar.o) && Objects.a(this.p, zzvkVar.p) && Objects.a(this.q, zzvkVar.q) && this.r == zzvkVar.r && this.t == zzvkVar.t && Objects.a(this.u, zzvkVar.u) && Objects.a(this.v, zzvkVar.v) && this.w == zzvkVar.w;
    }

    public final int hashCode() {
        return Objects.a(Integer.valueOf(this.a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), this.e, Boolean.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h), this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, Boolean.valueOf(this.r), Integer.valueOf(this.t), this.u, this.v, Integer.valueOf(this.w));
    }
}
