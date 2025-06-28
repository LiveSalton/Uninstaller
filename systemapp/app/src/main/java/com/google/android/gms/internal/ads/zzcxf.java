package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxf extends zzaps {
    private final String a;
    private final zzapo b;
    private zzazq<JSONObject> c;
    private final JSONObject d = new JSONObject();

    @GuardedBy("this")
    private boolean e = false;

    public zzcxf(String str, zzapo zzapoVar, zzazq<JSONObject> zzazqVar) {
        this.c = zzazqVar;
        this.a = str;
        this.b = zzapoVar;
        try {
            this.d.put("adapter_version", this.b.a().toString());
            this.d.put("sdk_version", this.b.b().toString());
            this.d.put("name", this.a);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final synchronized void a(String str) throws RemoteException {
        if (this.e) {
            return;
        }
        if (str == null) {
            b("Adapter returned null signals");
            return;
        }
        try {
            this.d.put("signals", str);
        } catch (JSONException unused) {
        }
        this.c.b(this.d);
        this.e = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final synchronized void b(String str) throws RemoteException {
        if (this.e) {
            return;
        }
        try {
            this.d.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.c.b(this.d);
        this.e = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final synchronized void a(zzve zzveVar) throws RemoteException {
        if (this.e) {
            return;
        }
        try {
            this.d.put("signal_error", zzveVar.b);
        } catch (JSONException unused) {
        }
        this.c.b(this.d);
        this.e = true;
    }
}
