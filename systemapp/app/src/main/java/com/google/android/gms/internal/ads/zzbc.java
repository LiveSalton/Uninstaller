package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbc {
    public static zzn a(zzy zzyVar) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzyVar.c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long a = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            z = false;
            j = 0;
            j2 = 0;
            for (String str3 : str2.split(",", 0)) {
                String trim = str3.trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
            }
            z2 = true;
        } else {
            z = false;
            z2 = false;
            j = 0;
            j2 = 0;
        }
        String str4 = map.get("Expires");
        long a2 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("Last-Modified");
        long a3 = str5 != null ? a(str5) : 0L;
        String str6 = map.get("ETag");
        if (z2) {
            j3 = currentTimeMillis + (j * 1000);
            if (!z) {
                j4 = (j2 * 1000) + j3;
            }
            j4 = j3;
        } else if (a <= 0 || a2 < a) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (a2 - a) + currentTimeMillis;
            j3 = j4;
        }
        zzn zznVar = new zzn();
        zznVar.a = zzyVar.b;
        zznVar.b = str6;
        zznVar.f = j3;
        zznVar.e = j4;
        zznVar.c = a;
        zznVar.d = a3;
        zznVar.g = map;
        zznVar.h = zzyVar.d;
        return zznVar;
    }

    private static long a(String str) {
        try {
            return b("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaq.a("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaq.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static String a(long j) {
        return b("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
