package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzvx {
    private final zzvi a;
    private final zzvf b;
    private final zzzp c;
    private final zzagn d;
    private final zzaut e;
    private final zzavx f;
    private final zzarh g;
    private final zzagm h;

    public zzvx(zzvi zzviVar, zzvf zzvfVar, zzzp zzzpVar, zzagn zzagnVar, zzaut zzautVar, zzavx zzavxVar, zzarh zzarhVar, zzagm zzagmVar) {
        this.a = zzviVar;
        this.b = zzvfVar;
        this.c = zzzpVar;
        this.d = zzagnVar;
        this.e = zzautVar;
        this.f = zzavxVar;
        this.g = zzarhVar;
        this.h = zzagmVar;
    }

    public static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzwq.a().a(context, zzwq.g().a, "gmob-apps", bundle, true);
    }

    public final zzxg a(Context context, zzvn zzvnVar, String str, zzani zzaniVar) {
        return new bea(this, context, zzvnVar, str, zzaniVar).a(context, false);
    }

    public final zzwz a(Context context, String str, zzani zzaniVar) {
        return new bef(this, context, str, zzaniVar).a(context, false);
    }

    public final zzaen a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new beg(this, frameLayout, frameLayout2, context).a(context, false);
    }

    public final zzavh b(Context context, String str, zzani zzaniVar) {
        return new bdw(this, context, str, zzaniVar).a(context, false);
    }

    public final zzarj a(Activity activity) {
        bdy bdyVar = new bdy(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzaza.c("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return bdyVar.a(activity, z);
    }

    public final zzaqw a(Context context, zzani zzaniVar) {
        return new bdz(this, context, zzaniVar).a(context, false);
    }
}
