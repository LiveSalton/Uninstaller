package com.jumobile.manager.systemapp.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends c {
    public final String a;
    public int b;
    public int c;
    public long d;
    public String e;
    private int l;

    public a(String str) {
        this.a = str;
    }

    public boolean a(Context context) {
        PackageInfo packageInfo;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(this.a, 4096);
        if (packageArchiveInfo == null) {
            return false;
        }
        this.g = packageArchiveInfo.versionName;
        this.c = packageArchiveInfo.versionCode;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            Object newInstance = cls.newInstance();
            cls.getMethod("addAssetPath", String.class).invoke(newInstance, this.a);
            Resources resources = context.getResources();
            Resources resources2 = new Resources((AssetManager) newInstance, resources.getDisplayMetrics(), resources.getConfiguration());
            if (packageArchiveInfo.applicationInfo.labelRes == 0) {
                this.f = String.valueOf(context.getPackageManager().getApplicationLabel(packageArchiveInfo.applicationInfo));
            } else {
                this.f = resources2.getString(packageArchiveInfo.applicationInfo.labelRes);
            }
            try {
                this.d = new File(this.a).lastModified();
            } catch (Exception unused) {
                this.d = 0L;
            }
            this.l = packageArchiveInfo.applicationInfo.icon;
            this.e = packageArchiveInfo.packageName;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageArchiveInfo.packageName, 128);
            } catch (PackageManager.NameNotFoundException unused2) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                this.b = 0;
            } else if (packageArchiveInfo.versionCode < packageInfo.versionCode) {
                this.b = 1;
            } else if (packageArchiveInfo.versionCode > packageInfo.versionCode) {
                this.b = 3;
            } else if (this.g == null || packageInfo.versionName == null) {
                if (this.g == packageInfo.versionName) {
                    this.b = 2;
                } else {
                    this.b = 0;
                }
            } else if (this.g.equals(packageInfo.versionName)) {
                this.b = 2;
            } else {
                this.b = 0;
                try {
                    String[] split = this.g.split(".");
                    String[] split2 = packageInfo.versionName.split(".");
                    if (split != null && split2 != null && split.length == split2.length) {
                        for (int i = 0; i < split2.length; i++) {
                            int intValue = Integer.valueOf(split[i]).intValue();
                            int intValue2 = Integer.valueOf(split2[i]).intValue();
                            if (intValue > intValue2) {
                                this.b = 3;
                                break;
                            }
                            if (intValue < intValue2) {
                                this.b = 1;
                                break;
                            }
                        }
                    }
                } catch (Exception unused3) {
                }
            }
            this.h = new File(this.a).length();
            return true;
        } catch (Exception unused4) {
            return false;
        }
    }

    @Override // com.jumobile.manager.systemapp.d.c
    public Drawable b(Context context) {
        if (this.l == 0) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            Object newInstance = cls.newInstance();
            cls.getMethod("addAssetPath", String.class).invoke(newInstance, this.a);
            Resources resources = context.getResources();
            return new Resources((AssetManager) newInstance, resources.getDisplayMetrics(), resources.getConfiguration()).getDrawable(this.l);
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(Context context) {
        int a = com.jumobile.manager.systemapp.f.a.a(context, "apk_name_config", 20);
        ArrayList arrayList = new ArrayList();
        if ((a & 2) != 0) {
            arrayList.add(this.f);
        }
        if ((a & 4) != 0) {
            arrayList.add(this.e);
        }
        if ((a & 8) != 0) {
            arrayList.add(this.g);
        }
        if ((a & 16) != 0) {
            arrayList.add(String.valueOf(this.c));
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
