package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class h extends zzaaq<Long> {
    h(int i, String str, Long l) {
        super(1, str, l, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Long a(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void a(SharedPreferences.Editor editor, Long l) {
        editor.putLong(a(), l.longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Long a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(a(), b().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Long a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(a(), b().longValue()));
    }
}
