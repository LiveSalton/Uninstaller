package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzvp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvp> CREATOR = new zzvs();

    @SafeParcelable.Field
    public final int a;

    @SafeParcelable.Field
    public final int b;

    @SafeParcelable.Field
    public final String c;

    @SafeParcelable.Field
    public final long d;

    @SafeParcelable.Constructor
    public zzvp(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param String str, @SafeParcelable.Param long j) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a);
        SafeParcelWriter.a(parcel, 2, this.b);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, 4, this.d);
        SafeParcelWriter.a(parcel, a);
    }

    public static zzvp a(JSONObject jSONObject) throws JSONException {
        return new zzvp(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }
}
