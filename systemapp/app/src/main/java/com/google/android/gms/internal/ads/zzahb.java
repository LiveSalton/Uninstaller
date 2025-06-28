package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzahb implements zzahv<Object> {
    private final zzaha a;

    public zzahb(zzaha zzahaVar) {
        this.a = zzahaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzd.e("App event with no name parameter.");
        } else {
            this.a.a(str, map.get("info"));
        }
    }
}
