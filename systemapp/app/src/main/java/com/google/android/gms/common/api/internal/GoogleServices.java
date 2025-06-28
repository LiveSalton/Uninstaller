package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public final class GoogleServices {
    private static final Object a = new Object();

    @GuardedBy("sLock")
    private static GoogleServices b;
    private final String c;
    private final Status d;
    private final boolean e;
    private final boolean f;

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            r3 = resources.getInteger(identifier) != 0;
            this.f = !r3;
        } else {
            this.f = false;
        }
        this.e = r3;
        String a2 = zzs.a(context);
        a2 = a2 == null ? new StringResourceValueReader(context).a("google_app_id") : a2;
        if (TextUtils.isEmpty(a2)) {
            this.d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
        } else {
            this.c = a2;
            this.d = Status.a;
        }
    }

    @KeepForSdk
    public static Status a(Context context) {
        Status status;
        Preconditions.a(context, "Context must not be null.");
        synchronized (a) {
            if (b == null) {
                b = new GoogleServices(context);
            }
            status = b.d;
        }
        return status;
    }

    @KeepForSdk
    public static String a() {
        return a("getGoogleAppId").c;
    }

    @KeepForSdk
    private static GoogleServices a(String str) {
        GoogleServices googleServices;
        synchronized (a) {
            if (b == null) {
                StringBuilder sb = new StringBuilder(34 + String.valueOf(str).length());
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            googleServices = b;
        }
        return googleServices;
    }
}
