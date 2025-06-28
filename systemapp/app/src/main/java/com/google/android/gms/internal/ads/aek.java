package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final class aek implements zzdfi<zzdfp> {
    private final zzdzc a;
    private final Context b;

    public aek(zzdzc zzdzcVar, Context context) {
        this.a = zzdzcVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfp> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ael
            private final aek a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    private static String a(Context context) {
        try {
            PackageInfo b = Wrappers.a(context).b("com.android.vending", 128);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = b.packageName;
            StringBuilder sb = new StringBuilder(12 + String.valueOf(str).length());
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null || (activityInfo = a.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo b = Wrappers.a(context).b(activityInfo.packageName, 0);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(12 + String.valueOf(str).length());
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    final /* synthetic */ zzdfp b() throws Exception {
        boolean z;
        PackageManager packageManager = this.b.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = a(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = a(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean d = DeviceProperties.d(this.b);
        boolean c = DeviceProperties.c(this.b);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i = 0; i < localeList.size(); i++) {
                arrayList.add(localeList.get(i).getLanguage());
            }
        }
        String a = a(this.b, packageManager);
        String a2 = a(this.b);
        String str = Build.FINGERPRINT;
        Context context = this.b;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                    if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzepr.a(context));
                        break;
                    }
                }
            }
        }
        z = false;
        return new zzdfp(z2, z3, country, startsWith, d, c, language, arrayList, a, a2, str, z, Build.MODEL, zzp.e().e());
    }
}
