package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbed {
    public static zzdyz<zzbdv> a(Context context, zzazh zzazhVar, String str, zzef zzefVar, com.google.android.gms.ads.internal.zzb zzbVar) {
        return zzdyr.a(zzdyr.a((Object) null), new zzdyb(context, zzefVar, zzazhVar, zzbVar, str) { // from class: com.google.android.gms.internal.ads.io
            private final Context a;
            private final zzef b;
            private final zzazh c;
            private final com.google.android.gms.ads.internal.zzb d;
            private final String e;

            {
                this.a = context;
                this.b = zzefVar;
                this.c = zzazhVar;
                this.d = zzbVar;
                this.e = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                Context context2 = this.a;
                zzef zzefVar2 = this.b;
                zzazh zzazhVar2 = this.c;
                com.google.android.gms.ads.internal.zzb zzbVar2 = this.d;
                String str2 = this.e;
                zzp.d();
                zzbdv a = zzbed.a(context2, zzbfn.a(), "", false, false, zzefVar2, null, zzazhVar2, null, null, zzbVar2, zzts.a(), null, false, null, null);
                final zzazr a2 = zzazr.a(a);
                a.z().a(new zzbfj(a2) { // from class: com.google.android.gms.internal.ads.ip
                    private final zzazr a;

                    {
                        this.a = a2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbfj
                    public final void a(boolean z) {
                        this.a.a();
                    }
                });
                a.loadUrl(str2);
                return a2;
            }
        }, zzazj.e);
    }

    public static zzbdv a(Context context, zzbfn zzbfnVar, String str, boolean z, boolean z2, zzef zzefVar, zzacg zzacgVar, zzazh zzazhVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdmu zzdmuVar, zzdmz zzdmzVar) throws zzbeh {
        zzabf.a(context);
        if (zzadm.b.a().booleanValue()) {
            return zzbft.a(context, zzbfnVar, str, z, z2, zzefVar, zzacgVar, zzazhVar, null, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdmuVar, zzdmzVar);
        }
        try {
            return (zzbdv) com.google.android.gms.ads.internal.util.zzbu.a(new zzdwf(context, zzbfnVar, str, z, z2, zzefVar, zzacgVar, zzazhVar, null, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdmuVar, zzdmzVar) { // from class: com.google.android.gms.internal.ads.iq
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
                    com.google.android.gms.ads.internal.zzk zzkVar2 = this.j;
                    com.google.android.gms.ads.internal.zzb zzbVar2 = this.k;
                    zzts zztsVar2 = this.l;
                    zzbeg zzbegVar = new zzbeg(iu.a(context2, zzbfnVar2, str2, z4, z5, zzefVar2, zzacgVar2, zzazhVar2, null, zzkVar2, zzbVar2, zztsVar2, this.m, this.n, this.o, this.p));
                    zzbegVar.setWebViewClient(zzp.e().a(zzbegVar, zztsVar2, z5));
                    zzbegVar.setWebChromeClient(new zzbdn(zzbegVar));
                    return zzbegVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbeh("Webview initialization failed.", th);
        }
    }
}
