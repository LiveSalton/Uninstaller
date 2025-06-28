package com.jumobile.manager.systemapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.lifecycle.i;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.jumobile.manager.systemapp.ui.activity.IndexActivity;
import java.util.Date;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppOpenManager implements Application.ActivityLifecycleCallbacks, i {
    private static boolean f = false;
    a a;
    private AppOpenAd.AppOpenAdLoadCallback c;
    private final InitApp d;
    private Activity e;
    private Context h;
    private AppOpenAd b = null;
    private long g = 0;

    /* compiled from: source */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public AppOpenManager(InitApp initApp) {
        this.h = initApp.getApplicationContext();
        this.d = initApp;
        this.d.registerActivityLifecycleCallbacks(this);
        r.a().b().a(this);
    }

    public void a() {
        if (com.jumobile.manager.systemapp.f.a.a(this.h, "ads_enabled", true) && !b()) {
            this.c = new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.jumobile.manager.systemapp.AppOpenManager.1
                @Override // com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
                public void a(AppOpenAd appOpenAd) {
                    AppOpenManager.this.b = appOpenAd;
                    AppOpenManager.this.g = new Date().getTime();
                    if (AppOpenManager.this.a != null) {
                        AppOpenManager.this.a.a();
                    }
                }

                @Override // com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
                public void a(LoadAdError loadAdError) {
                    if (AppOpenManager.this.a != null) {
                        AppOpenManager.this.a.b();
                    }
                }
            };
            AppOpenAd.a(this.d, "ca-app-pub-4899137311407535/6997438440", d(), 1, this.c);
        }
    }

    private AdRequest d() {
        Bundle bundle = new Bundle();
        ConsentInformation a2 = ConsentInformation.a(this.d.getApplicationContext());
        if (a2.e() && !a2.f().equals(ConsentStatus.PERSONALIZED)) {
            bundle.putString("npa", "1");
        }
        return new AdRequest.Builder().a(AdMobAdapter.class, bundle).a();
    }

    public boolean b() {
        return this.b != null && a(4L);
    }

    private boolean a(long j) {
        return new Date().getTime() - this.g < 3600000 * j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.e = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.e = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.e = null;
    }

    public void c() {
        if (com.jumobile.manager.systemapp.f.a.a(this.h, "ads_enabled", true)) {
            if (!f && b()) {
                this.b.a(this.e, new FullScreenContentCallback() { // from class: com.jumobile.manager.systemapp.AppOpenManager.2
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void b() {
                        AppOpenManager.this.b = null;
                        boolean unused = AppOpenManager.f = false;
                        AppOpenManager.this.a();
                        if (AppOpenManager.this.a != null) {
                            AppOpenManager.this.a.c();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void a(AdError adError) {
                        if (AppOpenManager.this.a != null) {
                            AppOpenManager.this.a.d();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void a() {
                        boolean unused = AppOpenManager.f = true;
                        if (AppOpenManager.this.a != null) {
                            AppOpenManager.this.a.e();
                        }
                    }
                });
            } else {
                a();
            }
        }
    }

    @q(a = f.a.ON_START)
    public void onStart() {
        if (this.e instanceof IndexActivity) {
            return;
        }
        c();
    }
}
