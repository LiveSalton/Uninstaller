package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface zzbdv extends com.google.android.gms.ads.internal.zzk, zzakb, zzaky, zzbbe, zzbdk, zzbeq, zzbew, zzbex, zzbfa, zzbfe, zzbff, zzbfh, zzqu, zzva {
    WebViewClient A();

    boolean B();

    zzef C();

    IObjectWrapper D();

    boolean E();

    boolean F();

    void G();

    boolean H();

    boolean I();

    void J();

    void K();

    zzadx L();

    void M();

    void N();

    zzsc O();

    boolean P();

    zzsu Q();

    boolean R();

    zzdmz S();

    void a(Context context);

    void a(ViewGroup viewGroup, Activity activity, String str, String str2);

    void a(zze zzeVar);

    void a(IObjectWrapper iObjectWrapper);

    void a(zzads zzadsVar);

    void a(zzadx zzadxVar);

    void a(zzbep zzbepVar);

    void a(zzbfn zzbfnVar);

    void a(zzdmu zzdmuVar, zzdmz zzdmzVar);

    void a(zzsc zzscVar);

    void a(String str, Predicate<zzahv<? super zzbdv>> predicate);

    void a(String str, zzahv<? super zzbdv> zzahvVar);

    void a(String str, zzbcx zzbcxVar);

    void a(String str, String str2, String str3);

    boolean a(boolean z, int i);

    void b(int i);

    void b(zze zzeVar);

    void b(String str, zzahv<? super zzbdv> zzahvVar);

    void b(boolean z);

    void c(boolean z);

    zzbep d();

    void d(boolean z);

    void destroy();

    void e(boolean z);

    void f(boolean z);

    Activity g();

    @Override // com.google.android.gms.internal.ads.zzbbe, com.google.android.gms.internal.ads.zzbex
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    com.google.android.gms.ads.internal.zzb h();

    zzabt l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    zzazh m();

    void measure(int i, int i2);

    void onPause();

    void onResume();

    zzdmu q();

    void r();

    void s();

    @Override // com.google.android.gms.internal.ads.zzbbe
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void t();

    Context u();

    zze v();

    zze w();

    zzbfn x();

    String y();

    zzbfg z();
}
