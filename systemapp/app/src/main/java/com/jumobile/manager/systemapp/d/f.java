package com.jumobile.manager.systemapp.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.io.File;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends c {
    private static final String l = "f";
    public int a = 20;
    public ApplicationInfo b;
    public String c;
    public long d;
    public int e;

    public f(ApplicationInfo applicationInfo) {
        this.b = applicationInfo;
    }

    public boolean a(Context context) {
        CharSequence loadLabel = this.b.loadLabel(context.getPackageManager());
        this.f = loadLabel != null ? loadLabel.toString() : this.b.packageName;
        try {
            this.h = new File(this.b.sourceDir).length();
        } catch (Exception unused) {
            this.h = 0L;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.b.packageName, 0);
            if (packageInfo != null) {
                this.g = packageInfo.versionName;
                this.e = packageInfo.versionCode;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    this.d = PackageInfo.class.getDeclaredField("lastUpdateTime").getLong(packageInfo);
                    return true;
                } catch (Exception unused2) {
                    this.d = 0L;
                    return true;
                }
            }
            try {
                this.d = new File(this.b.sourceDir).lastModified();
                return true;
            } catch (Exception unused3) {
                this.d = 0L;
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

    public String a() {
        return this.b.sourceDir;
    }

    public String c(Context context) {
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
            arrayList.add(String.valueOf(this.e));
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
}
