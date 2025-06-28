package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzta extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzta> CREATOR = new zztd();

    @GuardedBy("this")
    @SafeParcelable.Field
    private ParcelFileDescriptor a;

    @GuardedBy("this")
    @SafeParcelable.Field
    private final boolean b;

    @GuardedBy("this")
    @SafeParcelable.Field
    private final boolean c;

    @GuardedBy("this")
    @SafeParcelable.Field
    private final long d;

    @GuardedBy("this")
    @SafeParcelable.Field
    private final boolean e;

    public zzta() {
        this(null, false, false, 0L, false);
    }

    @SafeParcelable.Constructor
    public zzta(@SafeParcelable.Param ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param boolean z, @SafeParcelable.Param boolean z2, @SafeParcelable.Param long j, @SafeParcelable.Param boolean z3) {
        this.a = parcelFileDescriptor;
        this.b = z;
        this.c = z2;
        this.d = j;
        this.e = z3;
    }

    public final synchronized boolean a() {
        return this.a != null;
    }

    public final synchronized InputStream b() {
        if (this.a == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.a);
        this.a = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor g() {
        return this.a;
    }

    public final synchronized boolean c() {
        return this.b;
    }

    public final synchronized boolean d() {
        return this.c;
    }

    public final synchronized long e() {
        return this.d;
    }

    public final synchronized boolean f() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) g(), i, false);
        SafeParcelWriter.a(parcel, 3, c());
        SafeParcelWriter.a(parcel, 4, d());
        SafeParcelWriter.a(parcel, 5, e());
        SafeParcelWriter.a(parcel, 6, f());
        SafeParcelWriter.a(parcel, a);
    }
}
