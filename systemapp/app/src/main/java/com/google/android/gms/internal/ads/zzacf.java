package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzacf implements zzept {
    private androidx.browser.customtabs.e a;
    private androidx.browser.customtabs.b b;
    private androidx.browser.customtabs.d c;
    private zzace d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzepr.a(context));
                }
            }
        }
        return false;
    }

    public final void a(Activity activity) {
        if (this.c == null) {
            return;
        }
        activity.unbindService(this.c);
        this.b = null;
        this.a = null;
        this.c = null;
    }

    public final androidx.browser.customtabs.e a() {
        if (this.b == null) {
            this.a = null;
        } else if (this.a == null) {
            this.a = this.b.a((androidx.browser.customtabs.a) null);
        }
        return this.a;
    }

    public final void a(zzace zzaceVar) {
        this.d = zzaceVar;
    }

    public final void b(Activity activity) {
        String a;
        if (this.b == null && (a = zzepr.a(activity)) != null) {
            this.c = new zzepu(this);
            androidx.browser.customtabs.b.a(activity, a, this.c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzept
    public final void a(androidx.browser.customtabs.b bVar) {
        this.b = bVar;
        this.b.a(0L);
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzept
    public final void b() {
        this.b = null;
        this.a = null;
        if (this.d != null) {
            this.d.b();
        }
    }
}
