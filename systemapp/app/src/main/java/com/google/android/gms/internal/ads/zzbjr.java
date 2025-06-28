package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjr implements zzbjn {
    private final zzdms a;

    public zzbjr(zzdms zzdmsVar) {
        this.a = zzdmsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjn
    public final void a(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.a.a(Boolean.parseBoolean(str));
        } catch (Exception unused) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
