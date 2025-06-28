package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzdfp implements zzdfj<Bundle> {
    private final boolean a;
    private final boolean b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final String g;
    private final ArrayList<String> h;
    private final String i;
    private final String j;
    private final String k;
    private final boolean l;
    private final String m;
    private final long n;

    public zzdfp(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.a = z;
        this.b = z2;
        this.c = str;
        this.d = z3;
        this.e = z4;
        this.f = z5;
        this.g = str2;
        this.h = arrayList;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = z6;
        this.m = str6;
        this.n = j;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("cog", this.a);
        bundle2.putBoolean("coh", this.b);
        bundle2.putString("gl", this.c);
        bundle2.putBoolean("simulator", this.d);
        bundle2.putBoolean("is_latchsky", this.e);
        bundle2.putBoolean("is_sidewinder", this.f);
        bundle2.putString("hl", this.g);
        if (!this.h.isEmpty()) {
            bundle2.putStringArrayList("hl_list", this.h);
        }
        bundle2.putString("mv", this.i);
        bundle2.putString("submodel", this.m);
        Bundle a = zzdnx.a(bundle2, "device");
        bundle2.putBundle("device", a);
        a.putString("build", this.k);
        if (((Boolean) zzwq.e().a(zzabf.bx)).booleanValue()) {
            a.putLong("remaining_data_partition_space", this.n);
        }
        Bundle a2 = zzdnx.a(a, "browser");
        a.putBundle("browser", a2);
        a2.putBoolean("is_browser_custom_tabs_capable", this.l);
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        Bundle a3 = zzdnx.a(a, "play_store");
        a.putBundle("play_store", a3);
        a3.putString("package_version", this.j);
    }
}
