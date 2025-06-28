package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzyn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class ResponseInfo {
    private final zzyn a;
    private final List<AdapterResponseInfo> b = new ArrayList();

    private ResponseInfo(zzyn zzynVar) {
        this.a = zzynVar;
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue()) {
            try {
                List<zzvr> c = this.a.c();
                if (c != null) {
                    Iterator<zzvr> it = c.iterator();
                    while (it.hasNext()) {
                        this.b.add(AdapterResponseInfo.a(it.next()));
                    }
                }
            } catch (RemoteException e) {
                zzaza.c("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
    }

    public final String a() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            zzaza.c("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public final String b() {
        try {
            return this.a.b();
        } catch (RemoteException e) {
            zzaza.c("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    public final JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String b = b();
        if (b == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", b);
        }
        String a = a();
        if (a == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", a);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<AdapterResponseInfo> it = this.b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }

    public final String toString() {
        try {
            return c().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public static ResponseInfo a(zzyn zzynVar) {
        if (zzynVar != null) {
            return new ResponseInfo(zzynVar);
        }
        return null;
    }
}
