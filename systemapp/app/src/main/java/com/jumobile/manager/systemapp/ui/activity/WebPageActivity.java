package com.jumobile.manager.systemapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class WebPageActivity extends FragmentActivity {
    private static final String k = "WebPageActivity";
    private Context l;
    private WebView m;
    private View n;
    private String o;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getApplicationContext();
        setContentView(R.layout.activity_web_page);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.o = intent.getStringExtra("extra_url");
        h();
    }

    private void h() {
        this.n = findViewById(R.id.loading);
        this.m = (WebView) findViewById(R.id.web_view);
        f();
    }

    public void f() {
        this.m.setWebViewClient(new a());
        WebSettings settings = this.m.getSettings();
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setTextZoom(100);
        settings.setAppCacheMaxSize(10485760L);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(this.l.getDir("web_cache", 0).getPath());
        settings.setAllowFileAccess(true);
        settings.setSavePassword(false);
        settings.setLoadsImagesAutomatically(true);
        this.m.setVisibility(0);
        this.m.loadUrl(this.o);
    }

    /* compiled from: source */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("http") || lowerCase.startsWith("https") || lowerCase.startsWith("ftp") || lowerCase.startsWith("file")) {
                webView.loadUrl(str);
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            if (WebPageActivity.this.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                return true;
            }
            WebPageActivity.this.startActivity(intent);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebPageActivity.this.n.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebPageActivity.this.n.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }
}
