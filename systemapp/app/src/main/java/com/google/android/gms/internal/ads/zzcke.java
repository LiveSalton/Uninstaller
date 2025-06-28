package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcke implements zzbry, zzbsm, zzbvz, zzva {
    private final Context a;
    private final zzdoa b;
    private final zzckq c;
    private final zzdnj d;
    private final zzdmu e;
    private final zzcqo f;
    private Boolean g;
    private final boolean h = ((Boolean) zzwq.e().a(zzabf.dU)).booleanValue();

    public zzcke(Context context, zzdoa zzdoaVar, zzckq zzckqVar, zzdnj zzdnjVar, zzdmu zzdmuVar, zzcqo zzcqoVar) {
        this.a = context;
        this.b = zzdoaVar;
        this.c = zzckqVar;
        this.d = zzdnjVar;
        this.e = zzdmuVar;
        this.f = zzcqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        if (this.e.ae) {
            a(a("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        if (c() || this.e.ae) {
            a(a("impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void i_() {
        if (c()) {
            a("adapter_impression").a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void i() {
        if (c()) {
            a("adapter_shown").a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a(zzve zzveVar) {
        if (this.h) {
            zzckp a = a("ifts");
            a.a("reason", "adapter");
            int i = zzveVar.a;
            String str = zzveVar.b;
            if (zzveVar.c.equals("com.google.android.gms.ads") && zzveVar.d != null && !zzveVar.d.c.equals("com.google.android.gms.ads")) {
                i = zzveVar.d.a;
                str = zzveVar.d.b;
            }
            if (i >= 0) {
                a.a("arec", String.valueOf(i));
            }
            String a2 = this.b.a(str);
            if (a2 != null) {
                a.a("areec", a2);
            }
            a.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a(zzcai zzcaiVar) {
        if (this.h) {
            zzckp a = a("ifts");
            a.a("reason", "exception");
            if (!TextUtils.isEmpty(zzcaiVar.getMessage())) {
                a.a("msg", zzcaiVar.getMessage());
            }
            a.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a() {
        if (this.h) {
            zzckp a = a("ifts");
            a.a("reason", "blocked");
            a.a();
        }
    }

    private final boolean c() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    String str = (String) zzwq.e().a(zzabf.aO);
                    zzp.c();
                    this.g = Boolean.valueOf(a(str, com.google.android.gms.ads.internal.util.zzm.n(this.a)));
                }
            }
        }
        return this.g.booleanValue();
    }

    private static boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        try {
            return Pattern.matches(str, str2);
        } catch (RuntimeException e) {
            zzp.g().a(e, "CsiActionsListener.isPatternMatched");
            return false;
        }
    }

    private final zzckp a(String str) {
        zzckp a = this.c.a().a(this.d.b.b).a(this.e);
        a.a("action", str);
        if (!this.e.s.isEmpty()) {
            a.a("ancn", this.e.s.get(0));
        }
        if (this.e.ae) {
            zzp.c();
            a.a("device_connectivity", com.google.android.gms.ads.internal.util.zzm.p(this.a) ? "online" : "offline");
            a.a("event_timestamp", String.valueOf(zzp.j().a()));
            a.a("offline_ad", "1");
        }
        return a;
    }

    private final void a(zzckp zzckpVar) {
        if (this.e.ae) {
            this.f.a(new zzcqv(zzp.j().a(), this.d.b.b.b, zzckpVar.b(), zzcql.b));
            return;
        }
        zzckpVar.a();
    }
}
