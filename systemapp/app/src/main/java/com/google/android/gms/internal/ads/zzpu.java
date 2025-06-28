package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpu implements Parcelable {
    public static final Parcelable.Creator<zzpu> CREATOR = new bbf();
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    private int e;

    public zzpu(int i, int i2, int i3, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    zzpu(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzpu zzpuVar = (zzpu) obj;
        return this.a == zzpuVar.a && this.b == zzpuVar.b && this.c == zzpuVar.c && Arrays.equals(this.d, zzpuVar.d);
    }

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        boolean z = this.d != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = ((((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d != null ? 1 : 0);
        if (this.d != null) {
            parcel.writeByteArray(this.d);
        }
    }
}
