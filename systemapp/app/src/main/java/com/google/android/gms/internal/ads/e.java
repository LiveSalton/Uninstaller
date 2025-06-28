package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class e extends zzaaq<Integer> {
    e(int i, String str, Integer num) {
        super(1, str, num, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Integer a(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void a(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(a(), num.intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Integer a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(a(), b().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Integer a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(a(), b().intValue()));
    }
}
