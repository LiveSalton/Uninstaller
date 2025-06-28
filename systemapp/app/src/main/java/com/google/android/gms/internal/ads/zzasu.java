package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzasu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasu> CREATOR = new zzasx();

    @SafeParcelable.Field
    private final boolean A;

    @SafeParcelable.Field
    private final boolean B;

    @SafeParcelable.Field
    private final zzava C;

    @SafeParcelable.Field
    private final List<String> D;

    @SafeParcelable.Field
    private final List<String> E;

    @SafeParcelable.Field
    private final boolean F;

    @SafeParcelable.Field
    private final zzasw G;

    @SafeParcelable.Field
    private final boolean H;

    @SafeParcelable.Field
    private String I;

    @SafeParcelable.Field
    private final List<String> J;

    @SafeParcelable.Field
    private final boolean K;

    @SafeParcelable.Field
    private final String L;

    @SafeParcelable.Field
    private final zzawp M;

    @SafeParcelable.Field
    private final String N;

    @SafeParcelable.Field
    private final boolean O;

    @SafeParcelable.Field
    private final boolean P;

    @SafeParcelable.Field
    private Bundle Q;

    @SafeParcelable.Field
    private final boolean R;

    @SafeParcelable.Field
    private final int S;

    @SafeParcelable.Field
    private final boolean T;

    @SafeParcelable.Field
    private final List<String> U;

    @SafeParcelable.Field
    private final boolean V;

    @SafeParcelable.Field
    private final String W;

    @SafeParcelable.Field
    private String X;

    @SafeParcelable.Field
    private boolean Y;

    @SafeParcelable.Field
    private boolean Z;

    @SafeParcelable.Field
    private final int a;

    @SafeParcelable.Field
    private final String b;

    @SafeParcelable.Field
    private String c;

    @SafeParcelable.Field
    private final List<String> d;

    @SafeParcelable.Field
    private final int e;

    @SafeParcelable.Field
    private final List<String> f;

    @SafeParcelable.Field
    private final long g;

    @SafeParcelable.Field
    private final boolean h;

    @SafeParcelable.Field
    private final long i;

    @SafeParcelable.Field
    private final List<String> j;

    @SafeParcelable.Field
    private final long k;

    @SafeParcelable.Field
    private final int l;

    @SafeParcelable.Field
    private final String m;

    @SafeParcelable.Field
    private final long n;

    @SafeParcelable.Field
    private final String o;

    @SafeParcelable.Field
    private final boolean p;

    @SafeParcelable.Field
    private final String q;

    @SafeParcelable.Field
    private final String r;

    @SafeParcelable.Field
    private final boolean s;

    @SafeParcelable.Field
    private final boolean t;

    @SafeParcelable.Field
    private final boolean u;

    @SafeParcelable.Field
    private final boolean v;

    @SafeParcelable.Field
    private final boolean w;

    @SafeParcelable.Field
    private zzatg x;

    @SafeParcelable.Field
    private String y;

    @SafeParcelable.Field
    private final String z;

    @SafeParcelable.Constructor
    zzasu(@SafeParcelable.Param int i, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param List<String> list, @SafeParcelable.Param int i2, @SafeParcelable.Param List<String> list2, @SafeParcelable.Param long j, @SafeParcelable.Param boolean z, @SafeParcelable.Param long j2, @SafeParcelable.Param List<String> list3, @SafeParcelable.Param long j3, @SafeParcelable.Param int i3, @SafeParcelable.Param String str3, @SafeParcelable.Param long j4, @SafeParcelable.Param String str4, @SafeParcelable.Param boolean z2, @SafeParcelable.Param String str5, @SafeParcelable.Param String str6, @SafeParcelable.Param boolean z3, @SafeParcelable.Param boolean z4, @SafeParcelable.Param boolean z5, @SafeParcelable.Param boolean z6, @SafeParcelable.Param boolean z7, @SafeParcelable.Param zzatg zzatgVar, @SafeParcelable.Param String str7, @SafeParcelable.Param String str8, @SafeParcelable.Param boolean z8, @SafeParcelable.Param boolean z9, @SafeParcelable.Param zzava zzavaVar, @SafeParcelable.Param List<String> list4, @SafeParcelable.Param List<String> list5, @SafeParcelable.Param boolean z10, @SafeParcelable.Param zzasw zzaswVar, @SafeParcelable.Param boolean z11, @SafeParcelable.Param String str9, @SafeParcelable.Param List<String> list6, @SafeParcelable.Param boolean z12, @SafeParcelable.Param String str10, @SafeParcelable.Param zzawp zzawpVar, @SafeParcelable.Param String str11, @SafeParcelable.Param boolean z13, @SafeParcelable.Param boolean z14, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param boolean z15, @SafeParcelable.Param int i4, @SafeParcelable.Param boolean z16, @SafeParcelable.Param List<String> list7, @SafeParcelable.Param boolean z17, @SafeParcelable.Param String str12, @SafeParcelable.Param String str13, @SafeParcelable.Param boolean z18, @SafeParcelable.Param boolean z19) {
        zzatn zzatnVar;
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = list != null ? Collections.unmodifiableList(list) : null;
        this.e = i2;
        this.f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.g = j;
        this.h = z;
        this.i = j2;
        this.j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.k = j3;
        this.l = i3;
        this.m = str3;
        this.n = j4;
        this.o = str4;
        this.p = z2;
        this.q = str5;
        this.r = str6;
        this.s = z3;
        this.t = z4;
        this.u = z5;
        this.v = z6;
        this.O = z13;
        this.w = z7;
        this.x = zzatgVar;
        this.y = str7;
        this.z = str8;
        if (this.c == null && this.x != null && (zzatnVar = (zzatn) this.x.a(zzatn.CREATOR)) != null && !TextUtils.isEmpty(zzatnVar.a)) {
            this.c = zzatnVar.a;
        }
        this.A = z8;
        this.B = z9;
        this.C = zzavaVar;
        this.D = list4;
        this.E = list5;
        this.F = z10;
        this.G = zzaswVar;
        this.H = z11;
        this.I = str9;
        this.J = list6;
        this.K = z12;
        this.L = str10;
        this.M = zzawpVar;
        this.N = str11;
        this.P = z14;
        this.Q = bundle;
        this.R = z15;
        this.S = i4;
        this.T = z16;
        this.U = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.V = z17;
        this.W = str12;
        this.X = str13;
        this.Y = z18;
        this.Z = z19;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.b(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, 5, this.e);
        SafeParcelWriter.b(parcel, 6, this.f, false);
        SafeParcelWriter.a(parcel, 7, this.g);
        SafeParcelWriter.a(parcel, 8, this.h);
        SafeParcelWriter.a(parcel, 9, this.i);
        SafeParcelWriter.b(parcel, 10, this.j, false);
        SafeParcelWriter.a(parcel, 11, this.k);
        SafeParcelWriter.a(parcel, 12, this.l);
        SafeParcelWriter.a(parcel, 13, this.m, false);
        SafeParcelWriter.a(parcel, 14, this.n);
        SafeParcelWriter.a(parcel, 15, this.o, false);
        SafeParcelWriter.a(parcel, 18, this.p);
        SafeParcelWriter.a(parcel, 19, this.q, false);
        SafeParcelWriter.a(parcel, 21, this.r, false);
        SafeParcelWriter.a(parcel, 22, this.s);
        SafeParcelWriter.a(parcel, 23, this.t);
        SafeParcelWriter.a(parcel, 24, this.u);
        SafeParcelWriter.a(parcel, 25, this.v);
        SafeParcelWriter.a(parcel, 26, this.w);
        SafeParcelWriter.a(parcel, 28, (Parcelable) this.x, i, false);
        SafeParcelWriter.a(parcel, 29, this.y, false);
        SafeParcelWriter.a(parcel, 30, this.z, false);
        SafeParcelWriter.a(parcel, 31, this.A);
        SafeParcelWriter.a(parcel, 32, this.B);
        SafeParcelWriter.a(parcel, 33, (Parcelable) this.C, i, false);
        SafeParcelWriter.b(parcel, 34, this.D, false);
        SafeParcelWriter.b(parcel, 35, this.E, false);
        SafeParcelWriter.a(parcel, 36, this.F);
        SafeParcelWriter.a(parcel, 37, (Parcelable) this.G, i, false);
        SafeParcelWriter.a(parcel, 38, this.H);
        SafeParcelWriter.a(parcel, 39, this.I, false);
        SafeParcelWriter.b(parcel, 40, this.J, false);
        SafeParcelWriter.a(parcel, 42, this.K);
        SafeParcelWriter.a(parcel, 43, this.L, false);
        SafeParcelWriter.a(parcel, 44, (Parcelable) this.M, i, false);
        SafeParcelWriter.a(parcel, 45, this.N, false);
        SafeParcelWriter.a(parcel, 46, this.O);
        SafeParcelWriter.a(parcel, 47, this.P);
        SafeParcelWriter.a(parcel, 48, this.Q, false);
        SafeParcelWriter.a(parcel, 49, this.R);
        SafeParcelWriter.a(parcel, 50, this.S);
        SafeParcelWriter.a(parcel, 51, this.T);
        SafeParcelWriter.b(parcel, 52, this.U, false);
        SafeParcelWriter.a(parcel, 53, this.V);
        SafeParcelWriter.a(parcel, 54, this.W, false);
        SafeParcelWriter.a(parcel, 55, this.X, false);
        SafeParcelWriter.a(parcel, 56, this.Y);
        SafeParcelWriter.a(parcel, 57, this.Z);
        SafeParcelWriter.a(parcel, a);
    }
}
