package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzagc;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxo;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();

    @SafeParcelable.Field
    private final boolean a;

    @SafeParcelable.Field
    private final zzxo b;

    @SafeParcelable.Field
    private final IBinder c;

    /* compiled from: source */
    public static final class Builder {
        private boolean a = false;
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param boolean z, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param IBinder iBinder2) {
        this.a = z;
        this.b = iBinder != null ? zzxn.a(iBinder) : null;
        this.c = iBinder2;
    }

    public final boolean a() {
        return this.a;
    }

    public final zzxo b() {
        return this.b;
    }

    public final zzagd c() {
        return zzagc.a(this.c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, a());
        SafeParcelWriter.a(parcel, 2, this.b == null ? null : this.b.asBinder(), false);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, a);
    }
}
