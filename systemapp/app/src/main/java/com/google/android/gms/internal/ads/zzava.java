package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzava extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzava> CREATOR = new zzavd();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final int b;

    public zzava(RewardItem rewardItem) {
        this(rewardItem.a(), rewardItem.b());
    }

    @SafeParcelable.Constructor
    public zzava(@SafeParcelable.Param String str, @SafeParcelable.Param int i) {
        this.a = str;
        this.b = i;
    }

    public static zzava a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzava(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, 3, this.b);
        SafeParcelWriter.a(parcel, a);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzava)) {
            return false;
        }
        zzava zzavaVar = (zzava) obj;
        return Objects.a(this.a, zzavaVar.a) && Objects.a(Integer.valueOf(this.b), Integer.valueOf(zzavaVar.b));
    }

    public final int hashCode() {
        return Objects.a(this.a, Integer.valueOf(this.b));
    }
}
