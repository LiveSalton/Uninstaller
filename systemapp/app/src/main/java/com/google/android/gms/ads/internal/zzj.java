package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaak;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzart;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zzsl;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzvw;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzws;
import com.google.android.gms.internal.ads.zzwt;
import com.google.android.gms.internal.ads.zzxf;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzxo;
import com.google.android.gms.internal.ads.zzxu;
import com.google.android.gms.internal.ads.zzym;
import com.google.android.gms.internal.ads.zzyn;
import com.google.android.gms.internal.ads.zzys;
import com.google.android.gms.internal.ads.zzyy;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzj extends zzxf {
    private final zzazh a;
    private final zzvn b;
    private final Future<zzef> c = zzazj.a.submit(new e(this));
    private final Context d;
    private final f e;
    private WebView f;
    private zzwt g;
    private zzef h;
    private AsyncTask<Void, Void, String> i;

    public zzj(Context context, zzvn zzvnVar, String str, zzazh zzazhVar) {
        this.d = context;
        this.a = zzazhVar;
        this.b = zzvnVar;
        this.f = new WebView(this.d);
        this.e = new f(context, str);
        a(0);
        this.f.setVerticalScrollBarEnabled(false);
        this.f.getSettings().setJavaScriptEnabled(true);
        this.f.setWebViewClient(new c(this));
        this.f.setOnTouchListener(new b(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzym zzymVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean c() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void h() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String k() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String l() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzyn m() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean q() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzys r() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() throws RemoteException {
        Preconditions.b("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.a(this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b() throws RemoteException {
        Preconditions.b("destroy must be called on the main UI thread.");
        this.i.cancel(true);
        this.c.cancel(true);
        this.f.destroy();
        this.f = null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean a(zzvk zzvkVar) throws RemoteException {
        Preconditions.a(this.f, "This Search Ad has already been torn down");
        this.e.a(zzvkVar, this.a);
        this.i = new d(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void d() throws RemoteException {
        Preconditions.b("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void e() throws RemoteException {
        Preconditions.b("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzwt zzwtVar) throws RemoteException {
        this.g = zzwtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxo zzxoVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxj zzxjVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final Bundle f() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void g() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void i() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzvn j() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvn zzvnVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzart zzartVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzarz zzarzVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String n() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxo o() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzwt p() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzacb zzacbVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzws zzwsVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxu zzxuVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaup zzaupVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaak zzaakVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzyy zzyyVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvw zzvwVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzsl zzslVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    final int c(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwq.a();
            return zzayr.a(this.d, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @VisibleForTesting
    final void a(int i) {
        if (this.f == null) {
            return;
        }
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    @VisibleForTesting
    final String s() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzacr.d.a());
        builder.appendQueryParameter("query", this.e.b());
        builder.appendQueryParameter("pubId", this.e.c());
        Map<String, String> d = this.e.d();
        for (String str : d.keySet()) {
            builder.appendQueryParameter(str, d.get(str));
        }
        Uri build = builder.build();
        if (this.h != null) {
            try {
                build = this.h.a(build, this.d);
            } catch (zzei e) {
                zzd.d("Unable to process ad data", e);
            }
        }
        String t = t();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(1 + String.valueOf(t).length() + String.valueOf(encodedQuery).length());
        sb.append(t);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    @VisibleForTesting
    final String t() {
        String a = this.e.a();
        if (TextUtils.isEmpty(a)) {
            a = "www.google.com";
        }
        String a2 = zzacr.d.a();
        StringBuilder sb = new StringBuilder(8 + String.valueOf(a).length() + String.valueOf(a2).length());
        sb.append("https://");
        sb.append(a);
        sb.append(a2);
        return sb.toString();
    }

    public final String d(String str) {
        if (this.h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.h.a(parse, this.d, null, null);
        } catch (zzei e) {
            zzd.d("Unable to process ad data", e);
        }
        return parse.toString();
    }

    public final void e(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.d.startActivity(intent);
    }
}
