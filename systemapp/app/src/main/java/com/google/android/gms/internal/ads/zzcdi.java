package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcdi {
    private final zzchp a;
    private final zzcgh b;
    private final zzbkr c;
    private final zzccm d;

    public zzcdi(zzchp zzchpVar, zzcgh zzcghVar, zzbkr zzbkrVar, zzccm zzccmVar) {
        this.a = zzchpVar;
        this.b = zzcghVar;
        this.c = zzbkrVar;
        this.d = zzccmVar;
    }

    public final View a() throws zzbeh {
        zzbdv a = this.a.a(zzvn.a());
        a.getView().setVisibility(8);
        a.a("/sendMessageToSdk", new zzahv(this) { // from class: com.google.android.gms.internal.ads.rg
            private final zzcdi a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.d((zzbdv) obj, map);
            }
        });
        a.a("/adMuted", new zzahv(this) { // from class: com.google.android.gms.internal.ads.ri
            private final zzcdi a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.c((zzbdv) obj, map);
            }
        });
        this.b.a(new WeakReference(a), "/loadHtml", new zzahv(this) { // from class: com.google.android.gms.internal.ads.rh
            private final zzcdi a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, final Map map) {
                final zzcdi zzcdiVar = this.a;
                zzbdv zzbdvVar = (zzbdv) obj;
                zzbdvVar.z().a(new zzbfj(zzcdiVar, map) { // from class: com.google.android.gms.internal.ads.rl
                    private final zzcdi a;
                    private final Map b;

                    {
                        this.a = zzcdiVar;
                        this.b = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbfj
                    public final void a(boolean z) {
                        this.a.a(this.b, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbdvVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzbdvVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.b.a(new WeakReference(a), "/showOverlay", new zzahv(this) { // from class: com.google.android.gms.internal.ads.rk
            private final zzcdi a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.b((zzbdv) obj, map);
            }
        });
        this.b.a(new WeakReference(a), "/hideOverlay", new zzahv(this) { // from class: com.google.android.gms.internal.ads.rj
            private final zzcdi a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.a((zzbdv) obj, map);
            }
        });
        return a.getView();
    }

    final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzd.d("Hiding native ads overlay.");
        zzbdvVar.getView().setVisibility(8);
        this.c.a(false);
    }

    final /* synthetic */ void b(zzbdv zzbdvVar, Map map) {
        zzd.d("Showing native ads overlay.");
        zzbdvVar.getView().setVisibility(0);
        this.c.a(true);
    }

    final /* synthetic */ void a(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.b.a("sendMessageToNativeJs", hashMap);
    }

    final /* synthetic */ void c(zzbdv zzbdvVar, Map map) {
        this.d.e();
    }

    final /* synthetic */ void d(zzbdv zzbdvVar, Map map) {
        this.b.a("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
