package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzb();

    @SafeParcelable.VersionField
    private final int a;

    @SafeParcelable.Field
    private final long b;

    @SafeParcelable.Field
    private int c;

    @SafeParcelable.Field
    private final String d;

    @SafeParcelable.Field
    private final String e;

    @SafeParcelable.Field
    private final String f;

    @SafeParcelable.Field
    private final int g;

    @SafeParcelable.Field
    private final List<String> h;

    @SafeParcelable.Field
    private final String i;

    @SafeParcelable.Field
    private final long j;

    @SafeParcelable.Field
    private int k;

    @SafeParcelable.Field
    private final String l;

    @SafeParcelable.Field
    private final float m;

    @SafeParcelable.Field
    private final long n;

    @SafeParcelable.Field
    private final boolean o;
    private long p = -1;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param int i, @SafeParcelable.Param long j, @SafeParcelable.Param int i2, @SafeParcelable.Param String str, @SafeParcelable.Param int i3, @SafeParcelable.Param List<String> list, @SafeParcelable.Param String str2, @SafeParcelable.Param long j2, @SafeParcelable.Param int i4, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param float f, @SafeParcelable.Param long j3, @SafeParcelable.Param String str5, @SafeParcelable.Param boolean z) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = str3;
        this.f = str5;
        this.g = i3;
        this.h = list;
        this.i = str2;
        this.j = j2;
        this.k = i4;
        this.l = str4;
        this.m = f;
        this.n = j3;
        this.o = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long a() {
        return this.b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long c() {
        return this.p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, a());
        SafeParcelWriter.a(parcel, 4, this.d, false);
        SafeParcelWriter.a(parcel, 5, this.g);
        SafeParcelWriter.b(parcel, 6, this.h, false);
        SafeParcelWriter.a(parcel, 8, this.j);
        SafeParcelWriter.a(parcel, 10, this.e, false);
        SafeParcelWriter.a(parcel, 11, b());
        SafeParcelWriter.a(parcel, 12, this.i, false);
        SafeParcelWriter.a(parcel, 13, this.l, false);
        SafeParcelWriter.a(parcel, 14, this.k);
        SafeParcelWriter.a(parcel, 15, this.m);
        SafeParcelWriter.a(parcel, 16, this.n);
        SafeParcelWriter.a(parcel, 17, this.f, false);
        SafeParcelWriter.a(parcel, 18, this.o);
        SafeParcelWriter.a(parcel, a);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String d() {
        String str = this.d;
        int i = this.g;
        String join = this.h == null ? "" : TextUtils.join(",", this.h);
        int i2 = this.k;
        String str2 = this.e == null ? "" : this.e;
        String str3 = this.l == null ? "" : this.l;
        float f = this.m;
        String str4 = this.f == null ? "" : this.f;
        boolean z = this.o;
        StringBuilder sb = new StringBuilder(51 + String.valueOf(str).length() + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
