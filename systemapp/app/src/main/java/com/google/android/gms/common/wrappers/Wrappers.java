package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class Wrappers {
    private static Wrappers b = new Wrappers();
    private PackageManagerWrapper a = null;

    @VisibleForTesting
    private final synchronized PackageManagerWrapper b(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new PackageManagerWrapper(context);
        }
        return this.a;
    }

    @KeepForSdk
    public static PackageManagerWrapper a(Context context) {
        return b.b(context);
    }
}
