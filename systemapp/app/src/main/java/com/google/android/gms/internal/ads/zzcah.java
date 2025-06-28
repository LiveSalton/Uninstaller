package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcah implements zzp, zzbtj {
    private final Context a;
    private final zzbdv b;
    private final zzdmu c;
    private final zzazh d;
    private final zzue.zza.EnumC0075zza e;

    @VisibleForTesting
    private IObjectWrapper f;

    public zzcah(Context context, zzbdv zzbdvVar, zzdmu zzdmuVar, zzazh zzazhVar, zzue.zza.EnumC0075zza enumC0075zza) {
        this.a = context;
        this.b = zzbdvVar;
        this.c = zzdmuVar;
        this.d = zzazhVar;
        this.e = enumC0075zza;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        zzarg zzargVar;
        zzarg zzargVar2;
        zzare zzareVar;
        if ((this.e == zzue.zza.EnumC0075zza.REWARD_BASED_VIDEO_AD || this.e == zzue.zza.EnumC0075zza.INTERSTITIAL || this.e == zzue.zza.EnumC0075zza.APP_OPEN) && this.c.N && this.b != null && com.google.android.gms.ads.internal.zzp.r().a(this.a)) {
            int i = this.d.b;
            int i2 = this.d.c;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            String sb2 = sb.toString();
            String b = this.c.P.b();
            if (((Boolean) zzwq.e().a(zzabf.cB)).booleanValue()) {
                if (this.c.P.a() == OmidMediaType.VIDEO) {
                    zzareVar = zzare.VIDEO;
                    zzargVar2 = zzarg.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.c.S == 2) {
                        zzargVar = zzarg.UNSPECIFIED;
                    } else {
                        zzargVar = zzarg.BEGIN_TO_RENDER;
                    }
                    zzargVar2 = zzargVar;
                    zzareVar = zzare.HTML_DISPLAY;
                }
                this.f = com.google.android.gms.ads.internal.zzp.r().a(sb2, this.b.getWebView(), "", "javascript", b, zzargVar2, zzareVar, this.c.ag);
            } else {
                this.f = com.google.android.gms.ads.internal.zzp.r().a(sb2, this.b.getWebView(), "", "javascript", b);
            }
            if (this.f == null || this.b.getView() == null) {
                return;
            }
            com.google.android.gms.ads.internal.zzp.r().a(this.f, this.b.getView());
            this.b.a(this.f);
            com.google.android.gms.ads.internal.zzp.r().a(this.f);
            if (((Boolean) zzwq.e().a(zzabf.cD)).booleanValue()) {
                this.b.a("onSdkLoaded", new androidx.b.a());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.f = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        if (this.f == null || this.b == null) {
            return;
        }
        this.b.a("onSdkImpression", new androidx.b.a());
    }
}
