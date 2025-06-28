package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfd implements zzdfi<zzdfj<Bundle>> {
    private final zzdzc a;
    private final Context b;

    zzdfd(zzdzc zzdzcVar, Context context) {
        this.a = zzdzcVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aee
            private final zzdfd a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    public static Bundle a(Context context, JSONArray jSONArray) {
        int i;
        Object obj;
        String str;
        SharedPreferences sharedPreferences;
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            switch (optJSONObject.optInt("type", -1)) {
                case 0:
                    i = aeh.a;
                    break;
                case 1:
                    i = aeh.b;
                    break;
                case 2:
                    i = aeh.c;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        SharedPreferences sharedPreferences2 = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                        sharedPreferences = sharedPreferences2;
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    switch (aef.a[i - 1]) {
                        case 1:
                            if (obj instanceof String) {
                                bundle.putString(optString, (String) obj);
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (obj instanceof Integer) {
                                bundle.putInt(optString, ((Integer) obj).intValue());
                                break;
                            } else if (obj instanceof Long) {
                                bundle.putLong(optString, ((Long) obj).longValue());
                                break;
                            } else if (obj instanceof Float) {
                                bundle.putFloat(optString, ((Float) obj).floatValue());
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        return bundle;
    }

    final /* synthetic */ zzdfj b() throws Exception {
        String str = (String) zzwq.e().a(zzabf.f0do);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzdfj(a(this.b, new JSONArray(str))) { // from class: com.google.android.gms.internal.ads.aeg
                private final Bundle a;

                {
                    this.a = a;
                }

                @Override // com.google.android.gms.internal.ads.zzdfj
                public final void a(Object obj) {
                    ((Bundle) obj).putBundle("shared_pref", this.a);
                }
            };
        } catch (JSONException e) {
            zzd.b("JSON parsing error", e);
            return null;
        }
    }
}
