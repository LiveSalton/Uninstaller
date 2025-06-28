package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzhp implements Parcelable {
    public static final Parcelable.Creator<zzhp> CREATOR = new ayb();
    private int A;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List<byte[]> f;
    public final zzjo g;
    public final int h;
    public final int i;
    public final float j;
    public final int k;
    public final float l;
    public final int m;
    public final int n;
    public final int o;
    public final long p;
    public final int q;
    public final String r;
    private final String s;
    private final zzmd t;
    private final int u;
    private final byte[] v;
    private final zzpu w;
    private final int x;
    private final int y;
    private final int z;

    public static zzhp a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzpu zzpuVar, zzjo zzjoVar) {
        return new zzhp(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzpuVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzjoVar, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static zzhp a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzjo zzjoVar, int i5, String str4) {
        return a(str, str2, null, -1, -1, i3, i4, -1, null, zzjoVar, 0, str4);
    }

    public static zzhp a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzjo zzjoVar, int i6, String str4) {
        return new zzhp(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzjoVar, null);
    }

    public static zzhp a(String str, String str2, String str3, int i, int i2, String str4, zzjo zzjoVar) {
        return a(str, str2, null, -1, i2, str4, -1, zzjoVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzhp a(String str, String str2, String str3, int i, int i2, String str4, int i3, zzjo zzjoVar, long j, List<byte[]> list) {
        return new zzhp(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzjoVar, null);
    }

    public static zzhp a(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzjo zzjoVar) {
        return new zzhp(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzjoVar, null);
    }

    public static zzhp a(String str, String str2, long j) {
        return new zzhp(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzhp a(String str, String str2, String str3, int i, zzjo zzjoVar) {
        return new zzhp(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, zzjoVar, null);
    }

    private zzhp(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzpu zzpuVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzjo zzjoVar, zzmd zzmdVar) {
        this.s = str;
        this.c = str2;
        this.d = str3;
        this.b = str4;
        this.a = i;
        this.e = i2;
        this.h = i3;
        this.i = i4;
        this.j = f;
        this.k = i5;
        this.l = f2;
        this.v = bArr;
        this.u = i6;
        this.w = zzpuVar;
        this.m = i7;
        this.n = i8;
        this.o = i9;
        this.x = i10;
        this.y = i11;
        this.q = i12;
        this.r = str5;
        this.z = i13;
        this.p = j;
        this.f = list == null ? Collections.emptyList() : list;
        this.g = zzjoVar;
        this.t = zzmdVar;
    }

    zzhp(Parcel parcel) {
        this.s = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.b = parcel.readString();
        this.a = parcel.readInt();
        this.e = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readFloat();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.v = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.u = parcel.readInt();
        this.w = (zzpu) parcel.readParcelable(zzpu.class.getClassLoader());
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readString();
        this.z = parcel.readInt();
        this.p = parcel.readLong();
        int readInt = parcel.readInt();
        this.f = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f.add(parcel.createByteArray());
        }
        this.g = (zzjo) parcel.readParcelable(zzjo.class.getClassLoader());
        this.t = (zzmd) parcel.readParcelable(zzmd.class.getClassLoader());
    }

    public final zzhp a(int i) {
        return new zzhp(this.s, this.c, this.d, this.b, this.a, i, this.h, this.i, this.j, this.k, this.l, this.v, this.u, this.w, this.m, this.n, this.o, this.x, this.y, this.q, this.r, this.z, this.p, this.f, this.g, this.t);
    }

    public final zzhp a(long j) {
        return new zzhp(this.s, this.c, this.d, this.b, this.a, this.e, this.h, this.i, this.j, this.k, this.l, this.v, this.u, this.w, this.m, this.n, this.o, this.x, this.y, this.q, this.r, this.z, j, this.f, this.g, this.t);
    }

    public final zzhp a(int i, int i2) {
        return new zzhp(this.s, this.c, this.d, this.b, this.a, this.e, this.h, this.i, this.j, this.k, this.l, this.v, this.u, this.w, this.m, this.n, this.o, i, i2, this.q, this.r, this.z, this.p, this.f, this.g, this.t);
    }

    public final zzhp a(zzjo zzjoVar) {
        return new zzhp(this.s, this.c, this.d, this.b, this.a, this.e, this.h, this.i, this.j, this.k, this.l, this.v, this.u, this.w, this.m, this.n, this.o, this.x, this.y, this.q, this.r, this.z, this.p, this.f, zzjoVar, this.t);
    }

    public final zzhp a(zzmd zzmdVar) {
        return new zzhp(this.s, this.c, this.d, this.b, this.a, this.e, this.h, this.i, this.j, this.k, this.l, this.v, this.u, this.w, this.m, this.n, this.o, this.x, this.y, this.q, this.r, this.z, this.p, this.f, this.g, zzmdVar);
    }

    public final int a() {
        if (this.h == -1 || this.i == -1) {
            return -1;
        }
        return this.h * this.i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.d);
        String str = this.r;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        a(mediaFormat, "max-input-size", this.e);
        a(mediaFormat, "width", this.h);
        a(mediaFormat, "height", this.i);
        float f = this.j;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        a(mediaFormat, "rotation-degrees", this.k);
        a(mediaFormat, "channel-count", this.m);
        a(mediaFormat, "sample-rate", this.n);
        a(mediaFormat, "encoder-delay", this.x);
        a(mediaFormat, "encoder-padding", this.y);
        for (int i = 0; i < this.f.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.f.get(i)));
        }
        zzpu zzpuVar = this.w;
        if (zzpuVar != null) {
            a(mediaFormat, "color-transfer", zzpuVar.c);
            a(mediaFormat, "color-standard", zzpuVar.a);
            a(mediaFormat, "color-range", zzpuVar.b);
            byte[] bArr = zzpuVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.s;
        String str2 = this.c;
        String str3 = this.d;
        int i = this.a;
        String str4 = this.r;
        int i2 = this.h;
        int i3 = this.i;
        float f = this.j;
        int i4 = this.m;
        int i5 = this.n;
        StringBuilder sb = new StringBuilder(100 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.A == 0) {
            this.A = ((((((((((((((((((((((((527 + (this.s == null ? 0 : this.s.hashCode())) * 31) + (this.c == null ? 0 : this.c.hashCode())) * 31) + (this.d == null ? 0 : this.d.hashCode())) * 31) + (this.b == null ? 0 : this.b.hashCode())) * 31) + this.a) * 31) + this.h) * 31) + this.i) * 31) + this.m) * 31) + this.n) * 31) + (this.r == null ? 0 : this.r.hashCode())) * 31) + this.z) * 31) + (this.g == null ? 0 : this.g.hashCode())) * 31) + (this.t != null ? this.t.hashCode() : 0);
        }
        return this.A;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzhp zzhpVar = (zzhp) obj;
        if (this.a != zzhpVar.a || this.e != zzhpVar.e || this.h != zzhpVar.h || this.i != zzhpVar.i || this.j != zzhpVar.j || this.k != zzhpVar.k || this.l != zzhpVar.l || this.u != zzhpVar.u || this.m != zzhpVar.m || this.n != zzhpVar.n || this.o != zzhpVar.o || this.x != zzhpVar.x || this.y != zzhpVar.y || this.p != zzhpVar.p || this.q != zzhpVar.q || !zzpt.a(this.s, zzhpVar.s) || !zzpt.a(this.r, zzhpVar.r) || this.z != zzhpVar.z || !zzpt.a(this.c, zzhpVar.c) || !zzpt.a(this.d, zzhpVar.d) || !zzpt.a(this.b, zzhpVar.b) || !zzpt.a(this.g, zzhpVar.g) || !zzpt.a(this.t, zzhpVar.t) || !zzpt.a(this.w, zzhpVar.w) || !Arrays.equals(this.v, zzhpVar.v) || this.f.size() != zzhpVar.f.size()) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!Arrays.equals(this.f.get(i), zzhpVar.f.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.s);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.b);
        parcel.writeInt(this.a);
        parcel.writeInt(this.e);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.v != null ? 1 : 0);
        if (this.v != null) {
            parcel.writeByteArray(this.v);
        }
        parcel.writeInt(this.u);
        parcel.writeParcelable(this.w, i);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.q);
        parcel.writeString(this.r);
        parcel.writeInt(this.z);
        parcel.writeLong(this.p);
        int size = this.f.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.f.get(i2));
        }
        parcel.writeParcelable(this.g, 0);
        parcel.writeParcelable(this.t, 0);
    }
}
