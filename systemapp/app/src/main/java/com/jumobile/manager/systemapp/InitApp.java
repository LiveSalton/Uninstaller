package com.jumobile.manager.systemapp;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jumobile.manager.systemapp.util.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class InitApp extends Application {
    private static final String a = "InitApp";
    private static AppOpenManager c;
    private Context b;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.b = getApplicationContext();
        String e = f.e(this.b, "UMENG_CHANNEL");
        if (!TextUtils.isEmpty(e)) {
            a.a = e;
        }
        a.c = this.b.getResources().getDisplayMetrics().widthPixels;
        ConsentInformation.a(this.b).a(new String[]{"pub-4899137311407535"}, new ConsentInfoUpdateListener() { // from class: com.jumobile.manager.systemapp.InitApp.1
            @Override // com.google.ads.consent.ConsentInfoUpdateListener
            public void a(ConsentStatus consentStatus) {
            }

            @Override // com.google.ads.consent.ConsentInfoUpdateListener
            public void a(String str) {
            }
        });
        MobileAds.a(this, new OnInitializationCompleteListener() { // from class: com.jumobile.manager.systemapp.InitApp.2
            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public void a(InitializationStatus initializationStatus) {
            }
        });
        c = new AppOpenManager(this);
        c.a();
    }

    public static AppOpenManager a() {
        return c;
    }
}
