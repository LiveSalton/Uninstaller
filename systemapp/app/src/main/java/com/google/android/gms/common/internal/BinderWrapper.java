package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

/* compiled from: source */
@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new a();
    private IBinder a;

    public BinderWrapper() {
        this.a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    private BinderWrapper(Parcel parcel) {
        this.a = null;
        this.a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.a);
    }

    /* synthetic */ BinderWrapper(Parcel parcel, a aVar) {
        this(parcel);
    }
}
