package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final String b;

    @SafeParcelable.Field
    public final String c;

    @SafeParcelable.Field
    public final String d;

    @SafeParcelable.Field
    public final String e;

    @SafeParcelable.Field
    public final Intent f;

    @SafeParcelable.Field
    private final String g;

    @SafeParcelable.Field
    private final String h;

    public zzb(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    public zzb(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param String str5, @SafeParcelable.Param String str6, @SafeParcelable.Param String str7, @SafeParcelable.Param Intent intent) {
        this.g = str;
        this.a = str2;
        this.b = str3;
        this.c = str4;
        this.d = str5;
        this.e = str6;
        this.h = str7;
        this.f = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.g, false);
        SafeParcelWriter.a(parcel, 3, this.a, false);
        SafeParcelWriter.a(parcel, 4, this.b, false);
        SafeParcelWriter.a(parcel, 5, this.c, false);
        SafeParcelWriter.a(parcel, 6, this.d, false);
        SafeParcelWriter.a(parcel, 7, this.e, false);
        SafeParcelWriter.a(parcel, 8, this.h, false);
        SafeParcelWriter.a(parcel, 9, (Parcelable) this.f, i, false);
        SafeParcelWriter.a(parcel, a);
    }
}
