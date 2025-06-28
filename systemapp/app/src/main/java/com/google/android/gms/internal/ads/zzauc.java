package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzauc extends ContextWrapper {
    private Context a;
    private WeakReference<Activity> b;

    private zzauc(Context context) {
        super(context);
        this.b = new WeakReference<>(null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    public final synchronized void a(String str) throws PackageManager.NameNotFoundException {
        this.a = super.createPackageContext(str, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized ApplicationInfo getApplicationInfo() {
        if (this.a != null) {
            return this.a.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageName() {
        if (this.a != null) {
            return this.a.getPackageName();
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageResourcePath() {
        if (this.a != null) {
            return this.a.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized void startActivity(Intent intent) {
        b(a(intent));
    }

    private final synchronized Intent a(Intent intent) {
        if (this.a != null && intent.getComponent() != null && intent.getComponent().getPackageName().equals(this.a.getPackageName())) {
            Intent intent2 = (Intent) intent.clone();
            intent2.setClassName(super.getPackageName(), intent.getComponent().getClassName());
            return intent2;
        }
        return intent;
    }

    private final synchronized void b(Intent intent) {
        Activity activity = this.b.get();
        if (activity == null) {
            intent.addFlags(268435456);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & (-268435457));
            activity.startActivity(intent2);
        } catch (Throwable th) {
            zzp.g().a(th, "");
            intent.addFlags(268435456);
            super.startActivity(intent);
        }
    }

    public static zzauc a(Context context) {
        return new zzauc(c(context));
    }

    public static Context b(Context context) {
        if (context instanceof zzauc) {
            return ((zzauc) context).getBaseContext();
        }
        return c(context);
    }

    private static Context c(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
