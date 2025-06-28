package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzatt {
    private int A;
    private String B;
    private boolean C;
    private int a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private double m;
    private boolean n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private boolean t;
    private final boolean u;
    private boolean v;
    private String w;
    private String x;
    private float y;
    private int z;

    public zzatt(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        a(context);
        b(context);
        c(context);
        Locale locale = Locale.getDefault();
        this.q = a(packageManager, "geo:0,0?q=donuts") != null;
        this.r = a(packageManager, "http://www.google.com") != null;
        this.s = locale.getCountry();
        zzwq.a();
        this.t = zzayr.a();
        this.u = DeviceProperties.d(context);
        this.v = DeviceProperties.c(context);
        this.w = locale.getLanguage();
        this.x = a(context, packageManager);
        this.B = d(context);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.y = displayMetrics.density;
        this.z = displayMetrics.widthPixels;
        this.A = displayMetrics.heightPixels;
    }

    public zzatt(Context context, zzatq zzatqVar) {
        a(context);
        b(context);
        c(context);
        this.o = Build.FINGERPRINT;
        this.p = Build.DEVICE;
        this.C = PlatformVersion.a() && zzacf.a(context);
        this.q = zzatqVar.a;
        this.r = zzatqVar.b;
        this.s = zzatqVar.c;
        this.t = zzatqVar.d;
        this.u = zzatqVar.e;
        this.v = zzatqVar.f;
        this.w = zzatqVar.g;
        this.x = zzatqVar.h;
        this.B = zzatqVar.i;
        this.y = zzatqVar.l;
        this.z = zzatqVar.m;
        this.A = zzatqVar.n;
    }

    private final void a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.a = audioManager.getMode();
                this.b = audioManager.isMusicActive();
                this.c = audioManager.isSpeakerphoneOn();
                this.d = audioManager.getStreamVolume(3);
                this.e = audioManager.getRingerMode();
                this.f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzp.g().a(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.a = -2;
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 2;
        this.f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050  */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.g = r2
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.m()
            r3 = 0
            if (r2 == 0) goto L31
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.eE
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.e()
            java.lang.Object r2 = r4.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L31
            r2 = r3
            goto L35
        L31:
            int r2 = r0.getNetworkType()
        L35:
            r5.i = r2
            int r0 = r0.getPhoneType()
            r5.j = r0
            r0 = -2
            r5.h = r0
            r5.k = r3
            r0 = -1
            r5.l = r0
            com.google.android.gms.ads.internal.zzp.c()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzm.a(r6, r2)
            if (r6 == 0) goto L6f
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L67
            int r0 = r6.getType()
            r5.h = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.l = r6
            goto L69
        L67:
            r5.h = r0
        L69:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.k = r6
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatt.b(android.content.Context):void");
    }

    private final void c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.m = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            this.n = intExtra == 2 || intExtra == 5;
        } else {
            this.m = -1.0d;
            this.n = false;
        }
    }

    private static String d(Context context) {
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
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzp.g().a(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzatq a() {
        return new zzatq(this.a, this.q, this.r, this.g, this.s, this.t, this.u, this.v, this.b, this.c, this.w, this.x, this.B, this.d, this.h, this.i, this.j, this.e, this.f, this.y, this.z, this.A, this.m, this.n, this.k, this.l, this.o, this.C, this.p);
    }
}
