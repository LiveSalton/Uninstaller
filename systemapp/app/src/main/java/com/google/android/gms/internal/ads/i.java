package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class i extends zzaaq<String> {
    i(int i, String str, String str2) {
        super(1, str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ String a(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return bundle.getString(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag."));
        }
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void a(SharedPreferences.Editor editor, String str) {
        editor.putString(a(), str);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ String a(JSONObject jSONObject) {
        return jSONObject.optString(a(), b());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ String a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(a(), b());
    }
}
