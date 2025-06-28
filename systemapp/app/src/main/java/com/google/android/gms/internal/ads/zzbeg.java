package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbeg extends FrameLayout implements zzbdv {
    private final zzbdv a;
    private final zzbax b;
    private final AtomicBoolean c;

    public zzbeg(zzbdv zzbdvVar) {
        super(zzbdvVar.getContext());
        this.c = new AtomicBoolean();
        this.a = zzbdvVar;
        this.b = new zzbax(zzbdvVar.u(), this, this);
        if (R()) {
            return;
        }
        addView(this.a.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbfh
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final zzbax c() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void onPause() {
        this.b.b();
        this.a.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void G() {
        this.b.c();
        this.a.G();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void M() {
        setBackgroundColor(0);
        this.a.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final int n() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final int o() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void p() {
        this.a.p();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final WebView getWebView() {
        return this.a.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void a(String str, Map<String, ?> map) {
        this.a.a(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void b(String str, JSONObject jSONObject) {
        this.a.b(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, zzahv<? super zzbdv> zzahvVar) {
        this.a.a(str, zzahvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(String str, zzahv<? super zzbdv> zzahvVar) {
        this.a.b(str, zzahvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        this.a.a(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void r() {
        this.a.r();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(int i) {
        this.a.b(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void s() {
        this.a.s();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void t() {
        this.a.t();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void a(boolean z, long j) {
        this.a.a(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void d(String str) {
        this.a.d(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void a(String str, JSONObject jSONObject) {
        this.a.a(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe, com.google.android.gms.internal.ads.zzbex
    public final Activity g() {
        return this.a.g();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final Context u() {
        return this.a.u();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final com.google.android.gms.ads.internal.zzb h() {
        return this.a.h();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zze v() {
        return this.a.v();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final IObjectWrapper D() {
        return this.a.D();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zze w() {
        return this.a.w();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbfc
    public final zzbfn x() {
        return this.a.x();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final String y() {
        return this.a.y();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zzbfg z() {
        return this.a.z();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final WebViewClient A() {
        return this.a.A();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean B() {
        return this.a.B();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbff
    public final zzef C() {
        return this.a.C();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe, com.google.android.gms.internal.ads.zzbfe
    public final zzazh m() {
        return this.a.m();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbew
    public final boolean E() {
        return this.a.E();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean F() {
        return this.a.F();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean H() {
        return this.a.H();
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void b() {
        this.a.b();
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void a() {
        this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final String getRequestId() {
        return this.a.getRequestId();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final String j() {
        return this.a.j();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void a(int i) {
        this.a.a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final int k() {
        return this.a.k();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final zzabq f() {
        return this.a.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final zzabt l() {
        return this.a.l();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final zzbep d() {
        return this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zze zzeVar) {
        this.a.a(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(IObjectWrapper iObjectWrapper) {
        this.a.a(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzbfn zzbfnVar) {
        this.a.a(zzbfnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(boolean z) {
        this.a.b(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void J() {
        this.a.J();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(Context context) {
        this.a.a(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void c(boolean z) {
        this.a.c(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void setRequestedOrientation(int i) {
        this.a.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(zze zzeVar) {
        this.a.b(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void d(boolean z) {
        this.a.d(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final void a(String str, zzbcx zzbcxVar) {
        this.a.a(str, zzbcxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final zzbcx a(String str) {
        return this.a.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void K() {
        this.a.K();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void destroy() {
        IObjectWrapper D = D();
        if (D != null) {
            com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(D) { // from class: com.google.android.gms.internal.ads.is
                private final IObjectWrapper a;

                {
                    this.a = D;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzp.r().b(this.a);
                }
            });
            com.google.android.gms.ads.internal.util.zzm.a.postDelayed(new ir(this), ((Integer) zzwq.e().a(zzabf.cA)).intValue());
            return;
        }
        this.a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void loadData(String str, String str2, String str3) {
        this.a.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void loadUrl(String str) {
        this.a.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, String str2, String str3) {
        this.a.a(str, str2, str3);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdv
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdv
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.a.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.a.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.a.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void onResume() {
        this.a.onResume();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void N() {
        TextView textView = new TextView(getContext());
        Resources d = zzp.g().d();
        textView.setText(d != null ? d.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void f(boolean z) {
        this.a.f(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzads zzadsVar) {
        this.a.a(zzadsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzsc zzscVar) {
        this.a.a(zzscVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zzsc O() {
        return this.a.O();
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void a(zzqv zzqvVar) {
        this.a.a(zzqvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzadx zzadxVar) {
        this.a.a(zzadxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zzadx L() {
        return this.a.L();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final void a(zzbep zzbepVar) {
        this.a.a(zzbepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean I() {
        return this.a.I();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void e(boolean z) {
        this.a.e(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void a(boolean z) {
        this.a.a(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void i() {
        this.a.i();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        this.a.a(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void b(boolean z, int i) {
        this.a.b(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(boolean z, int i, String str) {
        this.a.a(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(boolean z, int i, String str, String str2) {
        this.a.a(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean a(boolean z, int i) {
        if (!this.c.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzwq.e().a(zzabf.aj)).booleanValue()) {
            return false;
        }
        if (this.a.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.a.getParent()).removeView(this.a.getView());
        }
        return this.a.a(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean P() {
        return this.c.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.a.a(this, activity, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zzsu Q() {
        return this.a.Q();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean R() {
        return this.a.R();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbdk
    public final zzdmu q() {
        return this.a.q();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbeq
    public final zzdmz S() {
        return this.a.S();
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        if (this.a != null) {
            this.a.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzdmu zzdmuVar, zzdmz zzdmzVar) {
        this.a.a(zzdmuVar, zzdmzVar);
    }
}
