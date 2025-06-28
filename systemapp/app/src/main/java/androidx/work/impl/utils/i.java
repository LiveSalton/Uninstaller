package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import java.util.HashMap;
import java.util.WeakHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class i {
    private static final String a = androidx.work.h.a("WakeLocks");
    private static final WeakHashMap<PowerManager.WakeLock, String> b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        synchronized (b) {
            b.put(newWakeLock, str2);
        }
        return newWakeLock;
    }

    public static void a() {
        HashMap hashMap = new HashMap();
        synchronized (b) {
            hashMap.putAll(b);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                androidx.work.h.a().d(a, String.format("WakeLock held for %s", hashMap.get(wakeLock)), new Throwable[0]);
            }
        }
    }
}
