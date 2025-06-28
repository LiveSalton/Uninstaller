package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjs implements zzbjn {
    private zzf a;

    public zzbjs(zzf zzfVar) {
        this.a = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjn
    public final void a(Map<String, String> map) {
        this.a.b(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
