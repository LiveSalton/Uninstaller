package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzasl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasl> CREATOR = new zzask();

    @SafeParcelable.Field
    public final View a;

    @SafeParcelable.Field
    public final Map<String, WeakReference<View>> b;

    @SafeParcelable.Constructor
    public zzasl(@SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param IBinder iBinder2) {
        this.a = (View) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder));
        this.b = (Map) ObjectWrapper.a(IObjectWrapper.Stub.a(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, ObjectWrapper.a(this.a).asBinder(), false);
        SafeParcelWriter.a(parcel, 2, ObjectWrapper.a(this.b).asBinder(), false);
        SafeParcelWriter.a(parcel, a);
    }
}
