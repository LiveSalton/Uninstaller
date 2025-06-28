package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnr implements zzbsm, zzbtj {
    private final Context a;
    private final zzbdv b;
    private final zzdmu c;
    private final zzazh d;

    @GuardedBy("this")
    private IObjectWrapper e;

    @GuardedBy("this")
    private boolean f;

    public zzbnr(Context context, zzbdv zzbdvVar, zzdmu zzdmuVar, zzazh zzazhVar) {
        this.a = context;
        this.b = zzbdvVar;
        this.c = zzdmuVar;
        this.d = zzazhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final synchronized void a() {
        if (this.f) {
            return;
        }
        c();
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void b() {
        if (!this.f) {
            c();
        }
        if (this.c.N && this.e != null && this.b != null) {
            this.b.a("onSdkImpression", new androidx.b.a());
        }
    }

    private final synchronized void c() {
        zzare zzareVar;
        zzarg zzargVar;
        if (this.c.N) {
            if (this.b == null) {
                return;
            }
            if (zzp.r().a(this.a)) {
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
                        zzargVar = zzarg.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzareVar = zzare.HTML_DISPLAY;
                        if (this.c.e == 1) {
                            zzargVar = zzarg.ONE_PIXEL;
                        } else {
                            zzargVar = zzarg.BEGIN_TO_RENDER;
                        }
                    }
                    this.e = zzp.r().a(sb2, this.b.getWebView(), "", "javascript", b, zzargVar, zzareVar, this.c.ag);
                } else {
                    this.e = zzp.r().a(sb2, this.b.getWebView(), "", "javascript", b);
                }
                View view = this.b.getView();
                if (this.e != null && view != null) {
                    zzp.r().a(this.e, view);
                    this.b.a(this.e);
                    zzp.r().a(this.e);
                    this.f = true;
                    if (((Boolean) zzwq.e().a(zzabf.cD)).booleanValue()) {
                        this.b.a("onSdkLoaded", new androidx.b.a());
                    }
                }
            }
        }
    }
}
