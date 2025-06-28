package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzmd implements Parcelable {
    public static final Parcelable.Creator<zzmd> CREATOR = new bai();
    private final zza[] a;

    /* compiled from: source */
    public interface zza extends Parcelable {
    }

    public zzmd(List<? extends zza> list) {
        this.a = new zza[list.size()];
        list.toArray(this.a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    zzmd(Parcel parcel) {
        this.a = new zza[parcel.readInt()];
        for (int i = 0; i < this.a.length; i++) {
            this.a[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
        }
    }

    public final int a() {
        return this.a.length;
    }

    public final zza a(int i) {
        return this.a[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((zzmd) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (zza zzaVar : this.a) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }
}
