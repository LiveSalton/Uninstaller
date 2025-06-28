package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import javax.annotation.CheckReturnValue;

/* compiled from: source */
@CheckReturnValue
/* loaded from: classes.dex */
final class a {
    private static final Object a = new Object();
    private static Context b;

    static synchronized void a(Context context) {
        synchronized (a.class) {
            if (b != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                b = context.getApplicationContext();
            }
        }
    }
}
