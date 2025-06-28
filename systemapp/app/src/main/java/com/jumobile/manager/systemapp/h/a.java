package com.jumobile.manager.systemapp.h;

import android.content.Context;
import android.util.Log;
import com.jumobile.manager.systemapp.h.a.b;
import com.jumobile.manager.systemapp.h.c.c;
import com.jumobile.manager.systemapp.h.d.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a {
    public static boolean a = false;
    public static List<String> b = new ArrayList();
    public static String c = null;
    public static boolean d = true;
    private static d e;

    public static void a(d dVar) {
        e = dVar;
    }

    private static final d d() {
        if (e == null) {
            d.a();
            return e;
        }
        return e;
    }

    public static void a(boolean z) throws IOException {
        if (z) {
            c.c();
        } else {
            c.d();
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2, long j) {
        return d().a(str, str2, z, z2, j);
    }

    public static boolean a(String str, boolean z, long j) {
        return d().a(str, z, j);
    }

    public static boolean a(String str) {
        return d().e(str);
    }

    public static boolean b(String str) {
        return d().f(str);
    }

    public static b c(String str) {
        return d().g(str);
    }

    public static ArrayList<com.jumobile.manager.systemapp.h.a.a> a() throws Exception {
        return d().d();
    }

    public static String d(String str) throws Exception {
        return d().h(str);
    }

    public static Set<String> b() throws Exception {
        return d().e();
    }

    public static c a(boolean z, int i, int i2) throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        if (z) {
            return c.a(i);
        }
        return c.b(i);
    }

    public static c a(boolean z, int i) throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        return a(z, i, 3);
    }

    public static c b(boolean z) throws IOException, TimeoutException, com.jumobile.manager.systemapp.h.b.a {
        return a(z, 25000);
    }

    public static boolean a(Context context, int i, String str, String str2) {
        return d().a(context, i, str, str2);
    }

    public static boolean a(Context context, int i, String str) {
        return a(context, i, str, "700");
    }

    public static boolean c() {
        return d().c();
    }

    public static boolean a(String str, String str2) {
        return new com.jumobile.manager.systemapp.h.d.c().a(str, str2);
    }

    public static void e(String str) {
        a((String) null, str, 3, (Exception) null);
    }

    public static void b(String str, String str2) {
        a(str, str2, 3, (Exception) null);
    }

    public static void a(String str, int i, Exception exc) {
        a((String) null, str, i, exc);
    }

    public static void a(String str, String str2, int i, Exception exc) {
        if (str2 == null || str2.equals("") || !a) {
            return;
        }
        if (str == null) {
            str = "RootTools v3.0";
        }
        switch (i) {
            case 1:
                Log.v(str, str2);
                break;
            case 2:
                Log.e(str, str2, exc);
                break;
            case 3:
                Log.d(str, str2);
                break;
        }
    }

    public static void a(String str, long j) {
        d().a(str, j);
    }

    public static List<String> b(String str, long j) {
        return d().b(str, j);
    }
}
