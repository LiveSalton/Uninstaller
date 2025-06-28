package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzrk extends Thread {
    private boolean a;
    private boolean b;
    private boolean c;
    private final Object d;
    private final zzrh e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final String n;
    private final boolean o;
    private final boolean p;
    private final boolean q;

    public zzrk() {
        this(new zzrh());
    }

    @VisibleForTesting
    private zzrk(zzrh zzrhVar) {
        this.a = false;
        this.b = false;
        this.c = false;
        this.e = zzrhVar;
        this.d = new Object();
        this.g = zzacv.d.a().intValue();
        this.h = zzacv.a.a().intValue();
        this.i = zzacv.e.a().intValue();
        this.j = zzacv.c.a().intValue();
        this.k = ((Integer) zzwq.e().a(zzabf.J)).intValue();
        this.l = ((Integer) zzwq.e().a(zzabf.K)).intValue();
        this.m = ((Integer) zzwq.e().a(zzabf.L)).intValue();
        this.f = zzacv.f.a().intValue();
        this.n = (String) zzwq.e().a(zzabf.N);
        this.o = ((Boolean) zzwq.e().a(zzabf.O)).booleanValue();
        this.p = ((Boolean) zzwq.e().a(zzabf.P)).booleanValue();
        this.q = ((Boolean) zzwq.e().a(zzabf.Q)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void a() {
        synchronized (this.d) {
            if (this.a) {
                zzd.b("Content hash thread already started, quiting...");
            } else {
                this.a = true;
                start();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    if (e()) {
                        Activity a = zzp.f().a();
                        if (a == null) {
                            zzd.b("ContentFetchThread: no activity. Sleeping.");
                            f();
                        } else if (a != null) {
                            View view = null;
                            try {
                                if (a.getWindow() != null && a.getWindow().getDecorView() != null) {
                                    view = a.getWindow().getDecorView().findViewById(R.id.content);
                                }
                            } catch (Exception e) {
                                zzp.g().a(e, "ContentFetchTask.extractContent");
                                zzd.b("Failed getting root view of activity. Content not extracted.");
                            }
                            if (view != null && view != null) {
                                view.post(new bcf(this, view));
                            }
                        }
                    } else {
                        zzd.b("ContentFetchTask: sleeping");
                        f();
                    }
                    Thread.sleep(this.f * 1000);
                } catch (InterruptedException e2) {
                    zzd.c("Error in ContentFetchTask", e2);
                }
            } catch (Exception e3) {
                zzd.c("Error in ContentFetchTask", e3);
                zzp.g().a(e3, "ContentFetchTask.run");
            }
            synchronized (this.d) {
                while (this.b) {
                    try {
                        zzd.b("ContentFetchTask: waiting");
                        this.d.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    @VisibleForTesting
    final void a(View view) {
        try {
            zzre zzreVar = new zzre(this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.p);
            Context b = zzp.f().b();
            if (b != null && !TextUtils.isEmpty(this.n)) {
                String str = (String) view.getTag(b.getResources().getIdentifier((String) zzwq.e().a(zzabf.M), "id", b.getPackageName()));
                if (str != null && str.equals(this.n)) {
                    return;
                }
            }
            bcg a = a(view, zzreVar);
            zzreVar.i();
            if (a.a == 0 && a.b == 0) {
                return;
            }
            if (a.b == 0 && zzreVar.k() == 0) {
                return;
            }
            if (a.b == 0 && this.e.a(zzreVar)) {
                return;
            }
            this.e.c(zzreVar);
        } catch (Exception e) {
            zzd.c("Exception in fetchContentOnUIThread", e);
            zzp.g().a(e, "ContentFetchTask.fetchContent");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r4.importance != 100) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r3.inKeyguardRestrictedInputMode() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r1 = (android.os.PowerManager) r1.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if (r1 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r1 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        r1 = r1.isScreenOn();
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e() {
        /*
            r0 = 0
            com.google.android.gms.internal.ads.zzrg r1 = com.google.android.gms.ads.internal.zzp.f()     // Catch: java.lang.Throwable -> L62
            android.content.Context r1 = r1.b()     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto Lc
            return r0
        Lc:
            java.lang.String r2 = "activity"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L62
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = "keyguard"
            java.lang.Object r3 = r1.getSystemService(r3)     // Catch: java.lang.Throwable -> L62
            android.app.KeyguardManager r3 = (android.app.KeyguardManager) r3     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L61
            if (r3 != 0) goto L21
            goto L61
        L21:
            java.util.List r2 = r2.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L28
            return r0
        L28:
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L62
        L2c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L60
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L62
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4     // Catch: java.lang.Throwable -> L62
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L62
            int r6 = r4.pid     // Catch: java.lang.Throwable -> L62
            if (r5 != r6) goto L2c
            int r2 = r4.importance     // Catch: java.lang.Throwable -> L62
            r4 = 100
            if (r2 != r4) goto L60
            boolean r2 = r3.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L60
            java.lang.String r2 = "power"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L62
            android.os.PowerManager r1 = (android.os.PowerManager) r1     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L58
            r1 = r0
            goto L5c
        L58:
            boolean r1 = r1.isScreenOn()     // Catch: java.lang.Throwable -> L62
        L5c:
            if (r1 == 0) goto L60
            r0 = 1
            return r0
        L60:
            return r0
        L61:
            return r0
        L62:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayg r2 = com.google.android.gms.ads.internal.zzp.g()
            java.lang.String r3 = "ContentFetchTask.isInForeground"
            r2.a(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrk.e():boolean");
    }

    @VisibleForTesting
    private final bcg a(View view, zzre zzreVar) {
        boolean z;
        if (view == null) {
            return new bcg(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                zzreVar.b(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new bcg(this, 1, 0);
            }
            return new bcg(this, 0, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbdv)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.e()) {
                zzreVar.g();
                webView.post(new bce(this, zzreVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new bcg(this, 0, 1);
            }
            return new bcg(this, 0, 0);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                bcg a = a(viewGroup.getChildAt(i3), zzreVar);
                i += a.a;
                i2 += a.b;
            }
            return new bcg(this, i, i2);
        }
        return new bcg(this, 0, 0);
    }

    @VisibleForTesting
    final void a(zzre zzreVar, WebView webView, String str, boolean z) {
        zzreVar.f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!this.o && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(1 + String.valueOf(title).length() + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzreVar.a(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzreVar.a(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzreVar.a()) {
                this.e.b(zzreVar);
            }
        } catch (JSONException unused) {
            zzd.b("Json string may be malformed.");
        } catch (Throwable th) {
            zzd.b("Failed to get webview content.", th);
            zzp.g().a(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzre b() {
        return this.e.a(this.q);
    }

    public final void c() {
        synchronized (this.d) {
            this.b = false;
            this.d.notifyAll();
            zzd.b("ContentFetchThread: wakeup");
        }
    }

    private final void f() {
        synchronized (this.d) {
            this.b = true;
            boolean z = this.b;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzd.b(sb.toString());
        }
    }

    public final boolean d() {
        return this.b;
    }
}
