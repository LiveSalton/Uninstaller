package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzmh extends zzmk {
    public static final Parcelable.Creator<zzmh> CREATOR = new baj();
    private final String a;
    private final String b;
    private final int d;
    private final byte[] e;

    public zzmh(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.a = str;
        this.b = null;
        this.d = 3;
        this.e = bArr;
    }

    zzmh(Parcel parcel) {
        super("APIC");
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzmh zzmhVar = (zzmh) obj;
        return this.d == zzmhVar.d && zzpt.a(this.a, zzmhVar.a) && zzpt.a(this.b, zzmhVar.b) && Arrays.equals(this.e, zzmhVar.e);
    }

    public final int hashCode() {
        return ((((((527 + this.d) * 31) + (this.a != null ? this.a.hashCode() : 0)) * 31) + (this.b != null ? this.b.hashCode() : 0)) * 31) + Arrays.hashCode(this.e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
