package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzjo implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzjo> CREATOR = new ayv();
    public final int a;
    private final zza[] b;
    private int c;

    public zzjo(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* compiled from: source */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new ayw();
        public final boolean a;
        private int b;
        private final UUID c;
        private final String d;
        private final byte[] e;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            this.c = (UUID) zzpc.a(uuid);
            this.d = (String) zzpc.a(str);
            this.e = (byte[]) zzpc.a(bArr);
            this.a = false;
        }

        zza(Parcel parcel) {
            this.c = new UUID(parcel.readLong(), parcel.readLong());
            this.d = parcel.readString();
            this.e = parcel.createByteArray();
            this.a = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return this.d.equals(zzaVar.d) && zzpt.a(this.c, zzaVar.c) && Arrays.equals(this.e, zzaVar.e);
        }

        public final int hashCode() {
            if (this.b == 0) {
                this.b = (((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + Arrays.hashCode(this.e);
            }
            return this.b;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.c.getMostSignificantBits());
            parcel.writeLong(this.c.getLeastSignificantBits());
            parcel.writeString(this.d);
            parcel.writeByteArray(this.e);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        }
    }

    public zzjo(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    private zzjo(boolean z, zza... zzaVarArr) {
        zzaVarArr = z ? (zza[]) zzaVarArr.clone() : zzaVarArr;
        Arrays.sort(zzaVarArr, this);
        for (int i = 1; i < zzaVarArr.length; i++) {
            if (zzaVarArr[i - 1].c.equals(zzaVarArr[i].c)) {
                String valueOf = String.valueOf(zzaVarArr[i].c);
                StringBuilder sb = new StringBuilder(25 + String.valueOf(valueOf).length());
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.b = zzaVarArr;
        this.a = zzaVarArr.length;
    }

    zzjo(Parcel parcel) {
        this.b = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.a = this.b.length;
    }

    public final zza a(int i) {
        return this.b[i];
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((zzjo) obj).b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.b, 0);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        if (zzhb.b.equals(zzaVar3.c)) {
            return zzhb.b.equals(zzaVar4.c) ? 0 : 1;
        }
        return zzaVar3.c.compareTo(zzaVar4.c);
    }
}
