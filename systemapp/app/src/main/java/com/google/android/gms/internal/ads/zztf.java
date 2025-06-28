package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: source */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zztf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztf> CREATOR = new zzte();

    @SafeParcelable.Field
    public final String a;

    @SafeParcelable.Field
    public final boolean b;

    @SafeParcelable.Field
    public long c;

    @SafeParcelable.Field
    public String d;

    @SafeParcelable.Field
    public int e;

    @SafeParcelable.Field
    private final long f;

    @SafeParcelable.Field
    private final String g;

    @SafeParcelable.Field
    private final String h;

    @SafeParcelable.Field
    private final String i;

    @SafeParcelable.Field
    private final Bundle j;

    public static zztf a(String str) {
        return a(Uri.parse(str));
    }

    public static zztf a(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzd.e(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            zzp.e();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zztf(queryParameter, parseLong, host, str, str2, bundle, equals, 0L, "", 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzd.d("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @SafeParcelable.Constructor
    zztf(@SafeParcelable.Param String str, @SafeParcelable.Param long j, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param boolean z, @SafeParcelable.Param long j2, @SafeParcelable.Param String str5, @SafeParcelable.Param int i) {
        this.a = str;
        this.f = j;
        this.g = str2 == null ? "" : str2;
        this.h = str3 == null ? "" : str3;
        this.i = str4 == null ? "" : str4;
        this.j = bundle == null ? new Bundle() : bundle;
        this.b = z;
        this.c = j2;
        this.d = str5;
        this.e = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 2, this.a, false);
        SafeParcelWriter.a(parcel, 3, this.f);
        SafeParcelWriter.a(parcel, 4, this.g, false);
        SafeParcelWriter.a(parcel, 5, this.h, false);
        SafeParcelWriter.a(parcel, 6, this.i, false);
        SafeParcelWriter.a(parcel, 7, this.j, false);
        SafeParcelWriter.a(parcel, 8, this.b);
        SafeParcelWriter.a(parcel, 9, this.c);
        SafeParcelWriter.a(parcel, 10, this.d, false);
        SafeParcelWriter.a(parcel, 11, this.e);
        SafeParcelWriter.a(parcel, a);
    }
}
