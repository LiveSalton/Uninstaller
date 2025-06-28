package com.jumobile.manager.systemapp.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends c {
    public final String a;
    public String b;
    private int c;

    public e(String str) {
        this.a = str;
    }

    public boolean a(Context context) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(this.a, 4096);
        if (packageArchiveInfo == null) {
            return false;
        }
        this.g = packageArchiveInfo.versionName;
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
            this.c = packageArchiveInfo.applicationInfo.icon;
            this.b = packageArchiveInfo.packageName;
            this.h = new File(this.a).length();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.jumobile.manager.systemapp.d.c
    public Drawable b(Context context) {
        if (this.c == 0) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            Object newInstance = cls.newInstance();
            cls.getMethod("addAssetPath", String.class).invoke(newInstance, this.a);
            Resources resources = context.getResources();
            return new Resources((AssetManager) newInstance, resources.getDisplayMetrics(), resources.getConfiguration()).getDrawable(this.c);
        } catch (Exception unused) {
            return null;
        }
    }
}
