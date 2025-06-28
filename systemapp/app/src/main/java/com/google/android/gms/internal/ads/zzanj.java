package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzanj extends zzanl {
    private static final zzapu b = new zzapu();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> a;

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzann a(String str) throws RemoteException {
        return d(str);
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final boolean b(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzanj.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(80 + String.valueOf(str).length());
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzaza.e(sb.toString());
            return false;
        }
    }

    public final void a(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.a = map;
    }

    private final <NetworkExtrasT extends com.google.ads.mediation.f, ServerParametersT extends com.google.ads.mediation.e> zzann d(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzanj.class.getClassLoader());
            if (com.google.ads.mediation.b.class.isAssignableFrom(cls)) {
                com.google.ads.mediation.b bVar = (com.google.ads.mediation.b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzaom(bVar, (com.google.ads.mediation.f) this.a.get(bVar.getAdditionalParametersType()));
            }
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzaoe((MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            if (Adapter.class.isAssignableFrom(cls)) {
                return new zzaoe((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            StringBuilder sb = new StringBuilder(64 + String.valueOf(str).length());
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(" (not a valid adapter).");
            zzaza.e(sb.toString());
            throw new RemoteException();
        } catch (Throwable unused) {
            return e(str);
        }
    }

    private final zzann e(String str) throws RemoteException {
        try {
            zzaza.b("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(43 + String.valueOf(str).length());
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzaza.d(sb.toString(), th);
        }
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzaoe(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzaoe(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new zzaoe(new CustomEventAdapter());
        }
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new zzaom(customEventAdapter, (CustomEventExtras) this.a.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzani
    public final zzapo c(String str) throws RemoteException {
        return zzapu.a(str);
    }
}
