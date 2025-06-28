package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class zzvn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvn> CREATOR = new zzvq();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final int b;

    @SafeParcelable.Field
    public final int c;

    @SafeParcelable.Field
    public final boolean d;

    @SafeParcelable.Field
    public final int e;

    @SafeParcelable.Field
    public final int f;

    @SafeParcelable.Field
    public final zzvn[] g;

    @SafeParcelable.Field
    public final boolean h;

    @SafeParcelable.Field
    public final boolean i;

    @SafeParcelable.Field
    public boolean j;

    @SafeParcelable.Field
    public boolean k;

    @SafeParcelable.Field
    public boolean l;

    @SafeParcelable.Field
    public boolean m;

    @SafeParcelable.Field
    private boolean n;

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int) (c(displayMetrics) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzvn a() {
        return new zzvn("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false);
    }

    public static zzvn b() {
        return new zzvn("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static zzvn c() {
        return new zzvn("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false);
    }

    public zzvn() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static zzvn d() {
        return new zzvn("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false);
    }

    public zzvn(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzvn(android.content.Context r12, com.google.android.gms.ads.AdSize[] r13) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzvn(@SafeParcelable.Param String str, @SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param boolean z, @SafeParcelable.Param int i3, @SafeParcelable.Param int i4, @SafeParcelable.Param zzvn[] zzvnVarArr, @SafeParcelable.Param boolean z2, @SafeParcelable.Param boolean z3, @SafeParcelable.Param boolean z4, @SafeParcelable.Param boolean z5, @SafeParcelable.Param boolean z6, @SafeParcelable.Param boolean z7, @SafeParcelable.Param boolean z8) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.f = i4;
        this.g = zzvnVarArr;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
        this.n = z6;
        this.l = z7;
        this.m = z8;
    }

    public final AdSize e() {
        return com.google.android.gms.ads.zzb.a(this.e, this.b, this.a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, 3, this.b);
        SafeParcelWriter.a(parcel, 4, this.c);
        SafeParcelWriter.a(parcel, 5, this.d);
        SafeParcelWriter.a(parcel, 6, this.e);
        SafeParcelWriter.a(parcel, 7, this.f);
        SafeParcelWriter.a(parcel, 8, (Parcelable[]) this.g, i, false);
        SafeParcelWriter.a(parcel, 9, this.h);
        SafeParcelWriter.a(parcel, 10, this.i);
        SafeParcelWriter.a(parcel, 11, this.j);
        SafeParcelWriter.a(parcel, 12, this.k);
        SafeParcelWriter.a(parcel, 13, this.n);
        SafeParcelWriter.a(parcel, 14, this.l);
        SafeParcelWriter.a(parcel, 15, this.m);
        SafeParcelWriter.a(parcel, a);
    }
}
