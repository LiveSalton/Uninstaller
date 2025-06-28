package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzail extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzail> CREATOR = new zzaik();

    @SafeParcelable.Field
    private final String a;

    @SafeParcelable.Field
    private final String[] b;

    @SafeParcelable.Field
    private final String[] c;

    @SafeParcelable.Constructor
    zzail(@SafeParcelable.Param String str, @SafeParcelable.Param String[] strArr, @SafeParcelable.Param String[] strArr2) {
        this.a = str;
        this.b = strArr;
        this.c = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        SafeParcelWriter.a(parcel, 2, this.b, false);
        SafeParcelWriter.a(parcel, 3, this.c, false);
        SafeParcelWriter.a(parcel, a);
    }

    public static zzail a(zzaa<?> zzaaVar) throws zzl {
        Map<String, String> b = zzaaVar.b();
        int size = b.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : b.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzail(zzaaVar.e(), strArr, strArr2);
    }
}
