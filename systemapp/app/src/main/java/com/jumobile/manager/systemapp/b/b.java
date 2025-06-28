package com.jumobile.manager.systemapp.b;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    private static final String a = "b";
    private static String b;
    private static String c;

    public static String a() {
        if (b == null) {
            if (new File("/system/bin/app_process").exists()) {
                b = "/system/bin/";
            } else if (com.jumobile.manager.systemapp.h.a.b("app_process") && com.jumobile.manager.systemapp.h.a.b.size() > 0) {
                b = com.jumobile.manager.systemapp.h.a.b.get(0);
            }
        }
        return b;
    }

    public static String b() {
        if (c == null) {
            if (new File("/system/bin/sh").exists()) {
                c = "/system/bin/sh";
            } else if (com.jumobile.manager.systemapp.h.a.b("sh") && com.jumobile.manager.systemapp.h.a.b.size() > 0) {
                c = com.jumobile.manager.systemapp.h.a.b.get(0) + "/sh";
            }
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7, int r8, java.lang.String r9, long r10) {
        /*
            java.io.File r0 = r7.getFileStreamPath(r9)
            r1 = 0
            if (r0 == 0) goto L2e
            boolean r2 = r0.exists()
            if (r2 == 0) goto L2e
            boolean r2 = r0.isFile()
            if (r2 == 0) goto L2e
            java.lang.String r2 = r0.getAbsolutePath()
            long r2 = com.jumobile.manager.systemapp.util.f.c(r2)
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 != 0) goto L20
            goto L2f
        L20:
            java.lang.String r2 = r0.getAbsolutePath()
            long r3 = r0.length()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            com.jumobile.manager.systemapp.h.a.a(r2, r1, r3)
        L2e:
            r1 = 1
        L2f:
            if (r1 == 0) goto L45
            boolean r8 = com.jumobile.manager.systemapp.h.a.a(r7, r8, r9)
            if (r8 == 0) goto L43
            java.io.File r8 = r7.getFileStreamPath(r9)
            java.lang.String r8 = r8.getAbsolutePath()
            com.jumobile.manager.systemapp.util.f.a(r8, r10)
            goto L45
        L43:
            r7 = 0
            return r7
        L45:
            java.io.File r7 = r7.getFileStreamPath(r9)
            java.lang.String r7 = r7.getAbsolutePath()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumobile.manager.systemapp.b.b.a(android.content.Context, int, java.lang.String, long):java.lang.String");
    }

    public static int a(Context context, int i, String str, long j, String str2, ArrayList<String> arrayList, long j2) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return -1;
        }
        String a3 = a(context, i, str, j);
        if (TextUtils.isEmpty(a3)) {
            return -1;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return -1;
        }
        com.jumobile.manager.systemapp.h.a.a("export CLASSPATH=" + a3, 1000L);
        StringBuilder sb = new StringBuilder();
        sb.append("exec app_process '" + a2 + "' '" + str2 + "'");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(" '" + it.next() + "'");
        }
        try {
            for (String str3 : com.jumobile.manager.systemapp.h.a.b(b2 + " -c \"" + sb.toString() + "\"", j2)) {
                if (!TextUtils.isEmpty(str3) && str3.contains(arrayList.get(0))) {
                    String[] split = str3.split("=");
                    if (split.length == 2) {
                        return Integer.valueOf(split[1]).intValue();
                    }
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
