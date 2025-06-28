package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzass extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzass> CREATOR = new zzasv();

    @SafeParcelable.Field
    private final long A;

    @SafeParcelable.Field
    private final String B;

    @SafeParcelable.Field
    private final float C;

    @SafeParcelable.Field
    private final int D;

    @SafeParcelable.Field
    private final int E;

    @SafeParcelable.Field
    private final boolean F;

    @SafeParcelable.Field
    private final boolean G;

    @SafeParcelable.Field
    private final String H;

    @SafeParcelable.Field
    private final boolean I;

    @SafeParcelable.Field
    private final String J;

    @SafeParcelable.Field
    private final boolean K;

    @SafeParcelable.Field
    private final int L;

    @SafeParcelable.Field
    private final Bundle M;

    @SafeParcelable.Field
    private final String N;

    @SafeParcelable.Field
    private final zzyy O;

    @SafeParcelable.Field
    private final boolean P;

    @SafeParcelable.Field
    private final Bundle Q;

    @SafeParcelable.Field
    private final String R;

    @SafeParcelable.Field
    private final String S;

    @SafeParcelable.Field
    private final String T;

    @SafeParcelable.Field
    private final boolean U;

    @SafeParcelable.Field
    private final List<Integer> V;

    @SafeParcelable.Field
    private final String W;

    @SafeParcelable.Field
    private final List<String> X;

    @SafeParcelable.Field
    private final int Y;

    @SafeParcelable.Field
    private final boolean Z;

    @SafeParcelable.Field
    private final int a;

    @SafeParcelable.Field
    private final boolean aa;

    @SafeParcelable.Field
    private final boolean ab;

    @SafeParcelable.Field
    private final ArrayList<String> ac;

    @SafeParcelable.Field
    private final String ad;

    @SafeParcelable.Field
    private final zzajl ae;

    @SafeParcelable.Field
    private final String af;

    @SafeParcelable.Field
    private final Bundle ag;

    @SafeParcelable.Field
    private final Bundle b;

    @SafeParcelable.Field
    private final zzvk c;

    @SafeParcelable.Field
    private final zzvn d;

    @SafeParcelable.Field
    private final String e;

    @SafeParcelable.Field
    private final ApplicationInfo f;

    @SafeParcelable.Field
    private final PackageInfo g;

    @SafeParcelable.Field
    private final String h;

    @SafeParcelable.Field
    private final String i;

    @SafeParcelable.Field
    private final String j;

    @SafeParcelable.Field
    private final zzazh k;

    @SafeParcelable.Field
    private final Bundle l;

    @SafeParcelable.Field
    private final int m;

    @SafeParcelable.Field
    private final List<String> n;

    @SafeParcelable.Field
    private final Bundle o;

    @SafeParcelable.Field
    private final boolean p;

    @SafeParcelable.Field
    private final int q;

    @SafeParcelable.Field
    private final int r;

    @SafeParcelable.Field
    private final float s;

    @SafeParcelable.Field
    private final String t;

    @SafeParcelable.Field
    private final long u;

    @SafeParcelable.Field
    private final String v;

    @SafeParcelable.Field
    private final List<String> w;

    @SafeParcelable.Field
    private final String x;

    @SafeParcelable.Field
    private final zzadz y;

    @SafeParcelable.Field
    private final List<String> z;

    @SafeParcelable.Constructor
    zzass(@SafeParcelable.Param int i, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param zzvk zzvkVar, @SafeParcelable.Param zzvn zzvnVar, @SafeParcelable.Param String str, @SafeParcelable.Param ApplicationInfo applicationInfo, @SafeParcelable.Param PackageInfo packageInfo, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param zzazh zzazhVar, @SafeParcelable.Param Bundle bundle2, @SafeParcelable.Param int i2, @SafeParcelable.Param List<String> list, @SafeParcelable.Param Bundle bundle3, @SafeParcelable.Param boolean z, @SafeParcelable.Param int i3, @SafeParcelable.Param int i4, @SafeParcelable.Param float f, @SafeParcelable.Param String str5, @SafeParcelable.Param long j, @SafeParcelable.Param String str6, @SafeParcelable.Param List<String> list2, @SafeParcelable.Param String str7, @SafeParcelable.Param zzadz zzadzVar, @SafeParcelable.Param List<String> list3, @SafeParcelable.Param long j2, @SafeParcelable.Param String str8, @SafeParcelable.Param float f2, @SafeParcelable.Param boolean z2, @SafeParcelable.Param int i5, @SafeParcelable.Param int i6, @SafeParcelable.Param boolean z3, @SafeParcelable.Param boolean z4, @SafeParcelable.Param String str9, @SafeParcelable.Param String str10, @SafeParcelable.Param boolean z5, @SafeParcelable.Param int i7, @SafeParcelable.Param Bundle bundle4, @SafeParcelable.Param String str11, @SafeParcelable.Param zzyy zzyyVar, @SafeParcelable.Param boolean z6, @SafeParcelable.Param Bundle bundle5, @SafeParcelable.Param String str12, @SafeParcelable.Param String str13, @SafeParcelable.Param String str14, @SafeParcelable.Param boolean z7, @SafeParcelable.Param List<Integer> list4, @SafeParcelable.Param String str15, @SafeParcelable.Param List<String> list5, @SafeParcelable.Param int i8, @SafeParcelable.Param boolean z8, @SafeParcelable.Param boolean z9, @SafeParcelable.Param boolean z10, @SafeParcelable.Param ArrayList<String> arrayList, @SafeParcelable.Param String str16, @SafeParcelable.Param zzajl zzajlVar, @SafeParcelable.Param String str17, @SafeParcelable.Param Bundle bundle6) {
        this.a = i;
        this.b = bundle;
        this.c = zzvkVar;
        this.d = zzvnVar;
        this.e = str;
        this.f = applicationInfo;
        this.g = packageInfo;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = zzazhVar;
        this.l = bundle2;
        this.m = i2;
        this.n = list;
        this.z = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.o = bundle3;
        this.p = z;
        this.q = i3;
        this.r = i4;
        this.s = f;
        this.t = str5;
        this.u = j;
        this.v = str6;
        this.w = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.x = str7;
        this.y = zzadzVar;
        this.A = j2;
        this.B = str8;
        this.C = f2;
        this.I = z2;
        this.D = i5;
        this.E = i6;
        this.F = z3;
        this.G = z4;
        this.H = str9;
        this.J = str10;
        this.K = z5;
        this.L = i7;
        this.M = bundle4;
        this.N = str11;
        this.O = zzyyVar;
        this.P = z6;
        this.Q = bundle5;
        this.R = str12;
        this.S = str13;
        this.T = str14;
        this.U = z7;
        this.V = list4;
        this.W = str15;
        this.X = list5;
        this.Y = i8;
        this.Z = z8;
        this.aa = z9;
        this.ab = z10;
        this.ac = arrayList;
        this.ad = str16;
        this.ae = zzajlVar;
        this.af = str17;
        this.ag = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.c, i, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.d, i, false);
        SafeParcelWriter.a(parcel, 5, this.e, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable) this.f, i, false);
        SafeParcelWriter.a(parcel, 7, (Parcelable) this.g, i, false);
        SafeParcelWriter.a(parcel, 8, this.h, false);
        SafeParcelWriter.a(parcel, 9, this.i, false);
        SafeParcelWriter.a(parcel, 10, this.j, false);
        SafeParcelWriter.a(parcel, 11, (Parcelable) this.k, i, false);
        SafeParcelWriter.a(parcel, 12, this.l, false);
        SafeParcelWriter.a(parcel, 13, this.m);
        SafeParcelWriter.b(parcel, 14, this.n, false);
        SafeParcelWriter.a(parcel, 15, this.o, false);
        SafeParcelWriter.a(parcel, 16, this.p);
        SafeParcelWriter.a(parcel, 18, this.q);
        SafeParcelWriter.a(parcel, 19, this.r);
        SafeParcelWriter.a(parcel, 20, this.s);
        SafeParcelWriter.a(parcel, 21, this.t, false);
        SafeParcelWriter.a(parcel, 25, this.u);
        SafeParcelWriter.a(parcel, 26, this.v, false);
        SafeParcelWriter.b(parcel, 27, this.w, false);
        SafeParcelWriter.a(parcel, 28, this.x, false);
        SafeParcelWriter.a(parcel, 29, (Parcelable) this.y, i, false);
        SafeParcelWriter.b(parcel, 30, this.z, false);
        SafeParcelWriter.a(parcel, 31, this.A);
        SafeParcelWriter.a(parcel, 33, this.B, false);
        SafeParcelWriter.a(parcel, 34, this.C);
        SafeParcelWriter.a(parcel, 35, this.D);
        SafeParcelWriter.a(parcel, 36, this.E);
        SafeParcelWriter.a(parcel, 37, this.F);
        SafeParcelWriter.a(parcel, 38, this.G);
        SafeParcelWriter.a(parcel, 39, this.H, false);
        SafeParcelWriter.a(parcel, 40, this.I);
        SafeParcelWriter.a(parcel, 41, this.J, false);
        SafeParcelWriter.a(parcel, 42, this.K);
        SafeParcelWriter.a(parcel, 43, this.L);
        SafeParcelWriter.a(parcel, 44, this.M, false);
        SafeParcelWriter.a(parcel, 45, this.N, false);
        SafeParcelWriter.a(parcel, 46, (Parcelable) this.O, i, false);
        SafeParcelWriter.a(parcel, 47, this.P);
        SafeParcelWriter.a(parcel, 48, this.Q, false);
        SafeParcelWriter.a(parcel, 49, this.R, false);
        SafeParcelWriter.a(parcel, 50, this.S, false);
        SafeParcelWriter.a(parcel, 51, this.T, false);
        SafeParcelWriter.a(parcel, 52, this.U);
        SafeParcelWriter.a(parcel, 53, this.V, false);
        SafeParcelWriter.a(parcel, 54, this.W, false);
        SafeParcelWriter.b(parcel, 55, this.X, false);
        SafeParcelWriter.a(parcel, 56, this.Y);
        SafeParcelWriter.a(parcel, 57, this.Z);
        SafeParcelWriter.a(parcel, 58, this.aa);
        SafeParcelWriter.a(parcel, 59, this.ab);
        SafeParcelWriter.b(parcel, 60, this.ac, false);
        SafeParcelWriter.a(parcel, 61, this.ad, false);
        SafeParcelWriter.a(parcel, 63, (Parcelable) this.ae, i, false);
        SafeParcelWriter.a(parcel, 64, this.af, false);
        SafeParcelWriter.a(parcel, 65, this.ag, false);
        SafeParcelWriter.a(parcel, a);
    }
}
