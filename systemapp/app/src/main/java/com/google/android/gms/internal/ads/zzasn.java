package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzasn implements zzasr {
    private static final Object a = new Object();

    @VisibleForTesting
    private static zzasr b;

    @VisibleForTesting
    private static zzasr c;
    private final Object d;
    private final Context e;
    private final WeakHashMap<Thread, Boolean> f;
    private final ExecutorService g;
    private final zzazh h;

    public static zzasr a(Context context) {
        synchronized (a) {
            if (b == null) {
                if (zzadg.e.a().booleanValue()) {
                    if (!((Boolean) zzwq.e().a(zzabf.ea)).booleanValue()) {
                        b = new zzasn(context);
                    }
                }
                b = new zzasq();
            }
        }
        return b;
    }

    public static zzasr a(Context context, zzazh zzazhVar) {
        synchronized (a) {
            if (c == null) {
                if (zzadg.e.a().booleanValue()) {
                    if (!((Boolean) zzwq.e().a(zzabf.ea)).booleanValue()) {
                        zzasn zzasnVar = new zzasn(context, zzazhVar);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzasnVar.d) {
                                zzasnVar.f.put(thread, true);
                            }
                            thread.setUncaughtExceptionHandler(new du(zzasnVar, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new dv(zzasnVar, Thread.getDefaultUncaughtExceptionHandler()));
                        c = zzasnVar;
                    }
                }
                c = new zzasq();
            }
        }
        return c;
    }

    private zzasn(Context context) {
        this(context, zzazh.a());
    }

    private zzasn(Context context, zzazh zzazhVar) {
        this.d = new Object();
        this.f = new WeakHashMap<>();
        this.g = zzduo.a().a(zzdut.b);
        this.e = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.h = zzazhVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r3 == false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L42
            r1 = r11
            r2 = r0
            r3 = r2
        L7:
            if (r1 == 0) goto L3d
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = r0
        L11:
            if (r2 >= r5) goto L36
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzayr.b(r8)
            if (r8 == 0) goto L20
            r3 = r10
        L20:
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L33
            r6 = r10
        L33:
            int r2 = r2 + 1
            goto L11
        L36:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L7
        L3d:
            if (r2 == 0) goto L42
            if (r3 != 0) goto L42
            goto L43
        L42:
            r10 = r0
        L43:
            if (r10 == 0) goto L4c
            java.lang.String r10 = ""
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.a(r11, r10, r0)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasn.a(java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final void a(Throwable th, String str) {
        a(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final void a(Throwable th, String str, float f) {
        if (zzayr.a(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzeid.a(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f);
        int i2 = f > 0.0f ? (int) (1.0f / f) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(name, stringWriter2, str, i2).toString());
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                this.g.execute(new Runnable(new zzaze(), (String) obj) { // from class: com.google.android.gms.internal.ads.dt
                    private final zzaze a;
                    private final String b;

                    {
                        this.a = zzazeVar;
                        this.b = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(this.b);
                    }
                });
            }
        }
    }

    @VisibleForTesting
    private final Uri.Builder a(String str, String str2, String str3, int i) {
        boolean z;
        try {
            z = Wrappers.a(this.e).a();
        } catch (Throwable th) {
            zzaza.c("Error fetching instant app info", th);
            z = false;
        }
        String str4 = "unknown";
        try {
            str4 = this.e.getPackageName();
        } catch (Throwable unused) {
            zzaza.e("Cannot obtain package name, proceeding.");
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(1 + String.valueOf(str5).length() + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.h.a).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzabf.a())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "334274230").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzwq.f()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzadg.c.a()));
        if (((Boolean) zzwq.e().a(zzabf.aI)).booleanValue()) {
            appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.a().b(this.e))).appendQueryParameter("lite", this.h.e ? "1" : "0");
        }
        return appendQueryParameter2;
    }
}
