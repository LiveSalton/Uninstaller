package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbft {
    public static zzbdv a(Context context, zzbfn zzbfnVar, String str, boolean z, boolean z2, zzef zzefVar, zzacg zzacgVar, zzazh zzazhVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdmu zzdmuVar, zzdmz zzdmzVar) throws zzbeh {
        try {
            return (zzbdv) com.google.android.gms.ads.internal.util.zzbu.a(new zzdwf(context, zzbfnVar, str, z, z2, zzefVar, zzacgVar, zzazhVar, null, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdmuVar, zzdmzVar) { // from class: com.google.android.gms.internal.ads.jf
                private final Context a;
                private final zzbfn b;
                private final String c;
                private final boolean d;
                private final boolean e;
                private final zzef f;
                private final zzacg g;
                private final zzazh h;
                private final zzabs i = null;
                private final com.google.android.gms.ads.internal.zzk j;
                private final com.google.android.gms.ads.internal.zzb k;
                private final zzts l;
                private final zzsu m;
                private final boolean n;
                private final zzdmu o;
                private final zzdmz p;

                {
                    this.a = context;
                    this.b = zzbfnVar;
                    this.c = str;
                    this.d = z;
                    this.e = z2;
                    this.f = zzefVar;
                    this.g = zzacgVar;
                    this.h = zzazhVar;
                    this.j = zzkVar;
                    this.k = zzbVar;
                    this.l = zztsVar;
                    this.m = zzsuVar;
                    this.n = z3;
                    this.o = zzdmuVar;
                    this.p = zzdmzVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdwf
                public final Object a() {
                    Context context2 = this.a;
                    zzbfn zzbfnVar2 = this.b;
                    String str2 = this.c;
                    boolean z4 = this.d;
                    boolean z5 = this.e;
                    zzef zzefVar2 = this.f;
                    zzacg zzacgVar2 = this.g;
                    zzazh zzazhVar2 = this.h;
                    zzabs zzabsVar3 = this.i;
                    com.google.android.gms.ads.internal.zzk zzkVar2 = this.j;
                    com.google.android.gms.ads.internal.zzb zzbVar2 = this.k;
                    zzts zztsVar2 = this.l;
                    zzsu zzsuVar2 = this.m;
                    boolean z6 = this.n;
                    zzdmu zzdmuVar2 = this.o;
                    zzdmz zzdmzVar2 = this.p;
                    zzbfm zzbfmVar = new zzbfm();
                    jh jhVar = new jh(new zzbfk(context2), zzbfmVar, zzbfnVar2, str2, z4, z5, zzefVar2, zzacgVar2, zzazhVar2, zzabsVar3, zzkVar2, zzbVar2, zztsVar2, zzsuVar2, z6, zzdmuVar2, zzdmzVar2);
                    zzbeg zzbegVar = new zzbeg(jhVar);
                    jhVar.setWebChromeClient(new zzbdn(zzbegVar));
                    zzbfmVar.a(zzbegVar, z5);
                    return zzbegVar;
                }
            });
        } catch (Throwable th) {
            zzp.g().a(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbeh("Webview initialization failed.", th);
        }
    }
}
