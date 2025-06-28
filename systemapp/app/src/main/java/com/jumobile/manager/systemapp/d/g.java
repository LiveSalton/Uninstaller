package com.jumobile.manager.systemapp.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import java.io.File;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class g extends c {
    public static int e = 1;
    public static int l = 2;
    public static int m = 3;
    private static final String o = "g";
    private static int p = 536870912;
    private static int q = 262144;
    private static int r = 2;
    private static int s = 0;
    private static int t = -1;
    private static int u = 2;
    private static boolean v = false;
    public int a;
    public ApplicationInfo b;
    public long c;
    public boolean d = false;
    int n = e;

    public g(ApplicationInfo applicationInfo) {
        this.b = applicationInfo;
    }

    static {
        try {
            Class<?> cls = Class.forName("android.content.pm.ApplicationInfo");
            p = cls.getField("FLAG_FORWARD_LOCK").getInt(cls);
            q = cls.getField("FLAG_EXTERNAL_STORAGE").getInt(cls);
            Class<?> cls2 = Class.forName("android.content.pm.PackageInfo");
            r = cls2.getField("INSTALL_LOCATION_PREFER_EXTERNAL").getInt(cls2);
            s = cls2.getField("INSTALL_LOCATION_AUTO").getInt(cls2);
            t = cls2.getField("INSTALL_LOCATION_UNSPECIFIED").getInt(cls2);
            Class<?> cls3 = Class.forName("com.android.internal.content.PackageHelper");
            u = cls3.getField("APP_INSTALL_EXTERNAL").getInt(cls3);
            Class<?> cls4 = Class.forName("android.app.ActivityThread");
            Class<?> cls5 = Class.forName("android.content.pm.IPackageManager");
            if (((Integer) cls5.getMethod("getInstallLocation", new Class[0]).invoke(cls4.getMethod("getPackageManager", new Class[0]).invoke(cls4.getClass(), new Object[0]), new Object[0])).intValue() == u) {
                v = true;
            }
        } catch (Exception unused) {
        }
    }

    public int a(Context context) {
        if (e == this.n) {
            this.n = m;
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "allow_move_all_apps_external", 0) == 1) {
                    this.n = l;
                    return this.n;
                }
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    Class<?> cls = Class.forName("android.os.Environment");
                    if (((Boolean) cls.getMethod("isExternalStorageEmulated", new Class[0]).invoke(cls.getClass(), new Object[0])).booleanValue()) {
                        return this.n;
                    }
                    if (Build.MANUFACTURER.equals("Xiaomi")) {
                        return this.n;
                    }
                } catch (Exception unused2) {
                }
            }
            if ((this.b.flags & q) != 0) {
                this.n = l;
            } else if ((this.b.flags & p) == 0 && (1 & this.b.flags) == 0 && c(context)) {
                this.n = l;
            }
        }
        return this.n;
    }

    public boolean c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.b.packageName, 16384);
            int i = packageInfo.getClass().getDeclaredField("installLocation").getInt(packageInfo);
            if (i != r && i != s) {
                if (i == t) {
                    return v;
                }
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.b.flags & q) != 0;
    }

    public boolean d(Context context) {
        CharSequence loadLabel = this.b.loadLabel(context.getPackageManager());
        this.f = loadLabel != null ? loadLabel.toString() : this.b.packageName;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.b.packageName, 0);
            if (packageInfo != null) {
                this.g = packageInfo.versionName;
                this.a = packageInfo.versionCode;
            }
            try {
                this.h = new File(this.b.sourceDir).length();
            } catch (Exception unused) {
                this.h = 0L;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    this.c = PackageInfo.class.getDeclaredField("lastUpdateTime").getLong(packageInfo);
                    return true;
                } catch (Exception unused2) {
                    this.c = 0L;
                    return true;
                }
            }
            try {
                this.c = new File(this.b.sourceDir).lastModified();
                return true;
            } catch (Exception unused3) {
                this.c = 0L;
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused4) {
            return false;
        }
    }

    @Override // com.jumobile.manager.systemapp.d.c
    public Drawable b(Context context) {
        return context.getPackageManager().getApplicationIcon(this.b);
    }

    public boolean b() {
        return (this.b.flags & p) != 0;
    }

    public boolean c() {
        return (this.b.flags & 1) != 0;
    }

    public String e(Context context) {
        int a = com.jumobile.manager.systemapp.f.a.a(context, "apk_name_config", 20);
        ArrayList arrayList = new ArrayList();
        if ((a & 2) != 0) {
            arrayList.add(this.f);
        }
        if ((a & 4) != 0) {
            arrayList.add(this.b.packageName);
        }
        if ((a & 8) != 0) {
            arrayList.add(this.g);
        }
        if ((a & 16) != 0) {
            arrayList.add(String.valueOf(this.a));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (i > 0) {
                sb.append("_");
            }
            sb.append(str);
        }
        sb.append(".apk");
        return sb.toString();
    }

    public String d() {
        return this.b.sourceDir;
    }
}
