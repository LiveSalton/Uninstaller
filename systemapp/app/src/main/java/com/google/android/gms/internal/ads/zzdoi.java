package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzas;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdoi {
    public static zzve a(zzdok zzdokVar, zzve zzveVar) {
        if (zzdokVar.equals(zzdok.MEDIATION_SHOW_ERROR)) {
            if (((Integer) zzwq.e().a(zzabf.ew)).intValue() > 0) {
                return zzveVar;
            }
        }
        return a(zzdokVar, null, zzveVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzve a(zzdok zzdokVar, String str, zzve zzveVar) {
        int i;
        if (str == null) {
            switch (zzdokVar) {
                case INVALID_REQUEST:
                    str = "Invalid request.";
                    break;
                case INVALID_AD_UNIT_ID:
                    str = "Invalid request: Invalid ad unit ID.";
                    break;
                case INVALID_AD_SIZE:
                    str = "Invalid request: Invalid ad size.";
                    break;
                case NETWORK_ERROR:
                    str = "Network error.";
                    break;
                case NO_FILL:
                    str = "No fill.";
                    break;
                case APP_ID_MISSING:
                    str = "App ID missing.";
                    break;
                case MEDIATION_SHOW_ERROR:
                    str = "A mediation adapter failed to show the ad.";
                    break;
                case NOT_READY:
                    str = "The ad is not ready.";
                    break;
                case AD_REUSED:
                    str = "The ad has already been shown.";
                    break;
                case APP_NOT_FOREGROUND:
                    str = "The ad can not be shown when app is not in foreground.";
                    break;
                case INTERNAL_SHOW_ERROR:
                default:
                    str = "Internal error.";
                    break;
                case MEDIATION_NO_FILL:
                    if (((Integer) zzwq.e().a(zzabf.eA)).intValue() > 0) {
                        str = "No fill.";
                        break;
                    } else {
                        str = "The mediation adapter did not return an ad.";
                        break;
                    }
            }
        }
        String str2 = str;
        int i2 = 2;
        switch (zzdokVar) {
            case INVALID_REQUEST:
            case INVALID_AD_UNIT_ID:
            case INVALID_AD_SIZE:
            case AD_REUSED:
                i2 = 1;
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            case NETWORK_ERROR:
            case NOT_READY:
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            case NO_FILL:
            case APP_NOT_FOREGROUND:
                i2 = 3;
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            case APP_ID_MISSING:
                i = 8;
                i2 = i;
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            case MEDIATION_SHOW_ERROR:
                i = 4;
                i2 = i;
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            case INTERNAL_SHOW_ERROR:
            case INTERNAL_ERROR:
                i2 = 0;
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            case MEDIATION_NO_FILL:
                if (((Integer) zzwq.e().a(zzabf.eA)).intValue() <= 0) {
                    i = 9;
                    i2 = i;
                    return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
                }
                i2 = 3;
                return new zzve(i2, str2, "com.google.android.gms.ads", zzveVar, null);
            default:
                String valueOf = String.valueOf(zzdokVar);
                StringBuilder sb = new StringBuilder(18 + String.valueOf(valueOf).length());
                sb.append("Unknown SdkError: ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
        }
    }

    public static zzve a(Throwable th) {
        if (th instanceof zzcrd) {
            zzcrd zzcrdVar = (zzcrd) th;
            return a(zzcrdVar.a(), zzcrdVar.b());
        }
        if (th instanceof zzcme) {
            if (th.getMessage() == null) {
                return a(((zzcme) th).a(), null, null);
            }
            return a(((zzcme) th).a(), th.getMessage(), null);
        }
        if (th instanceof zzas) {
            zzas zzasVar = (zzas) th;
            return new zzve(zzasVar.a(), zzdwc.a(zzasVar.getMessage()), "com.google.android.gms.ads", null, null);
        }
        return a(zzdok.INTERNAL_ERROR, null, null);
    }

    public static zzve a(Throwable th, zzcrg zzcrgVar) {
        zzve a = a(th);
        if ((a.a == 3 || a.a == 0) && a.d != null && !a.d.c.equals("com.google.android.gms.ads")) {
            a.d = null;
        }
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue() && zzcrgVar != null) {
            a.e = zzcrgVar.a();
        }
        return a;
    }
}
