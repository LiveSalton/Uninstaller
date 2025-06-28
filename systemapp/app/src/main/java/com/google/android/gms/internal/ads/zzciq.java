package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzciq {
    private final zzcil a;
    private final AtomicReference<zzani> b = new AtomicReference<>();

    zzciq(zzcil zzcilVar) {
        this.a = zzcilVar;
    }

    public final void a(zzani zzaniVar) {
        this.b.compareAndSet(null, zzaniVar);
    }

    public final zzdoe a(String str, JSONObject jSONObject) throws zzdnr {
        zzann b;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                b = new zzaoe(new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                b = new zzaoe(new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                b = new zzaoe(new zzaqe());
            } else {
                b = b(str, jSONObject);
            }
            zzdoe zzdoeVar = new zzdoe(b);
            this.a.a(str, zzdoeVar);
            return zzdoeVar;
        } catch (Throwable th) {
            throw new zzdnr(th);
        }
    }

    public final zzapo a(String str) throws RemoteException {
        zzapo c = b().c(str);
        this.a.a(str, c);
        return c;
    }

    public final boolean a() {
        return this.b.get() != null;
    }

    private final zzann b(String str, JSONObject jSONObject) throws RemoteException {
        zzani b = b();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (b.b(jSONObject.getString("class_name"))) {
                    return b.a("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return b.a("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzd.c("Invalid custom event.", e);
            }
        }
        return b.a(str);
    }

    private final zzani b() throws RemoteException {
        zzani zzaniVar = this.b.get();
        if (zzaniVar != null) {
            return zzaniVar;
        }
        zzd.e("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
