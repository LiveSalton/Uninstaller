package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzawp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawp> CREATOR = new zzawo();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final String b;

    @SafeParcelable.Field
    public final boolean c;

    @SafeParcelable.Field
    public final boolean d;

    @SafeParcelable.Field
    public final List<String> e;

    @SafeParcelable.Field
    public final boolean f;

    @SafeParcelable.Field
    public final boolean g;

    @SafeParcelable.Field
    public final List<String> h;

    @SafeParcelable.Constructor
    public zzawp(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param boolean z, @SafeParcelable.Param boolean z2, @SafeParcelable.Param List<String> list, @SafeParcelable.Param boolean z3, @SafeParcelable.Param boolean z4, @SafeParcelable.Param List<String> list2) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = list;
        this.f = z3;
        this.g = z4;
        this.h = list2 == null ? new ArrayList<>() : list2;
    }

    public static zzawp a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzawp(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), com.google.android.gms.ads.internal.util.zzbk.a(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), com.google.android.gms.ads.internal.util.zzbk.a(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, 3, this.b, false);
        SafeParcelWriter.a(parcel, 4, this.c);
        SafeParcelWriter.a(parcel, 5, this.d);
        SafeParcelWriter.b(parcel, 6, this.e, false);
        SafeParcelWriter.a(parcel, 7, this.f);
        SafeParcelWriter.a(parcel, 8, this.g);
        SafeParcelWriter.b(parcel, 9, this.h, false);
        SafeParcelWriter.a(parcel, a);
    }
}
