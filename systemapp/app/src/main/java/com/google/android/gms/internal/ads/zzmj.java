package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzmj extends zzmk {
    public static final Parcelable.Creator<zzmj> CREATOR = new bak();
    public final String a;
    public final String b;
    private final String d;

    public zzmj(String str, String str2, String str3) {
        super("COMM");
        this.d = str;
        this.a = str2;
        this.b = str3;
    }

    zzmj(Parcel parcel) {
        super("COMM");
        this.d = parcel.readString();
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzmj zzmjVar = (zzmj) obj;
        return zzpt.a(this.a, zzmjVar.a) && zzpt.a(this.d, zzmjVar.d) && zzpt.a(this.b, zzmjVar.b);
    }

    public final int hashCode() {
        return ((((527 + (this.d != null ? this.d.hashCode() : 0)) * 31) + (this.a != null ? this.a.hashCode() : 0)) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.b);
    }
}
