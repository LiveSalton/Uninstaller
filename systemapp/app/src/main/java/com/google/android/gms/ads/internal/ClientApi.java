package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzani;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzaui;
import com.google.android.gms.internal.ads.zzavh;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccy;
import com.google.android.gms.internal.ads.zzcxk;
import com.google.android.gms.internal.ads.zzcxm;
import com.google.android.gms.internal.ads.zzdij;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzxs;
import com.google.android.gms.internal.ads.zzxw;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class ClientApi extends zzxs {
    @KeepForSdk
    public ClientApi() {
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxw b(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaru c(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        return new zzcxm(zzbgm.a(context, zzaniVar, i), context, zzvnVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg b(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzbgm.a(context, zzaniVar, i);
        return zzbgm.a(context, zzaniVar, i).m().a(context).a(zzvnVar).a(str).a().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzwz a(IObjectWrapper iObjectWrapper, String str, zzani zzaniVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        return new zzcxk(zzbgm.a(context, zzaniVar, i), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaen a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzccy((FrameLayout) ObjectWrapper.a(iObjectWrapper), (FrameLayout) ObjectWrapper.a(iObjectWrapper2), 203404000);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaui a(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        return zzbgm.a(context, zzaniVar, i).p().a(context).a().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzarj a(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.a(iObjectWrapper);
        AdOverlayInfoParcel a = AdOverlayInfoParcel.a(activity.getIntent());
        if (a == null) {
            return new zzs(activity);
        }
        switch (a.k) {
        }
        return new zzs(activity);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxw a(IObjectWrapper iObjectWrapper, int i) {
        return zzbgm.a((Context) ObjectWrapper.a(iObjectWrapper), i).g();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, int i) {
        return new zzj((Context) ObjectWrapper.a(iObjectWrapper), zzvnVar, str, new zzazh(203404000, i, true, false));
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaeq a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzccv((View) ObjectWrapper.a(iObjectWrapper), (HashMap) ObjectWrapper.a(iObjectWrapper2), (HashMap) ObjectWrapper.a(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzavh b(IObjectWrapper iObjectWrapper, String str, zzani zzaniVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        return zzbgm.a(context, zzaniVar, i).p().a(context).a(str).a().b();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg c(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i) {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        zzdij a = zzbgm.a(context, zzaniVar, i).k().a(str).a(context).a();
        if (i >= ((Integer) zzwq.e().a(zzabf.cF)).intValue()) {
            return a.b();
        }
        return a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaxq b(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) {
        return zzbgm.a((Context) ObjectWrapper.a(iObjectWrapper), zzaniVar, i).r();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaqw c(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) {
        return zzbgm.a((Context) ObjectWrapper.a(iObjectWrapper), zzaniVar, i).s();
    }
}
