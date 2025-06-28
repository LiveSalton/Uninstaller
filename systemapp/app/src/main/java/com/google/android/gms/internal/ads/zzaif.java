package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaif implements zzahv<Object> {
    private final Object a = new Object();

    @GuardedBy("lock")
    private final Map<String, zzaih> b = new HashMap();

    public final void a(String str, zzaih zzaihVar) {
        synchronized (this.a) {
            this.b.put(str, zzaihVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        String concat;
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            concat = "";
        } else {
            String valueOf = String.valueOf(str4);
            concat = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.a) {
            zzaih remove = this.b.remove(str);
            if (remove == null) {
                String valueOf2 = String.valueOf(str);
                zzd.e(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                String valueOf3 = String.valueOf(str3);
                String valueOf4 = String.valueOf(concat);
                remove.a(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else {
                if (str5 == null) {
                    remove.a((JSONObject) null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (zzd.a()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzd.a(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.a(jSONObject);
                } catch (JSONException e) {
                    remove.a(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzaky> zzdyz<JSONObject> a(EngineT enginet, String str, JSONObject jSONObject) {
        zzazq zzazqVar = new zzazq();
        zzp.c();
        String a = com.google.android.gms.ads.internal.util.zzm.a();
        a(a, new av(this, zzazqVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", a);
            jSONObject2.put("args", jSONObject);
            enginet.a(str, jSONObject2);
        } catch (Exception e) {
            zzazqVar.a(e);
        }
        return zzazqVar;
    }
}
