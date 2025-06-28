package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzaag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaag> CREATOR = new zzaaj();

    @SafeParcelable.Field
    public final String a;

    public zzaag(SearchAdRequest searchAdRequest) {
        this.a = searchAdRequest.a();
    }

    @SafeParcelable.Constructor
    zzaag(@SafeParcelable.Param String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 15, this.a, false);
        SafeParcelWriter.a(parcel, a);
    }
}
