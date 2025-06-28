package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcum {
    private final Clock a;
    private final zzcuo b;
    private final List<String> c = Collections.synchronizedList(new ArrayList());
    private final boolean d = ((Boolean) zzwq.e().a(zzabf.dV)).booleanValue();
    private final zzcrg e;

    public zzcum(Clock clock, zzcuo zzcuoVar, zzcrg zzcrgVar) {
        this.a = clock;
        this.b = zzcuoVar;
        this.e = zzcrgVar;
    }

    final <T> zzdyz<T> a(zzdmz zzdmzVar, zzdmu zzdmuVar, zzdyz<T> zzdyzVar) {
        long b = this.a.b();
        String str = zzdmuVar.v;
        if (str != null) {
            zzdyr.a(zzdyzVar, new zk(this, b, str, zzdmuVar, zzdmzVar), zzazj.f);
        }
        return zzdyzVar;
    }

    public final void a(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(33 + String.valueOf(str).length());
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(1 + String.valueOf(sb2).length() + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.c.add(sb2);
    }

    public final String a() {
        return TextUtils.join("_", this.c);
    }
}
