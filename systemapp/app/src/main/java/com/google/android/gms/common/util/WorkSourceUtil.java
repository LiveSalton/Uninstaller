package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.reflect.Method;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class WorkSourceUtil {
    private static final int a = Process.myUid();
    private static final Method b = a();
    private static final Method c = b();
    private static final Method d = c();
    private static final Method e = d();
    private static final Method f = e();
    private static final Method g = f();
    private static final Method h = g();

    private WorkSourceUtil() {
    }

    private static Method a() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method b() {
        if (PlatformVersion.d()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method c() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method d() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method e() {
        if (PlatformVersion.d()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method f() {
        if (PlatformVersion.k()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method g() {
        if (PlatformVersion.k()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }
}
