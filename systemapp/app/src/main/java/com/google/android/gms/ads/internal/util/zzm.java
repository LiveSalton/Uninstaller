package com.google.android.gms.ads.internal.util;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzaam;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzacf;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzacx;
import com.google.android.gms.internal.ads.zzadg;
import com.google.android.gms.internal.ads.zzauc;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzduw;
import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyr;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzwq;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzm {
    public static final zzduw a = new zzg(Looper.getMainLooper());

    @GuardedBy("userAgentLock")
    private String f;
    private AtomicReference<Pattern> b = new AtomicReference<>(null);
    private AtomicReference<Pattern> c = new AtomicReference<>(null);
    private boolean d = true;
    private final Object e = new Object();
    private boolean g = false;
    private boolean h = false;

    public static int a(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        StringBuilder sb = new StringBuilder(97);
        sb.append("HTTP timeout too low: ");
        sb.append(i);
        sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        zzd.e(sb.toString());
        return 60000;
    }

    public final void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        a(context, str, false, httpURLConnection, false, 60000);
    }

    public final void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int a2 = a(i);
        StringBuilder sb = new StringBuilder(39);
        sb.append("HTTP timeout: ");
        sb.append(a2);
        sb.append(" milliseconds.");
        zzd.d(sb.toString());
        httpURLConnection.setConnectTimeout(a2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(a2);
        httpURLConnection.setRequestProperty("User-Agent", b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static boolean a(Context context, String str) {
        Context b = zzauc.b(context);
        return Wrappers.a(b).a(str, b.getPackageName()) == 0;
    }

    public static void a(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            new zzbp(context, str, (String) obj).b();
        }
    }

    @TargetApi(18)
    public final int a(Context context, Uri uri) {
        int i;
        if (!PlatformVersion.d()) {
            zzd.a("Chrome Custom Tabs can only work with version Jellybean onwards.");
            i = zzach.a;
        } else if (!(context instanceof Activity)) {
            zzd.a("Chrome Custom Tabs can only work with Activity context.");
            i = zzach.b;
        } else if (zzacf.a(context)) {
            i = 0;
        } else {
            zzd.a("Default browser does not support custom tabs.");
            i = zzach.c;
        }
        if (i != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i;
        }
        zzacf zzacfVar = new zzacf();
        zzacfVar.a(new y(this, zzacfVar, context, uri));
        zzacfVar.b((Activity) context);
        return zzach.d;
    }

    public static String a(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public final boolean a(Context context) {
        if (this.g) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new ac(this, null), intentFilter);
        this.g = true;
        return true;
    }

    public final boolean b(Context context) {
        if (this.h) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new ad(this, null), intentFilter);
        this.h = true;
        return true;
    }

    public final void a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(b(context, str));
    }

    private static String d() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public final String b(Context context, String str) {
        synchronized (this.e) {
            if (this.f != null) {
                return this.f;
            }
            if (str == null) {
                return d();
            }
            try {
                this.f = zzp.e().b(context);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(this.f)) {
                zzwq.a();
                if (!zzayr.b()) {
                    this.f = null;
                    a.post(new ab(this, context));
                    while (this.f == null) {
                        try {
                            this.e.wait();
                        } catch (InterruptedException unused2) {
                            this.f = d();
                            String valueOf = String.valueOf(this.f);
                            zzd.e(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                        }
                    }
                } else {
                    this.f = c(context);
                }
            }
            String valueOf2 = String.valueOf(this.f);
            StringBuilder sb = new StringBuilder(10 + String.valueOf(valueOf2).length() + String.valueOf(str).length());
            sb.append(valueOf2);
            sb.append(" (Mobile; ");
            sb.append(str);
            this.f = sb.toString();
            try {
                if (Wrappers.a(context).a()) {
                    this.f = String.valueOf(this.f).concat(";aia");
                }
            } catch (Exception e) {
                zzp.g().a(e, "AdUtil.getUserAgent");
            }
            this.f = String.valueOf(this.f).concat(")");
            return this.f;
        }
    }

    @VisibleForTesting
    protected static String c(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return d();
        }
    }

    public static boolean a(ClassLoader classLoader, Class<?> cls, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (Class.forName(it.next(), false, classLoader).isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final JSONObject a(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final JSONObject a(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            return null;
        }
        try {
            return a(bundle);
        } catch (JSONException e) {
            zzd.c("Error converting Bundle to JSON", e);
            return null;
        }
    }

    public final JSONObject a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private final JSONArray a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            a(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(a((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(a((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(a((Collection<?>) obj));
            return;
        }
        if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                a(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
            return;
        }
        jSONArray.put(obj);
    }

    private final void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, a((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, a((Map<String, ?>) obj));
            return;
        }
        if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, a((Collection<?>) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        if (c < 'a' || c > 'f') {
            throw new IllegalArgumentException("Invalid Hex.");
        }
        return (c - 'a') + 10;
    }

    public final zzdyz<Map<String, String>> a(Uri uri) {
        return zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, uri) { // from class: com.google.android.gms.ads.internal.util.x
            private final zzm a;
            private final Uri b;

            {
                this.a = this;
                this.b = uri;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return zzdyr.a(zzm.b(this.b));
            }
        }, zzazj.a);
    }

    public static Map<String, String> b(Uri uri) {
        if (!zzacx.b.a().booleanValue()) {
            if (uri == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            zzp.e();
            for (String str : uri.getQueryParameterNames()) {
                hashMap.put(str, uri.getQueryParameter(str));
            }
            return hashMap;
        }
        if (uri == null) {
            return null;
        }
        HashMap hashMap2 = new HashMap(20);
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return hashMap2;
        }
        int length = encodedQuery.length();
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(length);
        StringBuilder sb3 = sb;
        int i = 0;
        while (i < length) {
            char charAt = encodedQuery.charAt(i);
            if (charAt == '+') {
                sb3.append(' ');
            } else if (charAt != '=') {
                switch (charAt) {
                    case '%':
                        byte[] bArr = new byte[(length - i) / 3];
                        int i2 = 0;
                        while (i < length - 2 && charAt == '%') {
                            try {
                                bArr[i2] = (byte) ((a(encodedQuery.charAt(i + 1)) << 4) + a(encodedQuery.charAt(i + 2)));
                                i2++;
                            } catch (IllegalArgumentException unused) {
                            }
                            i += 3;
                            if (i < length) {
                                charAt = encodedQuery.charAt(i);
                            }
                        }
                        try {
                            sb3.append(new String(bArr, 0, i2, "UTF-8"));
                        } catch (UnsupportedEncodingException unused2) {
                        }
                        if (charAt != '%') {
                            break;
                        } else {
                            break;
                        }
                    case '&':
                        if (sb.length() > 0 && sb3 != sb) {
                            hashMap2.put(sb.toString(), sb2.toString());
                            sb.setLength(0);
                            sb2.setLength(0);
                        }
                        sb3 = sb;
                        break;
                    default:
                        sb3.append(charAt);
                        break;
                }
            } else if (sb3 != sb2) {
                sb3 = sb2;
            } else {
                sb3.append(charAt);
            }
            i++;
        }
        if (sb.length() > 0 && sb3 != sb) {
            hashMap2.put(sb.toString(), sb2.toString());
        }
        return hashMap2;
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(22 + String.valueOf(valueOf).length());
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzd.e(sb.toString());
            return 0;
        }
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(1 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] e() {
        return new int[]{0, 0};
    }

    public static int[] a(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window != null && (findViewById = window.findViewById(R.id.content)) != null) {
            return new int[]{findViewById.getWidth(), findViewById.getHeight()};
        }
        return e();
    }

    public static int[] b(Activity activity) {
        int[] a2 = a(activity);
        return new int[]{zzwq.a().b(activity, a2[0]), zzwq.a().b(activity, a2[1])};
    }

    public static int[] c(Activity activity) {
        int[] e;
        View findViewById;
        Window window = activity.getWindow();
        if (window != null && (findViewById = window.findViewById(R.id.content)) != null) {
            e = new int[]{findViewById.getTop(), findViewById.getBottom()};
        } else {
            e = e();
        }
        return new int[]{zzwq.a().b(activity, e[0]), zzwq.a().b(activity, e[1])};
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static DisplayMetrics a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static AlertDialog.Builder d(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzaam e(Context context) {
        return new zzaam(context);
    }

    public static Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static PopupWindow a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    @SuppressLint({"NewApi"})
    public static String f(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean g(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return !(powerManager == null ? false : powerManager.isScreenOn());
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void a(Context context, String str, String str2, Bundle bundle, boolean z) {
        zzp.c();
        bundle.putString("device", b());
        bundle.putString("eids", TextUtils.join(",", zzabf.a()));
        zzwq.a();
        zzayr.a(context, str, str2, bundle, true, new aa(this, context, str));
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzazj.a.execute(runnable);
        }
    }

    public static Bitmap b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap g = g(view);
        return g == null ? f(view) : g;
    }

    private static Bitmap f(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzd.e("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            zzd.c("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap g(View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e) {
            zzd.c("Fail to capture the web view", e);
        }
        return r0;
    }

    public static void a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static int h(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public final boolean a(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return a(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, t(context));
    }

    private static KeyguardManager t(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    public static boolean a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!zzp.c().d) {
            if ((keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) && !c(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzwq.e().a(zzabf.aD)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzwq.e().a(zzabf.aD)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzm.c(android.view.View):boolean");
    }

    @TargetApi(16)
    public static boolean i(Context context) {
        KeyguardManager t;
        return context != null && PlatformVersion.b() && (t = t(context)) != null && t.isKeyguardLocked();
    }

    public static int d(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean e(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof ScrollView)) {
            parent = parent.getParent();
        }
        return parent != null;
    }

    public static boolean j(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzd.c("Error loading class.", th);
            zzp.g().a(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    @TargetApi(18)
    public static void b(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            b(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(26 + String.valueOf(uri2).length());
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzd.b(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzd.c("No browser is found.", e);
        }
    }

    @TargetApi(18)
    public static void b(Context context, Intent intent) {
        if (intent != null && PlatformVersion.d()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void b(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e) {
            zzd.c("Error writing to file in internal storage.", e);
        }
    }

    public static String c(Context context, String str) {
        try {
            return new String(IOUtils.a((InputStream) context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            zzd.b("Error reading from internal storage.");
            return "";
        }
    }

    public final boolean c(String str) {
        return a(str, this.b, (String) zzwq.e().a(zzabf.S));
    }

    public final boolean d(String str) {
        return a(str, this.c, (String) zzwq.e().a(zzabf.T));
    }

    private static boolean a(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static String c() {
        Resources d = zzp.g().d();
        return d != null ? d.getString(com.google.android.gms.ads.impl.R.string.s7) : "Test Ad";
    }

    public static WebResourceResponse c(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", zzp.c().b(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzax(context).a(str2, hashMap).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzd.d("Could not fetch MRAID JS.", e);
            return null;
        }
    }

    public static WebResourceResponse a(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        zzp.c();
        String contentType = httpURLConnection.getContentType();
        String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        zzp.c();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                for (int i = 1; i < split.length; i++) {
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                            break;
                        }
                    }
                }
            }
        }
        str = "";
        String str2 = str;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return zzp.e().a(trim, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static void a(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = zzadg.b.a().booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (z) {
            CrashUtils.a(context, th);
        }
    }

    public static String k(Context context) {
        return !((Boolean) zzwq.e().a(zzabf.dl)).booleanValue() ? "" : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }

    public static Bundle l(Context context) {
        if (!((Boolean) zzwq.e().a(zzabf.dm)).booleanValue()) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Bundle bundle = new Bundle();
        if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
            bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
        }
        String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (defaultSharedPreferences.contains(str)) {
                bundle.putString(str, defaultSharedPreferences.getString(str, null));
            }
        }
        return bundle;
    }

    public static boolean m(Context context) {
        Window window;
        if (!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public static boolean e(String str) {
        if (!zzayu.c()) {
            return false;
        }
        if (!((Boolean) zzwq.e().a(zzabf.cv)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzwq.e().a(zzabf.cx);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) zzwq.e().a(zzabf.cw);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String n(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return b(u(context));
    }

    public static boolean o(Context context) {
        Bundle u = u(context);
        return TextUtils.isEmpty(b(u)) && !TextUtils.isEmpty(u.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
    }

    private static String b(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return TextUtils.isEmpty(string) ? "" : (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "";
    }

    private static Bundle u(Context context) {
        try {
            return Wrappers.a(context).a(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zzd.a("Error getting metadata", e);
            return null;
        }
    }

    public static boolean p(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @TargetApi(26)
    public static void q(Context context) {
        if (PlatformVersion.j()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public static boolean r(Context context) {
        return androidx.core.app.k.a(context).a();
    }

    public static zzbf s(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzd.c("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbf) {
                return (zzbf) queryLocalInterface;
            }
            return new zzbh(iBinder);
        } catch (Exception e) {
            zzp.g().a(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }
}
