package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmk {
    public static PackageInfo a(Context context, ApplicationInfo applicationInfo) {
        try {
            return Wrappers.a(context).b(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
