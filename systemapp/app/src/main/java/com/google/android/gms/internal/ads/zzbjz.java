package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjz {
    private final String a;
    private final zzamq b;
    private final Executor c;
    private zzbki d;
    private final zzahv<Object> e = new lg(this);
    private final zzahv<Object> f = new li(this);

    public zzbjz(String str, zzamq zzamqVar, Executor executor) {
        this.a = str;
        this.b = zzamqVar;
        this.c = executor;
    }

    public final void a(zzbki zzbkiVar) {
        this.b.a("/updateActiveView", this.e);
        this.b.a("/untrackActiveViewUnit", this.f);
        this.d = zzbkiVar;
    }

    public final void a(zzbdv zzbdvVar) {
        zzbdvVar.a("/updateActiveView", this.e);
        zzbdvVar.a("/untrackActiveViewUnit", this.f);
    }

    public final void b(zzbdv zzbdvVar) {
        zzbdvVar.b("/updateActiveView", this.e);
        zzbdvVar.b("/untrackActiveViewUnit", this.f);
    }

    public final void a() {
        this.b.b("/updateActiveView", this.e);
        this.b.b("/untrackActiveViewUnit", this.f);
    }

    public final boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.a);
    }
}
