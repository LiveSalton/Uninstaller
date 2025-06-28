package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class f extends zzaaq<Boolean> {
    f(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Boolean a(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Boolean.valueOf(bundle.getBoolean(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void a(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(a(), bool.booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Boolean a(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(a(), b().booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Boolean a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(a(), b().booleanValue()));
    }
}
