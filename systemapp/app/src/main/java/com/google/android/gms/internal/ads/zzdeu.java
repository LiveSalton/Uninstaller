package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdeu implements zzdfj<Bundle> {
    private final boolean a;
    private final boolean b;
    private final String c;
    private final boolean d;
    private final int e;
    private final int f;
    private final int g;

    public zzdeu(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.a = z;
        this.b = z2;
        this.c = str;
        this.d = z3;
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.c);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzwq.e().a(zzabf.by));
        bundle2.putInt("target_api", this.e);
        bundle2.putInt("dv", this.f);
        bundle2.putInt("lv", this.g);
        Bundle a = zzdnx.a(bundle2, "sdk_env");
        a.putBoolean("mf", zzadb.a.a().booleanValue());
        a.putBoolean("instant_app", this.a);
        a.putBoolean("lite", this.b);
        a.putBoolean("is_privileged_process", this.d);
        bundle2.putBundle("sdk_env", a);
        Bundle a2 = zzdnx.a(a, "build_meta");
        a2.putString("cl", "334274230");
        a2.putString("rapid_rc", "dev");
        a2.putString("rapid_rollup", "HEAD");
        a.putBundle("build_meta", a2);
    }
}
