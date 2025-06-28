package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzef;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
final class d extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzj a;

    private d(zzj zzjVar) {
        this.a = zzjVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzj zzjVar = this.a;
            future = this.a.c;
            zzjVar.h = (zzef) future.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaza.d("", e);
        }
        return this.a.s();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.a.f;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.a.f;
        webView2.loadUrl(str2);
    }

    /* synthetic */ d(zzj zzjVar, c cVar) {
        this(zzjVar);
    }
}
