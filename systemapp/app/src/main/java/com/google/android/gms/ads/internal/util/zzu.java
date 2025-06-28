package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbez;
import com.google.android.gms.internal.ads.zzts;
import com.google.android.gms.internal.ads.zzuo;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public class zzu {
    public int a() {
        return 1;
    }

    public void a(Activity activity) {
    }

    public boolean a(Activity activity, Configuration configuration) {
        return false;
    }

    public boolean a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public int b() {
        return 5;
    }

    public String b(Context context) {
        return "";
    }

    public void c(Context context) {
    }

    public long e() {
        return -1L;
    }

    public boolean a(Context context, WebSettings webSettings) {
        zzbu.a(context, new Callable(context, webSettings) { // from class: com.google.android.gms.ads.internal.util.ae
            private final Context a;
            private final WebSettings b;

            {
                this.a = context;
                this.b = webSettings;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = this.a;
                WebSettings webSettings2 = this.b;
                if (context2.getCacheDir() != null) {
                    webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                    webSettings2.setAppCacheMaxSize(0L);
                    webSettings2.setAppCacheEnabled(true);
                }
                webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                webSettings2.setAllowContentAccess(false);
                return true;
            }
        });
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public static boolean a(zzbdv zzbdvVar) {
        if (zzbdvVar == null) {
            return false;
        }
        zzbdvVar.onPause();
        return true;
    }

    public static boolean b(zzbdv zzbdvVar) {
        if (zzbdvVar == null) {
            return false;
        }
        zzbdvVar.onResume();
        return true;
    }

    public zzbdu a(zzbdv zzbdvVar, zzts zztsVar, boolean z) {
        return new zzbez(zzbdvVar, zztsVar, z);
    }

    public ViewGroup.LayoutParams c() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public Drawable a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static boolean d() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public CookieManager a(Context context) {
        if (d()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.c("Failed to obtain CookieManager.", th);
            zzp.g().a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzuo a(Context context, TelephonyManager telephonyManager) {
        return zzuo.ENUM_UNKNOWN;
    }

    public int a(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public int b(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public WebResourceResponse a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzu() {
    }

    public static zzu a(int i) {
        if (i >= 28) {
            return new zzab();
        }
        if (i >= 26) {
            return new zzac();
        }
        if (i >= 24) {
            return new zzz();
        }
        if (i >= 21) {
            return new zzaa();
        }
        if (i >= 19) {
            return new zzx();
        }
        if (i >= 18) {
            return new zzy();
        }
        if (i >= 17) {
            return new zzv();
        }
        return new zzu();
    }

    /* synthetic */ zzu(af afVar) {
        this();
    }
}
