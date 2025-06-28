package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcff {
    private final zzdnn a;
    private final Executor b;
    private final zzchp c;

    public zzcff(zzdnn zzdnnVar, Executor executor, zzchp zzchpVar) {
        this.a = zzdnnVar;
        this.b = executor;
        this.c = zzchpVar;
    }

    public final zzdyz<zzbdv> a(JSONObject jSONObject) {
        return zzdyr.a(zzdyr.a(zzdyr.a((Object) null), new zzdyb(this) { // from class: com.google.android.gms.internal.ads.sj
            private final zzcff a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(obj);
            }
        }, this.b), new zzdyb(this, jSONObject) { // from class: com.google.android.gms.internal.ads.sh
            private final zzcff a;
            private final JSONObject b;

            {
                this.a = this;
                this.b = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, (zzbdv) obj);
            }
        }, this.b);
    }

    public final zzdyz<zzbdv> a(String str, String str2) {
        return zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, str, str2) { // from class: com.google.android.gms.internal.ads.sg
            private final zzcff a;
            private final String b;
            private final String c;

            {
                this.a = this;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, obj);
            }
        }, this.b);
    }

    private final void a(zzbdv zzbdvVar) {
        zzbdvVar.a("/video", zzahc.m);
        zzbdvVar.a("/videoMeta", zzahc.n);
        zzbdvVar.a("/precache", new zzbdc());
        zzbdvVar.a("/delayPageLoaded", zzahc.q);
        zzbdvVar.a("/instrument", zzahc.o);
        zzbdvVar.a("/log", zzahc.h);
        zzbdvVar.a("/videoClicked", zzahc.i);
        zzbdvVar.z().c(true);
        zzbdvVar.a("/click", zzahc.d);
        if (((Boolean) zzwq.e().a(zzabf.bB)).booleanValue()) {
            zzbdvVar.a("/getNativeAdViewSignals", zzahc.t);
        }
        if (this.a.c != null) {
            zzbdvVar.z().d(true);
            zzbdvVar.a("/open", new zzahz(null, null, null, null));
        } else {
            zzbdvVar.z().d(false);
        }
        if (zzp.A().a(zzbdvVar.getContext())) {
            zzbdvVar.a("/logScionEvent", new zzahx(zzbdvVar.getContext()));
        }
    }

    final /* synthetic */ zzdyz a(Object obj) throws Exception {
        zzbdv a = this.c.a(zzvn.a());
        zzazr a2 = zzazr.a(a);
        a(a);
        a.z().a(new zzbfi(a2) { // from class: com.google.android.gms.internal.ads.si
            private final zzazr a;

            {
                this.a = a2;
            }

            @Override // com.google.android.gms.internal.ads.zzbfi
            public final void a() {
                this.a.a();
            }
        });
        a.loadUrl((String) zzwq.e().a(zzabf.bA));
        return a2;
    }

    final /* synthetic */ zzdyz a(String str, String str2, Object obj) throws Exception {
        zzbdv a = this.c.a(zzvn.a());
        zzazr a2 = zzazr.a(a);
        a(a);
        if (this.a.c != null) {
            a.a(zzbfn.c());
        } else {
            a.a(zzbfn.b());
        }
        a.z().a(new zzbfj(this, a, a2) { // from class: com.google.android.gms.internal.ads.sl
            private final zzcff a;
            private final zzbdv b;
            private final zzazr c;

            {
                this.a = this;
                this.b = a;
                this.c = a2;
            }

            @Override // com.google.android.gms.internal.ads.zzbfj
            public final void a(boolean z) {
                this.a.a(this.b, this.c, z);
            }
        });
        a.a(str, str2, (String) null);
        return a2;
    }

    final /* synthetic */ void a(zzbdv zzbdvVar, zzazr zzazrVar, boolean z) {
        if (z) {
            if (this.a.b != null && zzbdvVar.d() != null) {
                zzbdvVar.d().a(this.a.b);
            }
            zzazrVar.a();
            return;
        }
        zzazrVar.a((Throwable) new zzcuq(zzdok.INTERNAL_ERROR, "Instream video Web View failed to load."));
    }

    final /* synthetic */ zzdyz a(JSONObject jSONObject, zzbdv zzbdvVar) throws Exception {
        zzazr a = zzazr.a(zzbdvVar);
        if (this.a.c != null) {
            zzbdvVar.a(zzbfn.c());
        } else {
            zzbdvVar.a(zzbfn.b());
        }
        zzbdvVar.z().a(new zzbfj(this, zzbdvVar, a) { // from class: com.google.android.gms.internal.ads.sk
            private final zzcff a;
            private final zzbdv b;
            private final zzazr c;

            {
                this.a = this;
                this.b = zzbdvVar;
                this.c = a;
            }

            @Override // com.google.android.gms.internal.ads.zzbfj
            public final void a(boolean z) {
                this.a.b(this.b, this.c, z);
            }
        });
        zzbdvVar.a("google.afma.nativeAds.renderVideo", jSONObject);
        return a;
    }

    final /* synthetic */ void b(zzbdv zzbdvVar, zzazr zzazrVar, boolean z) {
        if (this.a.b != null && zzbdvVar.d() != null) {
            zzbdvVar.d().a(this.a.b);
        }
        zzazrVar.a();
    }
}
