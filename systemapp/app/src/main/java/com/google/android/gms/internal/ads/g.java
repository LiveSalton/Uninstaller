package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class g extends zzaaq<Float> {
    g(int i, String str, Float f) {
        super(1, str, f, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Float a(Bundle bundle) {
        String valueOf = String.valueOf(a());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(a());
            return Float.valueOf(bundle.getFloat(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return b();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ void a(SharedPreferences.Editor editor, Float f) {
        editor.putFloat(a(), f.floatValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Float a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(a(), b().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* synthetic */ Float a(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(a(), b().floatValue()));
    }
}
