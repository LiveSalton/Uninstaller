package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzve extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzve> CREATOR = new zzvd();

    @SafeParcelable.Field
    public final int a;

    @SafeParcelable.Field
    public final String b;

    @SafeParcelable.Field
    public final String c;

    @SafeParcelable.Field
    public zzve d;

    @SafeParcelable.Field
    public IBinder e;

    @SafeParcelable.Constructor
    public zzve(@SafeParcelable.Param int i, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param zzve zzveVar, @SafeParcelable.Param IBinder iBinder) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = zzveVar;
        this.e = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, 4, (Parcelable) this.d, i, false);
        SafeParcelWriter.a(parcel, 5, this.e, false);
        SafeParcelWriter.a(parcel, a);
    }

    public final AdError a() {
        return new AdError(this.a, this.b, this.c, this.d == null ? null : new AdError(this.d.a, this.d.b, this.d.c));
    }

    public final LoadAdError b() {
        zzyn zzynVar = null;
        AdError adError = this.d == null ? null : new AdError(this.d.a, this.d.b, this.d.c);
        int i = this.a;
        String str = this.b;
        String str2 = this.c;
        IBinder iBinder = this.e;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzyn) {
                zzynVar = (zzyn) queryLocalInterface;
            } else {
                zzynVar = new zzyp(iBinder);
            }
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.a(zzynVar));
    }
}
