package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class PackageManagerWrapper {
    private final Context a;

    public PackageManagerWrapper(Context context) {
        this.a = context;
    }

    @KeepForSdk
    public ApplicationInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    public PackageInfo b(String str, int i) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }

    @KeepForSdk
    public int a(String str) {
        return this.a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int a(String str, String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public boolean a() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.a(this.a);
        }
        if (!PlatformVersion.j() || (nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.a.getPackageManager().isInstantApp(nameForUid);
    }
}
