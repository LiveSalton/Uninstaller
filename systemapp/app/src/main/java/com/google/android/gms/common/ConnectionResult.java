package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.multidex.BuildConfig;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    @SafeParcelable.VersionField
    private final int b;

    @SafeParcelable.Field
    private final int c;

    @SafeParcelable.Field
    private final PendingIntent d;

    @SafeParcelable.Field
    private final String e;

    @ShowFirstParty
    @KeepForSdk
    public static final ConnectionResult a = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zza();

    @SafeParcelable.Constructor
    ConnectionResult(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param PendingIntent pendingIntent, @SafeParcelable.Param String str) {
        this.b = i;
        this.c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    public final boolean a() {
        return this.c == 0;
    }

    public final int b() {
        return this.c;
    }

    public final PendingIntent c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    static String a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case BuildConfig.VERSION_CODE /* -1 */:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.c == connectionResult.c && Objects.a(this.d, connectionResult.d) && Objects.a(this.e, connectionResult.e);
    }

    public final int hashCode() {
        return Objects.a(Integer.valueOf(this.c), this.d, this.e);
    }

    public final String toString() {
        return Objects.a(this).a("statusCode", a(this.c)).a("resolution", this.d).a("message", this.e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.b);
        SafeParcelWriter.a(parcel, 2, b());
        SafeParcelWriter.a(parcel, 3, (Parcelable) c(), i, false);
        SafeParcelWriter.a(parcel, 4, d(), false);
        SafeParcelWriter.a(parcel, a2);
    }
}
