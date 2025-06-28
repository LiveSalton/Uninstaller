package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzaq {
    public static boolean a = Log.isLoggable("Volley", 2);
    private static String b = "Volley";
    private static final String c = "com.google.android.gms.internal.ads.zzaq";

    public static void a(String str, Object... objArr) {
        if (a) {
            Log.v(b, d(str, objArr));
        }
    }

    /* compiled from: source */
    static class a {
        public static final boolean a = zzaq.a;
        private final List<ds> b = new ArrayList();
        private boolean c = false;

        a() {
        }

        public final synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new ds(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void a(String str) {
            this.c = true;
            long j = this.b.size() == 0 ? 0L : this.b.get(this.b.size() - 1).c - this.b.get(0).c;
            if (j <= 0) {
                return;
            }
            long j2 = this.b.get(0).c;
            zzaq.b("(%-4d ms) %s", Long.valueOf(j), str);
            for (ds dsVar : this.b) {
                long j3 = dsVar.c;
                zzaq.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(dsVar.b), dsVar.a);
                j2 = j3;
            }
        }

        protected final void finalize() throws Throwable {
            if (this.c) {
                return;
            }
            a("Request on the loose");
            zzaq.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(b, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(b, d(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(b, d(str, objArr), th);
    }

    private static String d(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (!stackTrace[i].getClassName().equals(c)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
