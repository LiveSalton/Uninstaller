package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzeq {
    private static volatile boolean a = false;
    private static boolean b = true;
    private static volatile zzeq d;
    private final Map<Object, zzfd.zzf<?, ?>> f;
    private static final Class<?> c = b();
    private static final zzeq e = new zzeq(true);

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzeq a() {
        zzeq zzeqVar = d;
        if (zzeqVar == null) {
            synchronized (zzeq.class) {
                zzeqVar = d;
                if (zzeqVar == null) {
                    zzeqVar = e;
                    d = zzeqVar;
                }
            }
        }
        return zzeqVar;
    }

    zzeq() {
        this.f = new HashMap();
    }

    private zzeq(boolean z) {
        this.f = Collections.emptyMap();
    }
}
