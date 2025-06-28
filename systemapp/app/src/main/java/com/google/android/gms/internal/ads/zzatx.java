package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzatx extends zzatz {
    private final Object a = new Object();
    private final Context b;
    private SharedPreferences c;
    private final zzamd<JSONObject, JSONObject> d;

    public zzatx(Context context, zzamd<JSONObject, JSONObject> zzamdVar) {
        this.b = context.getApplicationContext();
        this.d = zzamdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final zzdyz<Void> a() {
        synchronized (this.a) {
            if (this.c == null) {
                this.c = this.b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzp.j().a() - this.c.getLong("js_last_update", 0L) < zzadb.b.a().longValue()) {
            return zzdyr.a((Object) null);
        }
        return zzdyr.a(this.d.b(a(this.b)), new zzdvm(this) { // from class: com.google.android.gms.internal.ads.dz
            private final zzatx a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return this.a.a((JSONObject) obj);
            }
        }, zzazj.f);
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzazh.a().a);
            jSONObject.put("mf", zzadb.a.a());
            jSONObject.put("cl", "334274230");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.a);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.b(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    final /* synthetic */ Void a(JSONObject jSONObject) {
        zzabf.a(this.b, 1, jSONObject);
        this.c.edit().putLong("js_last_update", zzp.j().a()).apply();
        return null;
    }
}
