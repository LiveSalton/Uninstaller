package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzazh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazh> CREATOR = new zzazg();

    @SafeParcelable.Field
    public String a;

    @SafeParcelable.Field
    public int b;

    @SafeParcelable.Field
    public int c;

    @SafeParcelable.Field
    public boolean d;

    @SafeParcelable.Field
    public boolean e;

    public zzazh(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzazh(int i, int i2, boolean z, boolean z2) {
        this(203404000, i2, true, false, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzazh(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L5
            java.lang.String r11 = "0"
            goto L7
        L5:
            java.lang.String r11 = "1"
        L7:
            r12 = 36
            java.lang.String r0 = java.lang.String.valueOf(r11)
            int r0 = r0.length()
            int r12 = r12 + r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r11)
            java.lang.String r2 = r0.toString()
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazh.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    zzazh(@SafeParcelable.Param String str, @SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param boolean z, @SafeParcelable.Param boolean z2) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public static zzazh a() {
        return new zzazh(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, 3, this.b);
        SafeParcelWriter.a(parcel, 4, this.c);
        SafeParcelWriter.a(parcel, 5, this.d);
        SafeParcelWriter.a(parcel, 6, this.e);
        SafeParcelWriter.a(parcel, a);
    }
}
