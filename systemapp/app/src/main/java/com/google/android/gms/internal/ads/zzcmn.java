package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmn implements zzepf<zzdyz<String>> {
    private final zzeps<zzdro> a;
    private final zzeps<Context> b;

    private zzcmn(zzeps<zzdro> zzepsVar, zzeps<Context> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcmn a(zzeps<zzdro> zzepsVar, zzeps<Context> zzepsVar2) {
        return new zzcmn(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdyz) zzepl.a(this.a.b().a((zzdro) zzdrl.WEBVIEW_COOKIE).a(new Callable(zzp.e().a(this.b.b())) { // from class: com.google.android.gms.internal.ads.vg
            private final CookieManager a;

            {
                this.a = a;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = this.a;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) zzwq.e().a(zzabf.am));
            }
        }).a(1L, TimeUnit.SECONDS).a(Exception.class, vi.a).a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
