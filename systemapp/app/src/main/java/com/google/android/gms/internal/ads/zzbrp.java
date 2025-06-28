package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrp extends zzyq {
    private final String a;
    private final String b;
    private final List<zzvr> c;

    public zzbrp(zzdmu zzdmuVar, String str, zzcrg zzcrgVar) {
        this.b = zzdmuVar == null ? null : zzdmuVar.W;
        String a = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? a(zzdmuVar) : null;
        this.a = a == null ? str : a;
        this.c = zzcrgVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final String b() {
        return this.b;
    }

    private static String a(zzdmu zzdmuVar) {
        try {
            return zzdmuVar.u.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final List<zzvr> c() {
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue()) {
            return this.c;
        }
        return null;
    }
}
