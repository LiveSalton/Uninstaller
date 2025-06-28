package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdai implements zzdfj<Bundle> {
    private final zzvn a;
    private final String b;
    private final boolean c;
    private final String d;
    private final float e;
    private final int f;
    private final int g;
    private final String h;
    private final boolean i;

    public zzdai(zzvn zzvnVar, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.a(zzvnVar, "the adSize must not be null");
        this.a = zzvnVar;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = f;
        this.f = i;
        this.g = i2;
        this.h = str3;
        this.i = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdnx.a(bundle2, "smart_w", "full", this.a.e == -1);
        zzdnx.a(bundle2, "smart_h", "auto", this.a.b == -2);
        zzdnx.a(bundle2, "ene", (Boolean) true, this.a.j);
        zzdnx.a(bundle2, "rafmt", "102", this.a.l);
        zzdnx.a(bundle2, "rafmt", "103", this.a.m);
        zzdnx.a(bundle2, "inline_adaptive_slot", (Boolean) true, this.i);
        zzdnx.a(bundle2, "format", this.b);
        zzdnx.a(bundle2, "fluid", "height", this.c);
        zzdnx.a(bundle2, "sz", this.d, !TextUtils.isEmpty(this.d));
        bundle2.putFloat("u_sd", this.e);
        bundle2.putInt("sw", this.f);
        bundle2.putInt("sh", this.g);
        zzdnx.a(bundle2, "sc", this.h, !TextUtils.isEmpty(this.h));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (this.a.g == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("height", this.a.b);
            bundle3.putInt("width", this.a.e);
            bundle3.putBoolean("is_fluid_height", this.a.i);
            arrayList.add(bundle3);
        } else {
            for (zzvn zzvnVar : this.a.g) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzvnVar.i);
                bundle4.putInt("height", zzvnVar.b);
                bundle4.putInt("width", zzvnVar.e);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
