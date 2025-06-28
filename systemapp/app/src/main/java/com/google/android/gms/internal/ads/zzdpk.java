package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzdpk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdpk> CREATOR = new zzdpo();

    @Nullable
    public final Context a;
    public final zzdpj b;

    @SafeParcelable.Field
    public final int c;

    @SafeParcelable.Field
    public final int d;

    @SafeParcelable.Field
    public final int e;

    @SafeParcelable.Field
    public final String f;
    public final int g;
    private final zzdpj[] h;
    private final int[] i;
    private final int[] j;

    @SafeParcelable.Field
    private final int k;

    @SafeParcelable.Field
    private final int l;

    @SafeParcelable.Field
    private final int m;
    private final int n;

    private zzdpk(@Nullable Context context, zzdpj zzdpjVar, int i, int i2, int i3, String str, String str2, String str3) {
        this.h = zzdpj.values();
        this.i = zzdpm.a();
        this.j = zzdpl.a();
        this.a = context;
        this.k = zzdpjVar.ordinal();
        this.b = zzdpjVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = str;
        this.g = "oldest".equals(str2) ? zzdpm.a : ("lru".equals(str2) || !"lfu".equals(str2)) ? zzdpm.b : zzdpm.c;
        this.l = this.g - 1;
        "onAdClosed".equals(str3);
        this.n = zzdpl.a;
        this.m = this.n - 1;
    }

    @SafeParcelable.Constructor
    public zzdpk(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param int i3, @SafeParcelable.Param int i4, @SafeParcelable.Param String str, @SafeParcelable.Param int i5, @SafeParcelable.Param int i6) {
        this.h = zzdpj.values();
        this.i = zzdpm.a();
        this.j = zzdpl.a();
        this.a = null;
        this.k = i;
        this.b = this.h[i];
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = str;
        this.l = i5;
        this.g = this.i[i5];
        this.m = i6;
        this.n = this.j[i6];
    }

    public static zzdpk a(zzdpj zzdpjVar, Context context) {
        if (zzdpjVar == zzdpj.Rewarded) {
            return new zzdpk(context, zzdpjVar, ((Integer) zzwq.e().a(zzabf.dz)).intValue(), ((Integer) zzwq.e().a(zzabf.dF)).intValue(), ((Integer) zzwq.e().a(zzabf.dH)).intValue(), (String) zzwq.e().a(zzabf.dJ), (String) zzwq.e().a(zzabf.dB), (String) zzwq.e().a(zzabf.dD));
        }
        if (zzdpjVar == zzdpj.Interstitial) {
            return new zzdpk(context, zzdpjVar, ((Integer) zzwq.e().a(zzabf.dA)).intValue(), ((Integer) zzwq.e().a(zzabf.dG)).intValue(), ((Integer) zzwq.e().a(zzabf.dI)).intValue(), (String) zzwq.e().a(zzabf.dK), (String) zzwq.e().a(zzabf.dC), (String) zzwq.e().a(zzabf.dE));
        }
        if (zzdpjVar != zzdpj.AppOpen) {
            return null;
        }
        return new zzdpk(context, zzdpjVar, ((Integer) zzwq.e().a(zzabf.dN)).intValue(), ((Integer) zzwq.e().a(zzabf.dP)).intValue(), ((Integer) zzwq.e().a(zzabf.dQ)).intValue(), (String) zzwq.e().a(zzabf.dL), (String) zzwq.e().a(zzabf.dM), (String) zzwq.e().a(zzabf.dO));
    }

    public static boolean a() {
        return ((Boolean) zzwq.e().a(zzabf.dy)).booleanValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.k);
        SafeParcelWriter.a(parcel, 2, this.c);
        SafeParcelWriter.a(parcel, 3, this.d);
        SafeParcelWriter.a(parcel, 4, this.e);
        SafeParcelWriter.a(parcel, 5, this.f, false);
        SafeParcelWriter.a(parcel, 6, this.l);
        SafeParcelWriter.a(parcel, 7, this.m);
        SafeParcelWriter.a(parcel, a);
    }
}
