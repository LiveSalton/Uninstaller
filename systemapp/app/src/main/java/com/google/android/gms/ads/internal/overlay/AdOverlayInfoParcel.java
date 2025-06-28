package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzva;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();

    @SafeParcelable.Field
    public final zzb a;

    @SafeParcelable.Field
    public final zzva b;

    @SafeParcelable.Field
    public final zzp c;

    @SafeParcelable.Field
    public final zzbdv d;

    @SafeParcelable.Field
    public final zzaha e;

    @SafeParcelable.Field
    public final String f;

    @SafeParcelable.Field
    public final boolean g;

    @SafeParcelable.Field
    public final String h;

    @SafeParcelable.Field
    public final zzu i;

    @SafeParcelable.Field
    public final int j;

    @SafeParcelable.Field
    public final int k;

    @SafeParcelable.Field
    public final String l;

    @SafeParcelable.Field
    public final zzazh m;

    @SafeParcelable.Field
    public final String n;

    @SafeParcelable.Field
    public final zzi o;

    @SafeParcelable.Field
    public final zzagy p;

    public static void a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzva zzvaVar, zzp zzpVar, zzu zzuVar, zzbdv zzbdvVar, int i, zzazh zzazhVar, String str, zzi zziVar, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = zzpVar;
        this.d = zzbdvVar;
        this.p = null;
        this.e = null;
        this.f = str2;
        this.g = false;
        this.h = str3;
        this.i = null;
        this.j = i;
        this.k = 1;
        this.l = null;
        this.m = zzazhVar;
        this.n = str;
        this.o = zziVar;
    }

    public AdOverlayInfoParcel(zzva zzvaVar, zzp zzpVar, zzu zzuVar, zzbdv zzbdvVar, boolean z, int i, zzazh zzazhVar) {
        this.a = null;
        this.b = zzvaVar;
        this.c = zzpVar;
        this.d = zzbdvVar;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = z;
        this.h = null;
        this.i = zzuVar;
        this.j = i;
        this.k = 2;
        this.l = null;
        this.m = zzazhVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzva zzvaVar, zzp zzpVar, zzagy zzagyVar, zzaha zzahaVar, zzu zzuVar, zzbdv zzbdvVar, boolean z, int i, String str, zzazh zzazhVar) {
        this.a = null;
        this.b = zzvaVar;
        this.c = zzpVar;
        this.d = zzbdvVar;
        this.p = zzagyVar;
        this.e = zzahaVar;
        this.f = null;
        this.g = z;
        this.h = null;
        this.i = zzuVar;
        this.j = i;
        this.k = 3;
        this.l = str;
        this.m = zzazhVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzva zzvaVar, zzp zzpVar, zzagy zzagyVar, zzaha zzahaVar, zzu zzuVar, zzbdv zzbdvVar, boolean z, int i, String str, String str2, zzazh zzazhVar) {
        this.a = null;
        this.b = zzvaVar;
        this.c = zzpVar;
        this.d = zzbdvVar;
        this.p = zzagyVar;
        this.e = zzahaVar;
        this.f = str2;
        this.g = z;
        this.h = str;
        this.i = zzuVar;
        this.j = i;
        this.k = 3;
        this.l = null;
        this.m = zzazhVar;
        this.n = null;
        this.o = null;
    }

    public AdOverlayInfoParcel(zzb zzbVar, zzva zzvaVar, zzp zzpVar, zzu zzuVar, zzazh zzazhVar) {
        this.a = zzbVar;
        this.b = zzvaVar;
        this.c = zzpVar;
        this.d = null;
        this.p = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = zzuVar;
        this.j = -1;
        this.k = 4;
        this.l = null;
        this.m = zzazhVar;
        this.n = null;
        this.o = null;
    }

    @SafeParcelable.Constructor
    AdOverlayInfoParcel(@SafeParcelable.Param zzb zzbVar, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param IBinder iBinder2, @SafeParcelable.Param IBinder iBinder3, @SafeParcelable.Param IBinder iBinder4, @SafeParcelable.Param String str, @SafeParcelable.Param boolean z, @SafeParcelable.Param String str2, @SafeParcelable.Param IBinder iBinder5, @SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param String str3, @SafeParcelable.Param zzazh zzazhVar, @SafeParcelable.Param String str4, @SafeParcelable.Param zzi zziVar, @SafeParcelable.Param IBinder iBinder6) {
        this.a = zzbVar;
        this.b = (zzva) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder));
        this.c = (zzp) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder2));
        this.d = (zzbdv) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder3));
        this.p = (zzagy) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder6));
        this.e = (zzaha) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder4));
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = (zzu) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder5));
        this.j = i;
        this.k = i2;
        this.l = str3;
        this.m = zzazhVar;
        this.n = str4;
        this.o = zziVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, (Parcelable) this.a, i, false);
        SafeParcelWriter.a(parcel, 3, ObjectWrapper.a(this.b).asBinder(), false);
        SafeParcelWriter.a(parcel, 4, ObjectWrapper.a(this.c).asBinder(), false);
        SafeParcelWriter.a(parcel, 5, ObjectWrapper.a(this.d).asBinder(), false);
        SafeParcelWriter.a(parcel, 6, ObjectWrapper.a(this.e).asBinder(), false);
        SafeParcelWriter.a(parcel, 7, this.f, false);
        SafeParcelWriter.a(parcel, 8, this.g);
        SafeParcelWriter.a(parcel, 9, this.h, false);
        SafeParcelWriter.a(parcel, 10, ObjectWrapper.a(this.i).asBinder(), false);
        SafeParcelWriter.a(parcel, 11, this.j);
        SafeParcelWriter.a(parcel, 12, this.k);
        SafeParcelWriter.a(parcel, 13, this.l, false);
        SafeParcelWriter.a(parcel, 14, (Parcelable) this.m, i, false);
        SafeParcelWriter.a(parcel, 16, this.n, false);
        SafeParcelWriter.a(parcel, 17, (Parcelable) this.o, i, false);
        SafeParcelWriter.a(parcel, 18, ObjectWrapper.a(this.p).asBinder(), false);
        SafeParcelWriter.a(parcel, a);
    }
}
