package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzmn extends zzmk {
    public static final Parcelable.Creator<zzmn> CREATOR = new bal();
    private final String a;
    private final String b;

    public zzmn(String str, String str2, String str3) {
        super(str);
        this.a = null;
        this.b = str3;
    }

    zzmn(Parcel parcel) {
        super(parcel.readString());
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
        zzmn zzmnVar = (zzmn) obj;
        return this.c.equals(zzmnVar.c) && zzpt.a(this.a, zzmnVar.a) && zzpt.a(this.b, zzmnVar.b);
    }

    public final int hashCode() {
        return ((((527 + this.c.hashCode()) * 31) + (this.a != null ? this.a.hashCode() : 0)) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
