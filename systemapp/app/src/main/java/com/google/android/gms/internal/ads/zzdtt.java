package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzdtt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtt> CREATOR = new zzdtw();

    @SafeParcelable.VersionField
    private final int a;

    @SafeParcelable.Field
    private zzcf.zza b = null;
    private byte[] c;

    @SafeParcelable.Constructor
    zzdtt(@SafeParcelable.Param int i, @SafeParcelable.Param byte[] bArr) {
        this.a = i;
        this.c = bArr;
        b();
    }

    public final zzcf.zza a() {
        if (!(this.b != null)) {
            try {
                this.b = zzcf.zza.a(this.c, zzeju.b());
                this.c = null;
            } catch (zzeks e) {
                throw new IllegalStateException(e);
            }
        }
        b();
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        byte[] l;
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        if (this.c != null) {
            l = this.c;
        } else {
            l = this.b.l();
        }
        SafeParcelWriter.a(parcel, 2, l, false);
        SafeParcelWriter.a(parcel, a);
    }

    private final void b() {
        if (this.b != null || this.c == null) {
            if (this.b == null || this.c != null) {
                if (this.b != null && this.c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.b == null && this.c == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }
}
